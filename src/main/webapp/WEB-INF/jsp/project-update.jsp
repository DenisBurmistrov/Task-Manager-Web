<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "ru.burmistrov.TaskManager.entity.Project" %>
<%@ page import = "ru.burmistrov.TaskManager.util.DateUtil" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/project-update.css"%></style>
</head>
<body>
<% Project project = (Project) request.getAttribute("project"); %>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Update<span>Project</span></div>
		</div>
		<div class="form">
		<form action="/project-update" method="POST">
				<input type="text" placeholder="Name" name="name" value="<%= project.getName()%>"  autocomplete="off">
				<input type="text" placeholder="Description" name="description" value="<%= (String) project.getDescription()%>"  autocomplete="off">
				<input type="text" placeholder="Date End (27.10.2021)"  autocomplete="off" name="dateEnd" value=<%= (String) DateUtil.parseDate(project.getDateEnd())%>>
				<input type="hidden" placeholder="ID" name="id" value=<%= project.getId()%>>
				    <input type="submit" value="Update">
				</form>
		</div>
</body>
</html>