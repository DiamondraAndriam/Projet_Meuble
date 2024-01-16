<%-- 
    Document   : stock
    Created on : 11 janv. 2024, 14:46:55
    Author     : nyanj
--%>
<%@page import="model.StockMateriau"%>
<%@page import="java.util.List"%>
<% List<StockMateriau> stocks = (List<StockMateriau>) request.getAttribute("stocks"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock</title>
    </head>
    <body>
        <h1>Etat de stock</h1>
        <div>
            <label>Filtrer par </label>
            <select name="">
                <option value=""></option>
            </select>
        </div>
        <table>
            <tr>
                <th>Matériau</th>
                <th>Qtt</th>
                <th>Prix unitaire</th>
                <th>Montant</th>
            </tr>
            <%for (StockMateriau stock: stocks) { %>
            <tr>
                <td><%out.print(stock.getMateriau().getNom());%></td>
                <td><%out.print(stock.getQuantite());%></td>
                <td><%out.print(stock.getMateriau().getPrix());%></td>
                <td><%out.print(stock.getMontant());%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
