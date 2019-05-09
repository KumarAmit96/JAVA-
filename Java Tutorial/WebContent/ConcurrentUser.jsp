<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="learning.ConcurrentUser"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currentuser</title>
</head>
<body>
<%= ConcurrentUser.getUser() %>
</body>
</html>