<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 5/9/16
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <div>
    <h1> ${requiredUser.firstName} ${requiredUser.lastName}</h1>
  </div>
  <div>
    Username: ${requiredUser.username}
  </div>
  <div>
    Date of birth: ${requiredUser.birthday}
  </div>
  <div>
    Email: ${requiredUser.email}
  </div>
  <div>
    Cell phone number: ${requiredUser.phone}
  </div>
</body>
</html>
