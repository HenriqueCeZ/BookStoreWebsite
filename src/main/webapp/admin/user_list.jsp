<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bookstore.entity.Users" import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2>Users Managment</h2>
		<a href="user_form.jsp">Create new User</a>
	</div>
	<c:if test="${ message != null}">
		<div>
			<h4 align="center" style="color: green;">
				<i>${message}</i>
			</h4>
		</div>
	</c:if>



	<br>
	<div align="center">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Full Name</th>
				<th>E-mail</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">

				<tr>
					<td>${status.index + 1}</td>
					<td>${user.userId}</td>
					<td>${user.fullName}</td>
					<td>${user.email}</td>

					<td><a href="">Edit</a> &nbsp; <a href="">Delete</a></td>

				</tr>

			</c:forEach>

		</table>
	</div>

	<div align="center"></div>

	<div align="center"></div>

	<div align="center"></div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>