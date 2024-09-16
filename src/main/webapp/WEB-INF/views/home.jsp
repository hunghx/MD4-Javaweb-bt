<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/16/2024
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>Hello Home</h1>
<a href="/input">Nha thong tin ca nhan</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Avatar</th>
    </tr>
    <c:forEach items="${list}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td><img src="${pro.url}" alt="" width="100" height="100"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
