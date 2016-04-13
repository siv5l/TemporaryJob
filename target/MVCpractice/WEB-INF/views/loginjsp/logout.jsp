<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/13/16
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
  <h1>
    ${userAccount.firstName}
  </h1>
  <form action="/logout" method="get">
    <input type="submit" value="log out">
  </form>
</body>
</html>
