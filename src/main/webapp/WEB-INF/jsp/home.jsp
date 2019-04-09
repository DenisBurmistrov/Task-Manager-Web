<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "ru.burmistrov.TaskManager.entity.Project" %>
<%@ page import = "java.util.*" %>
<html>
<body>
<h2>
    <% for (Project project : (List<Project>) request.getAttribute("projects")) { %>
        <p> <%= project.getName() %> <p>
    <% } %>
</h2>
</body>
</html>
