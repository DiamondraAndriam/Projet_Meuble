<%-- 
    Document   : ajoutMeuble
    Created on : 19 déc. 2023, 15:19:33
    Author     : nyanj
--%>

<%@page import="model.Style"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="model.Taille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Taille> tailles = (List<Taille>) request.getAttribute("tailles");
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories"); 
    List<Style> styles = (List<Style>) request.getAttribute("styles");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout meuble</title>
    </head>
    <body>
        <h1>Meuble</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertMeuble">
            <div>
                <label>Catégorie</label>
                <select name="categorie">
                    <% for (Categorie cat : categories) { %>   
                        <option value="<% out.print(cat.getId()); %>"><% out.print(cat.getNom()); %></option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Taille</label>
                <select name="taille">
                    <% for (Taille taille : tailles) { %>   
                    <option value="<% out.print(taille.getId()); %>"><% out.print(taille.getNom()); %></option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Style</label>
                <select name="style">
                    <% for (Style style : styles) { %>   
                        <option value="<% out.print(style.getId()); %>"> <% out.print(style.getNom());%> </option>
                    <% } %>
                </select>
            </div>
                <button class="submit">OK</button>
        </form>
    </body>
</html>
