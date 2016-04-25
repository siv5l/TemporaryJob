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
           Data filter
            <form>
                <p>
                Categoria:
                </p>
                <p>
                    <select name="selectedCategories" size="3">
                      <%--  <c:forEach items="${categories}" var="category">
                            <option value="${category.name}">
                                    ${category.name}
                            </option>
                        </c:forEach>--%>
                        <option value="Electronica">Electronica</option>
                        <option value="Constructie">Constructie</option>
                        <option value="Soferie">Soferie</option>
                        <option value="Bucatar">Bucatar</option>
                        <option value="Dadac">Dadac</option>
                        <option value="Contabilitate">Contabilitate</option>
                    </select>
                </p>
                <p>
                    Localitate:
                </p>
                <p>
                    <select name="selectedLocations" size="3">
                       <%-- <c:forEach items="${locations}" var="location">
                            <option value="${location.name}">
                                ${location.name}
                            </option>
                        </c:forEach>--%>
                           <option value="Chisinau">Chisinau</option>
                           <option value="Cahul">Cahul</option>
                           <option value="Balti">Balti</option>
                           <option value="Hincesti">Hincesti</option>
                           <option value="Ialoveni">Ialoveni</option>
                           <option value="Orhei">Orhei</option>
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
        <div id="profileBox">
            <div>
                <tiles:insertAttribute name="profile" />
            </div>
        </div>
    </div>
      
    <div id="footer">
      <tiles:insertAttribute name="footer" />
    </div>

  </div>

</body>
</html>
