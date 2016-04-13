<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>
<link href="/resources/css/registrationStyle.css" rel="stylesheet" />
<div id="registrationBox">
<form:form action="/submitregistration" method="post" commandName="user">
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
  <td>
  <input type="submit" name="action" value="Add" />
  </td>
  </tr>
  </table>
  </form:form>
</div>