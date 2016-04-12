<%@ page import="com.endava.siv5l.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:errors path="loginValidation.*"/>
        </div>
    </div>
      
    <div id="menuDiv">
        <tiles:insertAttribute name="menu" />
    </div>
      
    <div id="Content">
        <div id="filterQuery">
           Data filter
            <form>
                <p>
                    Categoria: <input type="text" name="categorie"/>
                </p>
                <p>
                    <select name="selectedCategories" size="3">

                        <%--<jsp:useBean id="" scope="session" type="java.util.List"/>--%>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.name}">
                                    ${category.name}
                            </option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    Localitate: <input type="text" name="localitate" />
                </p>
                <p>
                    <select name="selectedLocations" size="3">
                        <c:forEach items="${locations}" var="location">
                            <option value="${location.name}">
                                    ${location.name}
                            </option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <input type="submit" value="refresh" />
                </p>
            </form>
        </div>
        <div id="bodyContent">
            <tiles:insertAttribute name="bodyContent" />
        </div>
        <div id="myProfile">
             <div id="chatBox">
                 <form name="message" id="messageForm" action="/insertmessage" method="post">
                     <p>
                        To whom? <input name="toWhom" type="text" id="toWhom" size="20" />
                     </p>
                     <p>
                         <textarea  rows="20" cols="20"  name="textMessage"></textarea>
                     </p>
                     <p>
                         <input name="sendMessage" type="text" size="20" />
                     </p>
                     <p>
                         <input name="submitmsg" type="submit"  id="submitmsg" value="Send"  />
                     </p>
                 </form>

                <a href="/retrievemessage"> Get messages </a>

             </div>
        </div>
    </div>
      
    <div id="footerr">
      <tiles:insertAttribute name="footer" />
    </div>
      
  </div>
 

</body>
</html>
