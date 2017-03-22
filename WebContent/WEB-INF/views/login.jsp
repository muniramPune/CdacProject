<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<spring:url value='/css/main.css'/>"
	type="text/css" />
</head>
<body>


	<h3 align="center">${mesg}</h3>
	<h3 align="center">
		<spring:message code="user.mesg" />
	</h3>
<form:form method="post" modelAttribute="userCredential">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Email ID</td>
				<td><form:input path="emailid" /></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>

			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><p>New user?</p></td>
				<td><a href="Register.jsp">Register Here</a></td>
			</tr>
			<tr>
				<td><p>Forgot your password?</p></td>
				<td><a href="ResetPassword.jsp">Click here to reset it.</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>