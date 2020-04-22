<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	/*IN action=, we qive url pattern given in web.xml*/
	<form action="LoginServlet" method="get">
		Username<input type="text" name="username" required="required">
		<br>
		DOJ<input type="date" name="doj" required="required">
		<br>
		Mobile<input type="number" name="mobile" required="required">
		<br>
		Email<input type="email" name="email" required="required">
		<br>
		Salary<input type="number" name="salary" required="required">
		<br>
		Gender
		<br>
		<input type="radio" id="male" name="gender" value="male">
		<label for="male">Male</label><br>
		<input type="radio" id="female" name="gender" value="female">
		<label for="female">Female</label><br>
		<input type="submit" value="login">
		<input type="reset" value="Reset">
	</form>
</body>
</html>