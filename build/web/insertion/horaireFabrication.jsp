<%-- 
    Document   : horaireFabrication
    Created on : 16 janv. 2024, 15:31:34
    Author     : nyanj
--%>
<%@page import="java.util.List"%>
<%@page import="model.Categorie"%>
<%List<Categorie> categories = (List<Categorie>) request.getAttribute("cat");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Besoin horaire fabrication</title>
    </head>
    <body>
        <h1>Besoin horaire fabrication</h1>
        <form method="" action="">
            <div>
                <label>Categorie</label>
                <select name="categorie">
                    <% for(Categorie categorie : categories) { %>
                    <option value="<%categorie.getId();%>">
                        <%categorie.getNom();%>
                    </option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Horaire</label>
                <input type="text" name="horaire">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
