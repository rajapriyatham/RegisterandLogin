package com.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
	public static String url = "jdbc:mysql://localhost:3306/cognizant";
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";
	public static ArrayList<User> userList;

	public Connection getDbConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find the Driver");
		}
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to Connect with DB");
		}
		return con;

	}

	@Override
	public String addUserDetail(User user) {
		System.out.println("inside adduserdetail");
		System.out.println(user);
		Connection con = getDbConnection();
		System.out.println(con);
		if (con != null) {
			String sql = "insert into user(username,password,email,mobile) values(?,?,?,?)";
			try {
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, user.getUsername());
				psmt.setString(2, user.getPassword());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getMobile());
				int noofrowsAffected = psmt.executeUpdate();
				System.out.println(noofrowsAffected);
				if (noofrowsAffected > 0) {
					System.out.println("Data inserted successful");
					return "Data inserted successful";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;

	}

	@Override
	public ArrayList<User> getAlluserDetails() {
		ArrayList<User> userList=new ArrayList<User>();
		Connection connection = getDbConnection();
		//String sql = "select * from user";
		try {
			// Step 2 : Get Statement Object using connection
			PreparedStatement psmt = connection.prepareStatement("select * from user");
			// Step 3 : Execute the Query
			ResultSet rs = psmt.executeQuery();
			// Step 4 : Process the ResultSet and print the values
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println("--> " + userList);
		return userList;
	}

	@Override
	public User checkLoginCredential(String username, String password) {
		System.out.println("inside checklogin");
		System.out.println(username);
		System.out.println(password);
		Connection con = getDbConnection();
		System.out.println(con);// null or not
		User user = null;
		String sql = "select * from user where username=? and password=?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(user.getEmail());
		return user;
	}

	@Override
	public User getUserById(Integer userId) {
		User user=null;
		Connection con=getDbConnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement("select * from user where id=?");
			psmt.setInt(1,userId);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean updateUserById(User user) {
		Connection con=getDbConnection();
		String sql="update user set username=?,password=?,email=?,mobile=? where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2,user.getPassword());
			psmt.setString(3, user.getEmail());
			psmt.setString(4, user.getMobile());
			psmt.setInt(5,user.getId());
			int executeUpdate = psmt.executeUpdate();
			if(executeUpdate>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		Connection con=getDbConnection();
		String sql = "delete from user where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1,userId);
			int no=psmt.executeUpdate();
			if(no>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
