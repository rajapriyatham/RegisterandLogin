<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		<h2>Register</h2>
		<br>
		Username
		<input type="text" name="username" required="required">
		<br><br>
		Email
		<input type="email" name="email" required="required">
		<br><br>
		Password
		<input type="password" name="password" required="required">
		<br><br>
		Mobile
		<input type="number" name="mobile" required="required">
		<br><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>