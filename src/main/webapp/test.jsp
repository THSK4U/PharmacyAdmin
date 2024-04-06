<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Produits</title>
</head>
<body>
    <h1>Liste des Produits</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach var="produit" items="${listProduit}">
            <tr>
                <td>${produit.id}</td>
                <td>${produit.name}</td>
                <td>${produit.quantite}</td>
                <td>${produit.prix}</td>
                <td>${produit.description}</td>
                <td>
                    <a href="edit?id=${produit.id}">Edit</a>
                    <a href="delete?id=${produit.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="new">Ajouter un Produit</a></p>
</body>
</html>
