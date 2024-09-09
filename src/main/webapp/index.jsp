<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/9/2024
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- chuyển trang tự động --%>
<%--<%response.sendRedirect("/TodoServlet?action=GETALL");%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Form upload --%>

<form action="/UploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file">
    <input type="file" name="files" id="files" multiple>
    <button type="submit">upload</button>
</form>


<%--Khai báo biê và khởi ta giá trị--%>
<%!
    LocalDate today = LocalDate.now();
    String name = "HÙng";
    int age = 20;
%>
<a href="/home.jsp">Go to </a>
<a href="home.jsp">Go to </a>
<%--Biểu thức java--%>
<h1>
    <%="hunghx"%>
</h1>
<p>
    Tôi tên là <%=name%> . Năm nay tôi <%=age%> tuổi.
    Hm nay là <%=today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%>
</p>
<%--Khối code nghiệp vụ logic--%>
<%

    for (int i = 1; i < 101; i++) {
        System.out.println(i);
        response.getWriter().println("i - " + i);
    }
%>
<c:set var="name" value="hùnghx"/>
<c:set var="age" value="20"/>
<c:set var="today" value="<%=new Date()%>"/>
<%--c : out--%>
<c:out value="hunghx"/>
<p>
    Tôi tên là <c:out value="${name}"/> . Năm nay tôi <c:out value="${age}"/> tuổi.
    Hm nay là
    <c:out value="${today}"/>
</p>
<%--C : if--%>
<%--<c:if test="${age>20}">--%>
<%--    <p>Tôi đã lớn </p>--%>
<%--</c:if>--%>
<%--<c:if test="${age<=20}">--%>
<%--    <p>Tôi còn bé </p>--%>
<%--</c:if>--%>

<%--&lt;%&ndash;switch case : c: choose&ndash;%&gt;--%>

<%--<c:choose>--%>
<%--    <c:when test="${age<10}">--%>
<%--        <a href="">Nhỏ hơn 10</a>--%>
<%--    </c:when>--%>
<%--    <c:when test="${age<20}">--%>
<%--        <a href="">từ 10->20</a>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <a href="">Truong hop khac</a>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>

<%--Vòng lặp--%>
<c:set var="array" value="<%=new int[]{1,2,3,4,5,6}%>"/>
<c:forEach var="number" items="${array}" varStatus="loop">
    <li>Index : ${loop.index} . Element value = ${number}</li>
</c:forEach>
<c:set var="totalPages" value="5"/>
<c:forEach var="page" begin="1" step="1" end="${totalPages}" varStatus="loop">
    <a href="">${page}</a>
</c:forEach>

</body>
</html>
