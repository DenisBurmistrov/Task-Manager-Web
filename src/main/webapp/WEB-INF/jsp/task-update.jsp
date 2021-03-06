<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import="ru.burmistrov.taskManager.entity.Task" %>
<%@ page import="ru.burmistrov.taskManager.util.DateUtil" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/project-update.css"%></style>
</head>
<body>
<% Task task = (Task) request.getAttribute("task"); %>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Update<span>Task</span></div>
		</div>
		<div class="form">
		<form action="/task-update" method="POST">
				<input type="text" placeholder="Name" name="name" value="<%= task.getName()%>"  autocomplete="off">
				<input type="text" placeholder="Description" name="description" value="<%= (String) task.getDescription()%>"  autocomplete="off">
				<input type="text" placeholder="Date End (27.10.2021)"  autocomplete="off" name="dateEnd" value=<%= (String) DateUtil.parseDate(task.getDateEnd())%>>
				<input type="hidden" placeholder="ID" name="id" value=<%= task.getId()%>>
				    <input type="submit" value="Update">
				</form>
		</div>



</body>
</html>