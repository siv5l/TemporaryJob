<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/25/16
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

  <form:form action="/addannouncement" method="post" commandName="announcement">
      <div>
        Subiect
        <form:input path="subject"/>
      </div>
      <div>
        Description
        <form:input path="description" />
      </div>
      <div>
          Localitate
          <form:select path="locations" multiple="true" size="3">
              <form:option value="Chisinau" >Chisinau</form:option>
              <form:option value="Balti" >Balti</form:option>
              <form:option value="Cahul" >Cahul</form:option>
              <form:option value="Hincesti" >Hincesti</form:option>
              <form:option value="Ialoveni" >Ialoveni</form:option>
              <form:option value="Orhei" >Orhei</form:option>
          </form:select>
      </div>
     <div>
          Categorie
          <form:select path="categories" multiple="true" size="3">
              <form:option value="Electronica">Electronica</form:option>
              <form:option value="Constructie">Constructie</form:option>
              <form:option value="Soferie">Soferie</form:option>
              <form:option value="Bucatar">Bucatar</form:option>
              <form:option value="Dadac">Dadac</form:option>
              <form:option value="Contabilitate">Contabilitate</form:option>
          </form:select>
      </div>
      <div>
          <input type="submit" value="Add" />
      </div>
    </form:form>
</body>
</html>
