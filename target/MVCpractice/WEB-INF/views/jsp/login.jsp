<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/12/16
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes.jsp"%>
<link href="/resources/css/loginStyle.css" rel="stylesheet" />
<html>
<head>
    <title></title>
</head>
<body>
<div id="loginArea">
            Sign In Area
            <form id="formSignIn" action="/signin" method="post">
                <p>
                    Username : <input type="text" name="username" />
                </p>
                <p>
                    Password : <input type="password" name="password" />
                </p>
                <p>
                    <input type="submit" value="sign in" />
                </p>
            </form>
            <a href="/registration" method="get">
                <button>Registration</button>
            </a>
            <div>
                <form:errors path="loginValidation.*"/>
            </div>

</div>
</body>
</html>
