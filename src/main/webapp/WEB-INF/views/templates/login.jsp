<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/8/16
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<div id="signInArea">--%>
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
<%--</div>--%>
</body>
</html>
