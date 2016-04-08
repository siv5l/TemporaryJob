<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/3/16
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>

<html>
<head>
    <title>User login</title>
</head>
<body>
<form:form action="user.do" method="post" commandName="user">
  <table>
    <tr>
      <td>User ID</td>
      <td><form:input path="userId" /></td>
    </tr>
    <tr>
      <td>First name</td>
      <td><form:input path="firstName" /></td>
    </tr>
    <tr>
      <td>Last name</td>
      <td><form:input path="lastName" /></td>
    </tr>
    <tr>
      <td>Username</td>
      <td><form:input path="username" /></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><form:input path="password" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" name="action" value="Add" />
        <input type="submit" name="action" value="Edit" />
        <input type="submit" name="action" value="Delete" />
        <input type="submit" name="action" value="Search" />
      </td>
    </tr>
  </table>

  <br>
  <table border="1">
    <th>ID</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Username</th>
    <th>Password</th>
    <c:forEach items="${userList}" var="userl">
      <tr>
        <td>${userl.userId}</td>
        <td>${userl.firstName}</td>
        <td>${userl.lastName}</td>
        <td>${userl.username}</td>
        <td>${userl.password}</td>
      </tr>
    </c:forEach>
  </table>
</form:form>
</body>
</html>
