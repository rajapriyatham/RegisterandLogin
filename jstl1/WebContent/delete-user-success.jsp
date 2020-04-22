<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty message}">
		<h3>User not deleted<h3>
	</c:if>
	<c:if test="${not empty message}">
		<h3>User deleted<h3>
	</c:if>
</body>
</html>