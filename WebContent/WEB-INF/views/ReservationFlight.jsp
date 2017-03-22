<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Flight Details</h1>
	<form:form method="post" modelAttribute="">
		<table bgcolor="pink" border="4px">
			<tr>
				<th>FLIGHT ID</th>
				<th>ROUTE ID</th>
				<th>SCHEDULE ID</th>
				<th>TRAVEL DURATION</th>
				<th>DEPARTURE TIME</th>
				<th>TOTAL NUMBER OF SEATS</th>
				<th>FARE</th>
				
				<th></th>


			</tr>

			<c:if test="${not empty scheduleList}">
				<c:forEach var="listValue" items="${scheduleList}">
					<tr>
						<td>${listValue.flightid}</td>
						<td>${listValue.routeid}</td>
						<td>${listValue.scheduleid}</td>
						<td>${listValue.travelduration}</td>
						<td>${listValue.departuretime}</td>
						<td>${listValue.seatavailablecount}</td>
						<c:if test="${not empty routeList}">
				<c:forEach var="route" items="${routeList}">
				<c:if test="${route.routeid eq listValue.routeid}">
					<th>${route.fare}</th>
					</c:if>		
				
				</c:forEach>
				</c:if>
			
						
						<td><a href=/travel/customer/ReserveTicket?scheduleid=${listValue.scheduleid}>Reserve Seat</a></td>
						
					</tr>

				</c:forEach>
			</c:if>

		</table>
		</form:form>
	</body>
</html>