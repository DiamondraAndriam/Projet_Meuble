<%-- 
    Document   : Test
    Created on : 12 déc. 2023, 15:35:59
    Author     : nyanj
--%>
<%@page import="model.Materiau"%>
<%@page import="model.FormuleQuantite"%>
<%@page import="java.util.List"%>
<% 
    List<FormuleQuantite> resultat = (List<FormuleQuantite>) request.getAttribute("resultat"); 
    List<Materiau> materiaux = (List<Materiau>) request.getAttribute("materiau");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche de meuble</title>
    </head>
    <body>
        <h1>Recherche de meuble par matériau</h1>
        <form method="post" action="<%=request.getContextPath()%>/RechercherFormule">
            <div>
                <label>Matériau</label>
                <select name="materiau">
                    <% for (Materiau materiau : materiaux) { %>
                    <option value="<% out.print(materiau.getId()); %>"><% out.print(materiau.getNom()); %></option>
                    <% } %>
                </select>
            </div>
            <input type="submit" value="Rechercher">
        </form>
        <br>
        
    </body>
</html>
