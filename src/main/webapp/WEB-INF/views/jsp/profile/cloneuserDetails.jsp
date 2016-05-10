<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 5/10/16
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<div>
  <h1>${userDetails.firstName} ${userDetails.lastName}</h1>
</div>
<div>
  Username: ${userDetails.username}
</div>
<div>
  Date of birth: ${userDetails.birthday}
</div>
<div>
  Phone: ${userDetails.phone}
</div>
<div>
  Email: ${userDetails.email}
</div>
</body>
</html>
