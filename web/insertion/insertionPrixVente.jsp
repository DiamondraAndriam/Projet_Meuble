<%-- 
    Document   : insertionPrixVente
    Created on : 16 janv. 2024, 15:55:53
    Author     : nyanj
--%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble" %>
<% List<Meuble> meubles = (List<Meuble>) request.getAttribute(""); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion prix de vente</title>
    </head>
    <body>
        <h1>Insertion Prix de vente</h1>
        <form method="InsertPrixVenteMeuble" action="post">
            <div>
                <label>Meuble</label>
                <select name="meuble">
                    <% for(Meuble meuble : meubles) { %>
                        <option value="<% meuble.getId(); %>">
                            <% meuble.getNom(); %>
                        </option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Prix de vente</label>
                <input type="text" name="prix">
            </div>
                <input type="submit" value="OK">
        </form>
    </body>
</html>
