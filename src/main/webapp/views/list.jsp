<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/4/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách công việc</h1>
<form action="/TodoServlet" method="post">
    <input type="text" name="task" placeholder="new task"/>
    <input type="submit" name="action" value="Add"/>
</form>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Task</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.taskName}</td>
            <td><button><a href="/TodoServlet?action=delete&id=${task.id}">Xoá</a></button></td>
            <td><button><a href="/TodoServlet?action=edit&id=${task.id}">Edit</a></button></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
