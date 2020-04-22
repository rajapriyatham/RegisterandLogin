<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty user}">
		<h3>Login Failed</h3>
	</c:if>
	<c:if test="${not empty user}">
		<h3>welcome Admin</h3>
		<h4>list of users</h4>
		<table border="1">
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>mobile</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.mobile}</td>
						<td><a href="EditServlet?userId=${user.id}">Edit</a>  :  <a href="DeleteServlet?empId=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
	</c:if>
	
</body>
</html>