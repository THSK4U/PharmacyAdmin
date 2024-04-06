<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Product List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <% 
    Pharmacy.modele.produit[] produits = (Pharmacy.modele.produit[]) request.getAttribute("produits");
    if (produits != null) {
        for (Pharmacy.modele.produit produit : produits) {
    %>
    <tr>
        <td><%= produit.getid() %></td>
        <td><%= produit.getname() %></td>
        <td><%= produit.getquantite() %></td>
        <td><%= produit.getprix() %></td>
        <td><%= produit.getdescription() %></td>
        <td>
            <a href="edit?id=<%= produit.getid() %>">Edit</a>
            <a href="delete?id=<%= produit.getid() %>">Delete</a>
        </td>
    </tr>
    <% 
        }
    } else {
    %>
    <tr>
        <td colspan="6">No products found</td>
    </tr>
    <% } %>
</table>

</body>
</html>
