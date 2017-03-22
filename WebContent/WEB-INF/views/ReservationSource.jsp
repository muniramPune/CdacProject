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
	<form:form method="post" modelAttribute="route">
		<table bgcolor="pink" border="4px">

			<tr>
				<td>Select Route</td>
			</tr>
			<tr>
			<td>Source:</td>
				<td><form:select path="source">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${source}" />
					</form:select></td>
			</tr>
			<tr>
			<td>Destination:</td>
				<td><form:select path="destination">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${destination}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Available Date:[eg.12-Dec-16]</td>
				<td><input type="text" name="date"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" name="btnSearchByDate"
					value="Search Flight" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>