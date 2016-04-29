<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>
<link href="/resources/css/registrationStyle.css" rel="stylesheet" />
<div id="registrationBox">
<form:form action="/submitregistration" method="post" commandName="user">
  <table>
      <tr>
        <td>First name</td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td>Last name</td>
        <td><form:input path="lastName" /></td>
      </tr>
      <tr>
        <td>Username</td>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
          <td>Date of birth</td>
          <td><form:input path="birthday" /></td>
      </tr>
      <tr>
          <td>Cell phone</td>
          <td><form:input path="phone" /></td>
      </tr>
      <tr>
          <td>Email</td>
          <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td>Location</td>
        <td>
            <form:select path="locations" multiple="true" size="3">
                <form:option value="Chisinau" >Chisinau</form:option>
                <form:option value="Balti" >Balti</form:option>
                <form:option value="Cahul" >Cahul</form:option>
                <form:option value="Hincesti" >Hincesti</form:option>
                <form:option value="Ialoveni" >Ialoveni</form:option>
                <form:option value="Orhei" >Orhei</form:option>
            </form:select>
        </td>
      </tr>
      <tr>
          <td>Category</td>
          <td>
              <form:select path="categories" multiple="true" size="3">
                  <form:option value="Electronica">Electronica</form:option>
                  <form:option value="Constructie">Constructie</form:option>
                  <form:option value="Soferie">Soferie</form:option>
                  <form:option value="Bucatar">Bucatar</form:option>
                  <form:option value="Dadac">Dadac</form:option>
                  <form:option value="Contabilitate">Contabilitate</form:option>
              </form:select>

          </td>
      </tr>
      <tr>
        <td>
        <input type="submit" name="action" value="Add" />
      </td>
      </tr>
  </table>
  </form:form>
</div>