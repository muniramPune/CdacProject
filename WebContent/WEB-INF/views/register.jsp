<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form method="post" modelAttribute="userProfile">
		<table >
			
			<tr>
			<td> FirstName</td>
			<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
			<td> LastName</td>
			<td><input type="text" name="lastname"></td>
			</tr>
			<tr>
			<td> Date Of Birth</td>
			<td><input type="text" name="dateofbirth"></td></tr>
			<tr>
				<td>Gender:</td>
				<td><select name="gender">
						<option name="male">M</option>
						<option name="female">F</option>
				</select></td>
			</tr>
			<tr>
			<td> Street</td>
			<td><input type="text" name="street"></td>
			</tr>
			<tr>
			<td> Location</td>
			<td><input type="text" name="location"></td>
			</tr>
			<tr>
			<td> City</td>
			<td><input type="text" name="city" /></td>
			</tr>
			<tr>
			<td> State</td>
			<td><input type="text" name="state" /></td>
			</tr>
			<tr>
			<td> Pincode</td>
			<td><input type="text" name="pincode" /></td>
			</tr>
			<tr>
			<td>Mobile Number</td>
			<td><input type="text" name="mobilenumber" /></td>
			</tr>
			<tr>
			<td>EmailID</td>
			<td><input type="text" name="emailid" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			
			<tr>
		
			<td><input type="submit" name="Submit" value="Register"></td>
			<td>
			<a href="Login.jsp" > Home </a></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>