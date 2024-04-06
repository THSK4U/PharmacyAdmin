<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Produit</title>
</head>
<body>
    <h1>Ajouter un Produit</h1>
    <form action="insert" method="post">
        <label for="name">Nom:</label><br>
        <input type="text" id="name" name="name"><br>
        
        <label for="quantite">Quantité:</label><br>
        <input type="number" id="quantite" name="quantite"><br>
        
        <label for="prix">Prix:</label><br>
        <input type="number" step="0.01" id="prix" name="prix"><br>
        
        <label for="description">Description:</label><br>
        <textarea id="description" name="description"></textarea><br>
        
        <input type="submit" value="Ajouter">
    </form>
    <p><a href="main.jsp">Retour à la liste des produits</a></p>
</body>
</html>
