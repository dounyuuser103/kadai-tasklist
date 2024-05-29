<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
</head>
<body>
    <h1>Edit Task</h1>
    <form action="/tasks/update" method="post">
        <input type="hidden" name="id" value="${task.id}">
        <label for="content">Content:</label>
        <input type="text" id="content" name="content" value="${task.content}">
        <button type="submit">Update</button>
    </form>
    <a href="/tasks">Back to List</a>
</body>
</html>
