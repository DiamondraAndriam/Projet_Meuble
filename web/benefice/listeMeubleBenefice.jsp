<%-- 
    Document   : listeMeubleBenefice
    Created on : 16 janv. 2024, 16:04:48
    Author     : nyanj
--%>
<%@page import="model.Meuble"%>
<%@page import="java.util.List"%>
<% 
    List<Meuble> meubles = (List<Meuble>) request.getAttribute("meuble"); 
    String min = (String) request.getAttribute("min");
    String max = (String) request.getAttribute("max");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste de meuble avec bénéfice</title>
    </head>
    <body>
        <h1>Liste de meuble avec bénéfice entre
            <% out.print(min); %> et <% out.print(max); %></h1>
        <table>
            <tr>
                <th>Meuble</th>
                <th>Prix de vente</th>
                <th>Coût de fabrication</th>
                <th>Bénéfice</th>
            </tr>
            
            <% for(Meuble meuble : meubles) { %>
                <tr>
                    <td><% meuble.getNom();%></td>
                    <td><% meuble.getPrix();%></td>
                    <td><% meuble.getCoutFab();%></td>
                    <td><% meuble.get();%></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
