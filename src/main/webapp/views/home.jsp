<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/18/2024
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CHào mưng den trang chu</h1>
<a href="/upload">Upload</a>
<form:form action="/doAdd" method="post" modelAttribute="person">
    <form:label path="id">Id</form:label>
    <form:input path="id"/> <br>
    <form:label path="name">Name</form:label>
    <form:input path="name"/> <br>
    <form:label path="age">age</form:label>
    <form:input type="number" path="age"/><br>
    <%--    checkbox, checkboxes--%>
    <form:checkbox path="checkbox" value="Banana"/><form:label path="checkbox">Quả chuối</form:label>
    <form:checkboxes path="checkboxes" items="${listcheck}" element="div"/>

<%--    select - option--%>
    <form:select path="select">
        <form:options items="${listcheck}"/>
    </form:select>
    <button type="submit">Add</button>
</form:form>
</body>
</html>
