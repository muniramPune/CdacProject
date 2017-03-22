<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modify Route Details</h1>
	<form:form method="post" modelAttribute="route">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Route Id</td>
				<td><form:input path="routeid" readonly="true"/></td>
			</tr>
			<tr>
				<td>Source</td>
				<td><form:input path="source"/></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><form:input path="destination" /></td>
			</tr>
			<tr>
				<td>Distance</td>
				<td><form:input path="distance" /></td>
			</tr>
			<tr>
				<td>Fare</td>
				<td><form:input path="fare" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Modify Route" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>