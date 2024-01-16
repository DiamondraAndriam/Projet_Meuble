<%-- 
    Document   : ajoutPrix
    Created on : 9 janv. 2024, 14:36:20
    Author     : nyanj
--%>

<%@page import="java.util.List"%>
<%@page import="model.Materiau"%>
<% List<Materiau> materiaux = (List<Materiau>) request.getAttribute("materiaux");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajouter prix</h1>
        <form method="post" action="<%=request.getContextPath()%>/UpdatePrixMateriau">
            <div>
                <label>Matériau</label>
                <select name="materiau">
                    <% for (Materiau materiau : materiaux) { %>
                    <option value='<% out.print(materiau.getId());%>'><% out.print(materiau.getNom()); %></option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Prix</label>
                <input type="number" name="prix">
            </div>
            <button class="submit">OK</button>
        </form>
    </body>
</html>
