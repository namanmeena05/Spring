<%@page import="com.rays.ctl.WelcomeCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

	<div align="center" style="padding-top: 10%">
		<sf:form method="Post" modelAttribute="form">
			<table>
				<tr>
					<c:if test="${not empty error }">${error}</c:if>
				</tr>
				<tr>
					<th>Login</th>
					<td><sf:input path="login" /></td>
					<td><sf:errors path="login"></sf:errors></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><sf:input path="password" /></td>
					<td><sf:errors path="password"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="login" <%%>></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>