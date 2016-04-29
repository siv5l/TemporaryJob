<%@ page import="com.endava.siv5l.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../jsp/includes.jsp" />


<html>
<head>
  <title><tiles:insertAttribute name="title" ignore="true" /></title>
  <link href="/resources/css/siteTemplateStyle.css" rel="stylesheet" />
  <link href="/resources/css/menuStyle.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
    
  <div id="mainDiv">
    <div id="header">
        <div id="miniLeftHeader">
            <tiles:insertAttribute name="header" />
        </div>
        <div id="signInArea">
                <tiles:insertAttribute name="logArea" />
        </div>
    </div>
      
    <div id="menuDiv">
            <tiles:insertAttribute name="menu" />
    </div>
      
    <div id="Content">
        <div id="filterQuery">
            <tiles:insertAttribute name="filter" />
        </div>
        <div id="bodyContent">
            <tiles:insertAttribute name="bodyContent" />
        </div>
        <div id="profileBox">
            <tiles:insertAttribute name="profile" />
        </div>
    </div>
      
    <div id="footer">
      <tiles:insertAttribute name="footer" />
    </div>

  </div>

</body>
</html>
