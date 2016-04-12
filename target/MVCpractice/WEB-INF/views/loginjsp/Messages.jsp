<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/12/16
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes.jsp"%>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<H1>All messages</H1>
  <c:forEach items="${messages}" var="message">
        ${message}
    <br>
  </c:forEach>
</body>
</html>
