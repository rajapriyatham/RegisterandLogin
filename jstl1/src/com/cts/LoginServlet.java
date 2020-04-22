package com.cts;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao userDao = new UserDaoImpl();
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		User user = userDao.checkLoginCredential(username, password);
		ArrayList<User> allUserDetails = userDao.getAlluserDetails();
        System.out.println(allUserDetails);
		if (user!=null) {
			request.setAttribute("user", user);
			request.setAttribute("userList",allUserDetails);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Account Invalid");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		doGet(request, response); 
	}

}
