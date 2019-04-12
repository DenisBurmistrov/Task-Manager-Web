<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<style><%@include file="/WEB-INF/css/login.css"%></style>
</head>
<body>
<form action="/login" method="POST">
  <h2><span class="entypo-login"><i class="fa fa-sign-in"></i></span> Login</h2>
  <button class="submit"><span class="entypo-lock"><i class="fa fa-lock"></i></span></button>
  <span class="entypo-user inputUserIcon">
     <i class="fa fa-user"></i>
   </span>
  <input type="text" class="user" name="login" placeholder="username" autocomplete="off"/>
  <span class="entypo-key inputPassIcon">
     <i class="fa fa-key"></i>
   </span>
  <input type="password" class="pass" name="password" placeholder="password" autocomplete="off"/>


</form>
</body>
</html>