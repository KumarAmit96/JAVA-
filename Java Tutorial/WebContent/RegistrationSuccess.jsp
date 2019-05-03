<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<table style="with: 50%">
	<tr><td>
	<% String username = request.getParameter("name"); %>
<a>Welcome   <% out.println(username); %>!!!! You have logged in at <%= new Date() %>></a></td> <td><a href="Login.jsp"><b>Logout</b></a></td> </tr>
</table>
</body>
</html>