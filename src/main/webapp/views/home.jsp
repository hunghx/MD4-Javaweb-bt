<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/12/2024
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${success!=null}">
    <p class="text-success">${success}</p>
</c:if>
<h1>Chào mưng bạn quay lại ưng dung : ${user.fullName}</h1>
<p>Số dư tai khoan cua bạn la : ${user.balance}</p>
<a href="/views/sendMoney.jsp">Chuyển tiên</a>
</body>
</html>
