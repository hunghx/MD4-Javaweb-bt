<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/16/2024
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thong tin ca nhan</h1>
<form action="/input" method="post">
    <label for="">Name</label>
    <input type="text" name="name"><br>
    <label for="">Age</label>
    <input type="number" name="age"><br>
    <label for="">Phone</label>
    <input type="text" name="phone"><br>
    <label for="">Email</label>
    <input type="email" name="email"><br>
    <label for="">Address</label>
    <input type="text" name="address"><br>
    <button type="submit">Gửi</button>
</form>
</body>
</html>
