<html>
<body>
<h2>
    <% for (final Project project: request.getAttributes("projects")) { %>
        <p> <%= project.getName() %> <p>
    <% } %>
</h2>
</body>
</html>
