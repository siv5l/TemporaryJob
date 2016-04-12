<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/11/16
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>Category</h1>
  <form:form action="/bindcategory" method="post" commandName="category">
    <p>
      categoryId: <form:input path="categoryId" />
    </p>
    <p>
      numele categoriei: <form:input path="name" />
    </p>
    <p>
      numele categoriei: <form:input path="descriere" />
    </p>

    <p>
      <input type="submit" value="Submit" />
    </p>
  </form:form>
</body>
</html>
