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
<form:form method="post" modelAttribute="">
<table bgcolor="pink" border="4px">

		<tr>
		<td>
		 Flight ID: </td>
		<td><input type="text" name="flightId" value=<%=request.getParameter("flightId")%> readonly></td>
		<tr>
		<td>ROUTE ID:</td>
		<td> <input type="text" name="routeId" value=<%=request.getParameter("routeId")%> readonly></td></tr>
		
		<tr><td>SCHEDULE ID:</td>
		<td><input type="text" name="scheduleId" value=<%=request.getParameter("scheduleId")%> readonly></td></tr>
		<tr><td>TRAVEL DURATION:</td>
		<td><input type="text" name="travelduration" value=<%=request.getParameter("travelduration")%> readonly></td>
		</tr>
		<tr>
		<td>DEPARTURE TIME:</td>
		<td><input type="text" name="departuretime" value=<%=request.getParameter("departuretime")%> readonly></td>
		</tr>
		<tr>
		<td>NO. OF SEATS:</td>
		<td><input type="text" name="noofseats" value=""></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td><input type="submit" name="btnCheckSeat" value="Check Seat Availablity"/></td>
		</tr>
		</table>
</form:form>
</body>
</html>