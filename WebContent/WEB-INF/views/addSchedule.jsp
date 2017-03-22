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
	<h2 align="center">Enter Schedule Details</h2>
	<h3  align="center" style="background-color: cyan; margin: auto;">${mesg}</h3>
	<form:form method="post" modelAttribute="schedule">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Flight ID:</td>
				<td><form:select path="flightid" items="${fid}" /></td>
			</tr>
			<tr>
				<td>Route ID</td>
				<td><form:select path="routeid" items="${rid}" /></td>
			</tr>
			<tr>
				<td>Available Days:</td>
				<td><form:input path="distance" /></td>
			</tr>
			<tr>
				<td>Departure Time</td>
				<td><form:input path="departuretime" /></td>
			</tr>
			<tr>
				<td>Travel Duration</td>
				<td><form:input path="duration" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Add Schedule" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>