<%-- 
    Document   : formuleFabrication
    Created on : 19 déc. 2023, 15:22:29
    Author     : nyanj
--%>
<%@page import="model.FormuleQuantite"%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble"%>
<% List<Meuble> liste =(List<Meuble>) request.getAttribute("liste"); %>
<% List<FormuleQuantite> resultat = (List<FormuleQuantite>) request.getAttribute("resultat"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formule de fabrication</title>
    </head>
    <body>
        <h1>Formule fabrication</h1>
        <form method="" action="">
            <label>Meuble</label>
            <select name="meuble">
                <% for (Meuble meuble : liste) { %>
                <option value="<% out.print(meuble); %>"><% %></option>
                <% } %>
            </select>
            <input type="submit" value="Rechercher">
        </form>
            <% if(resultat.isEmpty()==false){%>
            <table>
                
            </table>
            <% } %>
    </body>
</html>
