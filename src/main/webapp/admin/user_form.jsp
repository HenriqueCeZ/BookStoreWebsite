<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bookstore.entity.Users" import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Users</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Users Managment</h2>
		<h3> New User</h3>
	</div>
	
	<div align="center">
			<form action="create_uner" method="post">
			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" name="email" size="20"></td>
				
				</tr>
					<tr>
					<td align="right">Full name:</td>
					<td align="left"><input type="text" name="fullname" size="20"></td>
				
				</tr>
				
					<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="text" name="password" size="20"></td>
				
				</tr>
				<tr> <td>&nbsp;</td> </tr>
				<tr>
				 
					<td colspan="2" align="center">
					<input type="submit" value="Save">
					<input type="button" value="Cancel">
					</td>
					
				
				</tr>
			
			</table>
		</form>
		
	</div>



	<jsp:directive.include file="footer.jsp" />

</body>
</html>