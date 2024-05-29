<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Detail</title>
</head>
<body>
    <h1>Task Detail</h1>
    <p>ID: ${task.id}</p>
    <p>Content: ${task.content}</p>
    <p>Created At: ${task.createdAt}</p>
    <p>Updated At: ${task.updatedAt}</p>
    <a href="/tasks/edit?id=${task.id}">Edit</a>
    <a href="/tasks">Back to List</a>
</body>
</html>