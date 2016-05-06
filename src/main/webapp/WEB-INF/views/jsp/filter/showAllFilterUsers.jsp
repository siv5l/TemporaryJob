<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/27/16
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes.jsp"%>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>

<body>
<table class="table">
  <thead>
    <tr>
      <th>Username</th>
      <th>First name</th>
      <th>Last name</th>
      <th>Cell phone</th>
      <th>Email</th>
      <th>Date of birth</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${filterUsers}" var="user">
      <tr>
        <td>
          <a href="profiles/${user.username}/">${user.username}</a>
        </td>
        <td>
          <c:out value="${user.firstName}" />
        </td>
        <td>
          <c:out value="${user.lastName}" />
        </td>
        <td>
          <c:out value="${user.phone}" />
        </td>
        <td>
          <c:out value="${user.email}" />
        </td>
        <td>
          <c:out value="${user.birthday}" />
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>