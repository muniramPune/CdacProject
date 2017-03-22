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
	<h1>View Route Details</h1>

	<table bgcolor="cyan" border="4px">

		<th>ROUTE ID</th>
		<th>SOURCE</th>
		<th>DESTINATION</th>
		<th>DISTANCE</th>
		<th>FARE</th>
		<th></th>
		<th></th>

		<c:if test="${not empty view}">


			<c:forEach var="listValue1" items="${view}">
				<form:form method="get" modelAttribute="route"
					onsubmit=" return getConfirmation();">
					
					<tr>
						<td><input type="text" name="routeid"
							value="${listValue1.routeid}" readonly /></td>
						<td><input type="text" name="source"
							value="${listValue1.source}" readonly /></td>
						<td><input type="text" name="destination"
							value="${listValue1.destination}" readonly /></td>
						<td><input type="text" name="distance"
							value="${listValue1.distance}" readonly /></td>
						<td><input type="text" name="fare" value="${listValue1.fare}"
							readonly /></td>
						<td><input type="submit" value="Edit"
							formaction="/travel/admin/ModifyRoute" /></td>
						<td><input type="submit" value="Delete"
							formaction="/travel/admin/deleteRoute" /></td>
					</tr>
					</form:form>
					
			</c:forEach>
		</c:if>

	</table>
	
</body>
</html>