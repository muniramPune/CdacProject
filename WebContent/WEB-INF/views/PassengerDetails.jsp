<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript">
	function add() {

		var passenger = parseInt(document.formPassengerDetails.noofseats.value);
		for (i = 0; i < passenger; i++) {
			createTextbox.innerHTML = createTextbox.innerHTML
					+ "<table align='center' border='2px' bgcolor='pink'  >"
					+ "<tr><td>Name :</td><td><input type='text' name='name"+i+"' ></td>"
					/* + "<td>Seat No :</td><td><input type='text' name='seatno"+i+"' ></td>" */
					+ "<td>Gender :</td><td><select name='gender"+i+"' ><option>Male</option><option>Female</option></select></td>"
					+ "<td>Age :</td><td><input type='text' name='age"+i+"' ></td></tr></table>"
		}
	}
</script>
</head>
<body>

	<form:form method="post" modelAttribute=""
		name="formPassengerDetails">

		<input type="hidden" name="reservationid"
			value=${sessionScope.reservation.reservationid } />
		<input type="hidden" name="flightid"
			value=${sessionScope.reservation.reservationid } />
		<input type="hidden" name="userid"
			value=${sessionScope.reservation.userid } />
		<input type="hidden" name="scheduleid"
			value=${sessionScope.reservation.scheduleid } />
		<input type="hidden" name="noofseats"
			value=${sessionScope.reservation.noofseats } />
		<input type="hidden" name="totalfare"
			value=${sessionScope.reservation.reservationid } />

		<table bgcolor="pink" border="4px">

			
				<!-- <input type="text" name=${sessionScope.reservation.scheduleid} value="Shcedule" /> -->
			
			<tr>
				<td>Please Add Passenger.</td>
			</tr>
			<tr>
				<td><input type="button" name="" value="Add" onclick="add()" /></td>
			</tr>
		</table>

		<span id="createTextbox"></span>
		<input type="submit" name="btnaddpassenger" value="Make Payment" formaction="/travel/customer/PassengerDetails">
	</form:form>

</body>
</html>