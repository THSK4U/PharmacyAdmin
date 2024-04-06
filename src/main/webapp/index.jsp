<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Pharmacy Management</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
        </div>

    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">Prouduits</h3>
        <hr>
        
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Prix</th>
                <th>Description</th>
                <th>Quantite</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">
                
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
