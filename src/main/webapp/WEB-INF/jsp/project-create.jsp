<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/project-create.css"%></style>
</head>
<body>

<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Create<span>Project</span></div>
		</div>
		<div class="form">
		<form action="/project-create" method="POST">
				<input type="text" placeholder="Name" name="name"/>
				<input type="text" placeholder="Description" name="description"/>
				<input type="text" placeholder="Date End (27.10.2021)" name="dateEnd"/>
				    <input type="submit" value="Create">
				</form>
		</div>
</body>
</html>