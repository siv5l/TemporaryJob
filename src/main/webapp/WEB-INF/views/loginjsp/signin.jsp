<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>


  <h1>Main Page</h1>
<%--<h1>${unlogged}</h1>--%>
  <h1>${userAccount.firstName}</h1>
  <%--<form:errors path="loginValidation.*"/>--%>

<%--<form action="/signin" method="post" >
  <p>
    Username : <input type="text" name="username" />
  </p>
  <p>
    Password : <input type="password" name="password" />
  </p>
  <p>
    <input type="submit" value="sign in" />
  </p>
</form> --%>

<%--<c:forEach items="${errors}" var="error">
  ${error}
</c:forEach>--%>

<%--<p>
  <a href="/registration" metho ds="get">
    <button>Registration</button>
  </a>
</p>--%>

