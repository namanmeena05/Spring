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
<title>Users List</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">



<style>
body {
	padding: 20px;
}
</style>
</head>
<body>




	<div class="container mt-4">


		<sf:form action="" method="post" modelAttribute="form">

			<tr>
				<td><sf:input path="firstName" placeholder="Enter First Name" /></td>

			</tr>
			<tr>
				<sf:select path="userId">
					<sf:option value="0">------------select------------</sf:option>
					<sf:options items="${userList}" itemValue="id"
						itemLabel="firstName" />
				</sf:select>
				<td><input type="submit" name="operation" value="search"></td>
			</tr>


			<table class="table table-bordered">
				<thead class="thead-dark">

					<tr>

						<th></th>
						<th>Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Login</th>
						<th>DOb</th>
						<th>Address</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="user">
						<tr>
							<td><sf:checkbox path="ids" value="${user.id }" /></td>
							<td><c:out value="${user.id }"></c:out></td>
							<td><c:out value="${user.firstName }"></c:out></td>
							<td><c:out value="${user.lastName }"></c:out></td>
							<td><c:out value="${user.login }"></c:out></td>
							<td><c:out value="${user.dob }"></c:out></td>
							<td><c:out value="${user.address }"></c:out></td>
							<td><a href='<c:url value="/ctl/User?id=${user.id}"/>'
								class="btn btn-primary">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<table>
				<tr>
					<td><input type="submit" value="Previous" name="operation"
						class="btn btn-white"></td>
					<td><input type="submit" value="Next" name="operation"
						class="btn btn-white"></td>
					<td><input type="submit" value="delete" name="operation"
						class="btn btn-danger"></td>

					<td><input type="submit" value="New" name="operation"
						class="btn btn-danger"></td>
				</tr>
			</table>
			<sf:hidden path="pageNo" value="${ pageNo}" />
			<sf:hidden path="pageSize" value="${pageSize}" />
		</sf:form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
