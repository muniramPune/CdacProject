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
  	${status}
	<form:form>
		<h1>
			<u><font color="Black">Flight Details</font></u>
		</h1>
		<h2>
			<ol start="1">
				<p>
				<li><a href="/travel/admin/addFlight">Add Flight Details</a><br>

				</li>
				<li><a href="/travel/admin/ViewAllFlight">View All Flight </a><br>
				</li>
				</p>
				</ol>
		</h2>

	</form:form>
	<form:form method="post" modelAttribute="">
		<h1>
			<u><font color="Black">Route Details</font></u>
		</h1>
		<h2>
			<ol start="1">
				<p>
				<li><a href="/travel/admin/addroute">Add Route Details</a><br>

					<p>
				<li><a href="/travel/admin/ViewAllRoutes">View All Routes </a><br>
				</li>
				<p>
				</ol>
		</h2>
	</form:form>
	<form:form method="post" modelAttribute="">
		<h1>
			<u><font color="Black">Schedule Details</font></u>
		</h1>
		<h2>
			<ol start="1">
				<p>
				<li><a href="/travel/admin/addschedule">Add Schedule Details</a><br>

					<p>
				<li><a href="/travel/admin/ViewAllSchedule">View All Schedule </a><br>
				</li>
				<p>
			</ol>
		</h2>
	</form:form>
	<form:form method="post" modelAttribute="">
		<h1>
			<u><font color="Black">Passenger Details</font></u>
		</h1>
		<h2>
			<ol start="1">

				<p>
				<li><input type="submit" name="btnViewPassengers"
					value="View Passengers" class="button-link"></li>
			</ol>
		</h2>
	</form:form>

</body>
</html>