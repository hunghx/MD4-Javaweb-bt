<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/16/2024
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>Hello Product</h1>
<form action="/product/form" method="post">
    <input type="text" name="name"/>
    <input type="number" name="price"/>
    <button type="submit">Gửi</button>
</form>
</body>
</html>
