<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp"%>
	<div align="center" style="padding: 10%">
		<sf:form  method="post" modelAttribute="form">



			<table class="table-border">

				<tr>
					<th>First Name</th>
					<td><sf:input path="firstName" class="form-control" /></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><sf:input path="lastName" class="form-control" /></td>
				</tr>
				<tr>
					<th>Login</th>
					<td><sf:input path="login" class="form-control" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><sf:input path="password" class="form-control" /></td>
				</tr>
				<tr>
					<th>Date of Birth</th>
					<td><sf:input path="dob" class="form-control" /></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><sf:input path="address" class="form-control" /></td>
				</tr>

				<tr>
				<td><input type="submit" name="operation" value="Update"></td>


				</tr>

			</table>

		</sf:form>
	</div>


</body>
</html>