<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login Form</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightred; margin: auto">
			<tr>
				<td>Enter Employee Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Employee password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>