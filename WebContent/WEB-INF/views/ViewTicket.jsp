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
	<h1>Your Ticket</h1>
	<form:form method="post" modelAttribute="">
		<table bgcolor="pink" border="4px">

			<th>Resevation ID</th>
			<th>Reservation Type</th>
			<th>Journey Date</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Seat No</th>


			<c:if test="${not empty passengerList}">


				<c:forEach var="listValue" items="${passengerList}">



					<form:form method="GET" modelAttribute="flight"
						onsubmit=" return getConfirmation();">

						<tr>
							<td><input type="text" name="reservationid"
								value="${sessionScope.reservation.reservationid}" readonly /></td>
							<td><input type="text" name="reservationtype"
								value="${sessionScope.reservation.reservationtype}" readonly /></td>
							<td><input type="text" name="seatingcapacity"
								value="${sessionScope.reservation.journeydate}" readonly /></td>
							<td><input type="text" name="reservationcapacity"
								value="${listValue.name}" readonly /></td>
							<td><input type="text" name="reservationcapacity"
								value="${listValue.age}" readonly /></td>
							<td><input type="text" name="reservationcapacity"
								value="${listValue.gender}" readonly /></td>
							<td><input type="text" name="reservationcapacity"
								value="${listValue.seatno}" readonly /></td>



							<td><input type="submit" value="Edit"
								formaction="/travel/admin/ModifyFlight" /></td>
							<td><input type="submit" value="Delete"
								formaction="/travel/admin/deleteFlight" /></td>
						</tr>

					</form:form>

				</c:forEach>
			</c:if>


			<tr>
				<input type="submit" name="btnDeleteTicket" value="Delete"
					class="button-link">
				<input type="submit" name="btnPrintTicket" value="Print"
					class="button-link">

				</th>
			</tr>


		</table>
	</form:form>

</body>
</html>