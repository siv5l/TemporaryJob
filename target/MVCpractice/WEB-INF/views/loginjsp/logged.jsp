<%@ page import="com.endava.siv5l.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>

<h1>${userAccount.firstName}</h1>
<h1>Salut</h1>
<%--
<%
  User userSession = (User) session.getAttribute("userAccount");    // task 1 ????????
%>
 <c:choose>
   <c:when test="${userSession.equals(null)}">
     <c:redirect url="signin.jsp" />
   </c:when>
   <c:otherwise>
     <h1> ${userAccount.firstName}</h1>
     <h1> no credentials</h1>
   </c:otherwise>
 </c:choose>--%>
