<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee_departments</title>
</head>
<body>
	<h5>Welcome to spring boot !</h5>
	<h5>Server Time : ${requestScope.timestamp}</h5>
	<h5>Number List : ${requestScope.number_list}</h5>
	<h5>
		<a href="departments/list">Show All Departments</a>
	</h5>
	<!-- add a link for employee to sign in -->
	<h5>
		<a href="emps/signin"> Employee sign In</a>
	</h5>
</body>
</html>