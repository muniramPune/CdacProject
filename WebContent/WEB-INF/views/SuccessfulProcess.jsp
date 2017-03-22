<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.button-link
{
background:transparent;
color:black;
border:0;
}
.button-link:hover
{
background:transparent;
text-decoration: underline;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="get" modelAttribute="">
<h3>Your transaction is successfully processed.</h3>
     <h1>Your ReservationID is: ${sessionScope.reservation.reservationid}</h1>
     <input type="hidden" name="userid" value=${sessionScope.userid} />
   <p><li><input type="submit" name="btnViewticket" value="View Ticket" formaction="/travel/customer/ViewTicket" class="button-link"><br>
</form:form>

</body>
</html>