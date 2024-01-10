<%-- 
    Document   : resultatprix
    Created on : 9 janv. 2024, 14:56:34
    Author     : Diamondra
--%>
<%@page import="model.Meuble"%>
<%@page import="java.util.List"%>
<% List<Meuble> meubles = (List<Meuble>) request.getAttribute("meubles");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultat</h1>
        <div>
            <h3>Liste meuble</h3>
            <% if(meubles.isEmpty() == false){%>
            <table border=1>
                <tr>
                    <th width='200'>Nom</th>
                    <th width='200'>Prix</th>
                </tr>
                <%for (Meuble meuble : meubles) { %>
                <tr>
                    <td><% out.print(meuble.getNom()); %></td>
                    <td><% out.print(meuble.getPrix()); %> Ar</td>
                </tr> 
                <% } %>
            </table>
            <%}%>
        </div>
        <p><a href="formule/rechercheMeuble.jsp">Rechercher d'autre meuble</a></p>
        <a href="index.jsp">Home</a>
    </body>
</html>
