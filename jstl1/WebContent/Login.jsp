<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<h2>Sign in to Account</h2>
		Username<input type="text" name="uname" required="required">
		<br>
		Password<input type="password" name="psw" required="required">
		<br>
		<input type="submit" value="Login"><input type="checkbox" id="check" name="check" value="Remember me"><label for="check"> Remember me</label><br>
		<input type="reset" value="Reset"><h4>Dont have an account</h4><a href="Registe.jsp">Sign Up</a>
	</form>
</body>
</html>