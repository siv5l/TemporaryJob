<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/26/16
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>

  <form action="/submitfilter" method="post">
    <div class="radio">
      <label><input type="radio" name="option" value="unnemployed" checked="checked">Someri</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="option" value="announcement">Anunturi</label>
    </div>

    <div class="form-group">
      <label for="categories">Select categorie</label>
      <select class="form-control" id="categories" name="category" size="4" >
        <option value="Electronica">Electronica</option>
        <option value="Constructie">Constructie</option>
        <option value="Soferie">Soferie</option>
        <option value="Bucatar">Bucatar</option>
        <option value="Dadac">Dadac</option>
        <option value="Contabilitate">Contabilitate</option>
      </select>
    </div>

    <div class="form-group">
      <label for="locations">Select location</label>
      <select class="form-control" id="locations" name="location" size="4">
        <option value="Chisinau">Chisinau</option>
        <option value="Balti">Balti</option>
        <option value="Cahul">Cahul</option>
        <option value="Hincesti">Hincesti</option>
        <option value="Ialoveni">Ialoveni</option>
        <option value="Orhei">Orhei</option>
      </select>
    </div>
    <div>
      <input type="submit" class="btn btn-info" value="Submit">
    </div>
  </form>

</body>
</html>
