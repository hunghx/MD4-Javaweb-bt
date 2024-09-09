<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/9/2024
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Home</h1>
<ul>
    <li>Tên : ${name}</li>
    <li>Tuôi : ${age}</li>
    <li>Phone : ${phone}</li>
</ul>
<a href="<%=request.getContextPath()%>/home.jsp">Go to </a>
<a href="home.jsp">Go to </a>
</body>
</html>
