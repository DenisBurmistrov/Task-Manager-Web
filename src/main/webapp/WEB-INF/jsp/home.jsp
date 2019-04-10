<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "ru.burmistrov.TaskManager.entity.Project" %>
<%@ page import = "java.util.*" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/home.css"%></style>
</head>
<body>
<table class="rwd-table">
<th>Number</th><th>ID</th><th>Name</th><th>Description</th><th>DateBegin</th><th>DateEnd</th>
<% int index = 1; %>
    <% for (Project project : (List<Project>) request.getAttribute("projects")) { %>

    <tr>
        <td align="center"> <%= index %> </td>
        <td align="left"> <%= project.getId() %> </td>
        <td align="left"> <%= project.getName() %> </td>
        <td align="left"> <%= project.getDescription() %> </td>
        <td align="left"> <%= project.getDateBegin() %> </td>
        <td align="left"> <%= project.getDateEnd() %> </td>
    </tr>
    <% index++; %>
    <% } %>
    <div class="button_cont" align="center"><a class="example_a" href="createProject">Create Project</a></div>
</table>
</body>
</html>
