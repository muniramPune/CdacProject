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
		<h1>Please Enter Details</h1>
		<table bgcolor="pink" border="4px">

			<tr>
				<td>User ID:</td>

				<td><input type="text" name="userid"value=${sessionScope.userid } readonly /></td>
			</tr>

			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount"
					value=${sessionScope.reservation.totalfare } readonly /></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardnumber" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btnmakepayment" value="Process" formaction="/travel/customer/SuccessfulProcess" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>