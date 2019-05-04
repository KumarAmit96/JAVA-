<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="C:\Users\Ajay_triffort\Desktop\html\scriptcss.css" rel="stylesheet"></head>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form  autocomplete="off" class="login-form"method="post" action="Password" >
      <input type="text"     autocomplete="false" placeholder="username" name="username"/>
      <input type="password" autocomplete="false" placeholder="password" name="password"/>
      <input type="text" value="<%= request.getAttribute("auth_id") %>" name="auth_id" readonly/>
      <input type="submit" value="ok">
            <p class="message">Above code isn't editable. </p>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript" src="C:\Users\Ajay_triffort\Desktop\html\Script.js"></script>
</body>
</html>