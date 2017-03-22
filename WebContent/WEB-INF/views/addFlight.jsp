<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3  align="center" style="background-color: cyan; margin: auto;">${mesg}</h3>
	<form:form method="post" modelAttribute="flight">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Flight Name</td>
				<td><form:input path="flightname" /></td>
			</tr>
			<tr>
				<td>Seating Capacity</td>
				<td><form:input path="seatingcapacity" /></td>
			</tr>
			<tr>
				<td>Reservation Capacity</td>
				<td><form:input path="reservationcapacity" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Add Flight" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>