<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/home.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<table class="rwd-table">
<th>Number</th><th>ID</th><th>Name</th><th>Description</th><th>DateBegin</th><th>DateEnd</th><th>Edit</th><th>Remove</th><th>Tasks</th>
<% int index = 1; %>
    <c:forEach var="project" items="${projects}">
    <tr>
        <td align="center"> <%= index %> </td>
        <td align="left" > ${project.getId()} </td>
        <td align="left" > ${project.getName()}  </td>
        <td align="left" >${project.getDescription()}  </td>
        <td align="left" > ${project.getDateBegin()}  </td>
        <td align="left" > ${project.getDateEnd()}  </td>
        <td>
                    <a href="project-update?id=${project.getId()}">
                        <i class="material-icons" style="font-size:40px;color:#45D09E" align = "center">border_color</i>
                    </a>
                </td>
                <td>
                    <a href="project-remove?id=${project.getId()}">
                        <i class="material-icons" style="font-size:40px;color:#E20338" align = "center">delete_sweep</i>
                    </a>
                </td>
                 <td>
                                    <a href="tasks?id=${project.getId()}">
                                        <i class="material-icons" style="font-size:40px;color:#808080" align = "center">subject</i>
                                    </a>
                                </td>
    </tr>

    <% index++; %>
    </c:forEach>
    <div class="button_cont" align="center"><a class="example_a" href="project-create">Create Project</a></div>

    <div class="button_cont" ><a class="logout_button" href="logout">logout</a></div>
</table>
</body>
</html>
