<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../loginjsp/includes.jsp" />


<html>
<head>
  <title><tiles:insertAttribute name="title" ignore="true" /></title>
  <link href="/resources/css/siteTemplateStyle.css" rel="stylesheet" />
</head>
<body>
    
  <div id="mainDiv">
    <div id="header">
        <div id="miniHeader">
            <tiles:insertAttribute name="header" />
        </div>

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
        </div>
    </div>
      
    <div id="menuDiv">
        <tiles:insertAttribute name="menu" />
    </div>
      
    <div id="Content">
        <div id="filterQuery">
            adsadas
        </div>
        <div id="bodyContent">
            <tiles:insertAttribute name="bodyContent" />
        </div>
        <div id="myProfile">
            
        </div>
    </div>
      
    <div id="footerr">
      <tiles:insertAttribute name="footer" />
    </div>
      
  </div>
 

</body>
</html>
