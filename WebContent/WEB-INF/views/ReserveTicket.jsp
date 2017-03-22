<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function calculate() {
		var str = document.getElementById('Rtype').value;
		
		var fare = document.getElementById('fare').value;
		
		var totalfare;
		if (str == "Economy") {
			totalfare = parseInt(fare) + parseInt(300);
			
			
		} else if (str == "Executive") {
			totalfare = parseInt(fare) + parseInt(800);
			
			
		} else
			(str == "First")
		{
			totalfare = parseInt(fare) + parseInt(1000);
			
			
		}
		
	}
</script>
</head>
<body>
	<form:form method="post" modelAttribute="reservation">
		<table bgcolor="pink" border="4px">

			<tr>
				<td>User ID:</td>

				<td><input type="text" name="userid"
					value=${sessionScope.userid} /></td>
			</tr>
			<tr>
				<td>Schedule ID:</td>

				<td><input type="text" name="scheduleid"
					value=${scheduleid} readonly /></td>
			</tr>
			<tr>
				<td>Reservation Type:</td>
				<td><select name="reservationtype" id="Rtype">
						<option value="Executive">Executive</option>
						<option value="Economy">Economy</option>
						<option value="First">First</option>
				</select></td>
			</tr>
			<tr>
				<td>Journey Date:</td>
				<td><input type="text" name="journeydate"
					value="${journeydate}" readonly /></td>
			</tr>
			<tr>
				<td>Booking Date:</td>
				<td><input type="text" name="bookingdate"
					value="${now}"	readonly /></td>
			</tr>
			<td>No of Seats:</td>
			<td><input type="text" name="noofseats"/></td>

			
		</table>



		<input type="submit" name="btnconfirmbooking" value="OK" />




	</form:form>

</body>
</html>