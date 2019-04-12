<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<style><%@include file="/WEB-INF/css/login.css"%></style>
</head>
<body>
<form action="/signUp" method="POST">
  <h2><span class="entypo-login"><i class="fa fa-sign-in"></i></span> SignUp</h2>
  <span class="entypo-user inputUserIcon">
     <i class="fa fa-user"></i>
   </span>
  <input type="text" class="user" name="login" placeholder="username" autocomplete="off"/>
  <span class="entypo-key inputPassIcon">
     <i class="fa fa-key"></i>
   </span>
  <input type="password" class="pass" name="password" placeholder="password" autocomplete="off"/>
  <input type="text" class="pass" name="firstName" placeholder="First name" autocomplete="off"/>
  <input type="text" class="pass" name="lastName" placeholder="Last Name" autocomplete="off"/>
  <input type="text" class="pass" name="middleName" placeholder="Middle Name" autocomplete="off"/>
  <input type="text" class="pass" name="email" placeholder="Email" autocomplete="off"/>
<div>

  <input class="signUp" type="submit" value="Sign up">
  </div>
  </form>
</body>
</html>