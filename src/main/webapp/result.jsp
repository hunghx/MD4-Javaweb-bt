<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/9/2024
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1 ảnh</h1>
<%--    <img src="${oneUrl}" alt="#" width="100" height="100" style="object-fit: cover">--%>
<audio src="${oneUrl}" controls  autoplay></audio>

<h1>n ảnh</h1>
<c:forEach var="url" items="${listUrl}">
    <img src="${url}" alt="#" width="100" height="100" style="object-fit: cover">
</c:forEach>
</body>
</html>
