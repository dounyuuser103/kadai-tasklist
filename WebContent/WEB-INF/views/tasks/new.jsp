<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Task</title>
</head>
<body>
    <h1>Create New Task</h1>
    <form action="/tasks/create" method="post">
        <label for="content">Content:</label>
        <input type="text" id="content" name="content">
        <button type="submit">Create</button>
    </form>
    <a href="/tasks">Back to List</a>
</body>
</html>
