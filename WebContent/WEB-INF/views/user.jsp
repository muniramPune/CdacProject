<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</head>
<body>
	Welcome user!!!
	<form:form method="post" modelAttribute="">

		<% String userid=(String)session.getAttribute("userId") ;%>
		<input type="submit" name="button" value="Logout" />

	</form:form>


	<form:form method="post" modelAttribute="">
		<h1>
			<u><font color="Black">Flights/Schedule Details</font></u>
		</h1>
		<h1>

			
				<a href="/travel/customer/reservationsource">View Flight Schedule</a><br>
		</h1>
	</form:form>
</body>
</html>