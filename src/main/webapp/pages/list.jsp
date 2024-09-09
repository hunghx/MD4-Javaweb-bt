<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/9/2024
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách công việc</h1>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Content</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="todo" items="${todos}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${todo.content}</td>
            <td>${todo.status?"Xong":"CHưa xong"}</td>
            <td><a>Sửa</a></td>
            <td><a onclick="return confirm('Bạn có chac chăn muôn xoa ko')" href="/TodoServlet?action=DELETE&id=${todo.id}">Xóa</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
