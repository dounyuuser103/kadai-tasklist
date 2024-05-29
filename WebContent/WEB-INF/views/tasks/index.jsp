<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task List</title>
</head>
<body>
    <h1>Tasks</h1>
    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>
                <a href="/tasks/show?id=${task.id}">${task.content}</a>
                <form action="/tasks/delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${task.id}">
                    <button type="submit">Delete</button>
                </form>
            </li>
        </c:forEach>
    </ul>
    <a href="/tasks/new">Create New Task</a>
</body>
</html>
