<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<link href="scriptcss.css" rel="stylesheet"></head>
<body>
<div class="login-page">
  <div class="form">
    <form class="register-form" method="post" action="LoginServlet">
      <input type="text" placeholder="name"/>
      <input type="text" placeholder="designation"/>
      <input type="text" placeholder="age"/>
      <input type="text" placeholder="cellphone" maxlength="10"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
   <!--  <form class="login-form">
      <input type="text" placeholder="username"/>
      <input type="password" placeholder="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form> -->
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript" src="Script.js"></script>
</body>
</html>