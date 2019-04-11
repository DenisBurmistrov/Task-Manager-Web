<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "ru.burmistrov.TaskManager.entity.Task" %>
<%@ page import = "java.util.*" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/home.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<table class="rwd-table">
<th>Number</th><th>ID</th><th>Name</th><th>Description</th><th>DateBegin</th><th>DateEnd</th><th>Edit</th><th>Remove</th>
<% int index = 1; %>
    <% for (Task task : (List<Task>) request.getAttribute("tasks")) { %>

    <tr>
        <td align="center"> <%= index %> </td>
        <td align="left"> <%= task.getId() %> </td>
        <td align="left"> <%= task.getName() %> </td>
        <td align="left"> <%= task.getDescription() %> </td>
        <td align="left"> <%= task.getDateBegin() %> </td>
        <td align="left"> <%= task.getDateEnd() %> </td>
        <td>
                    <a href="task-update?id=<%=task.getId()%>">
                        <i class="material-icons" style="font-size:40px;color:#45D09E" align = "center">border_color</i>
                    </a>
                </td>
                <td>
                    <a href="task-remove?id=<%=task.getId()%>">
                        <i class="material-icons" style="font-size:40px;color:#E20338" align = "center">delete_sweep</i>
                    </a>
                </td>
    </tr>
    <% index++; %>
    <% } %>
    <div class="button_cont" align="center"><a class="example_a" href="project-create">Create Project</a></div>
</table>
</body>
</html>
