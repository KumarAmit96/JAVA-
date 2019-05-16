<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
<c:forTokens var="item" delims=" " items="token1~token2 ~token3" >
   The value are <c:out value="${item}"/>
</c:forTokens>
</body>
</html>