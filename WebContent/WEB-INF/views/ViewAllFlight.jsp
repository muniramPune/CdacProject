<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.button-link {
	background: transparent;
	color: black;
	border: 0;
}

.button-link:hover {
	background: transparent;
	text-decoration: underline;
}
</style>

<script type="text/javascript">
	function getConfirmation() {
		var retVal = confirm("Do you want to continue ?");
		if (retVal == true) {
			
			return true;
		} else {
			
			return false;
		}
	}
</script>
</head>
<body>
	<h1>View Flight Details</h1>

	<table bgcolor="pink" border="4px">

		<th>FLIGHT ID</th>
		<th>FLIGHT NAME</th>
		<th>SEATING CAPACITY</th>
		<th>Reservation Capacity</th>
		<th></th>
		<th></th>

		<c:if test="${not empty viewflight}">


			<c:forEach var="listValue" items="${viewflight}">



				<form:form method="GET" modelAttribute="flight" onsubmit=" return getConfirmation();">

					<tr>
						<td><input type="text" name="flightid"
							value="${listValue.flightid}" readonly /></td>
						<td><input type="text" name="flightname"
							value="${listValue.flightname}" readonly /></td>
						<td><input type="text" name="seatingcapacity"
							value="${listValue.seatingcapacity}" readonly /></td>
						<td><input type="text" name="reservationcapacity"
							value="${listValue.reservationcapacity}" readonly /></td>
						<td><input type="submit" value="Edit"
							formaction="/travel/admin/ModifyFlight" /></td>
						<td><input type="submit" value="Delete"
							formaction="/travel/admin/deleteFlight" /></td>
					</tr>

				</form:form>

			</c:forEach>
		</c:if>

	</table>
	<%-- </form:form> --%>

</body>
</html>