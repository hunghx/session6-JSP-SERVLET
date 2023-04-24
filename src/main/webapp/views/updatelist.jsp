<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/4/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit task</h2>
<form action="/TodoServlet" method="post">
  <input type="text" name="task" placeholder="new task" value="${taskEdit.taskName}"/>
    <input type="hidden" name="id" value="${taskEdit.id}">
  <input type="submit" name="action" value="update"/>
</form>
</body>
</html>
