<%-- 
    Document   : fiche
    Created on : 12 déc. 2023, 10:00:41
    Author     : HERINIAINA
--%>
<%@page import="model.Model"%>
<% Model model = (Model) request.getAttribute("model");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Fiche [Model]</h1>
        Nom: <% out.print(model.getNom());%><br/>
        Détails: <% out.print(model.getDetails());%><br/>
        <a href="">Modifier</a> <a href="">Supprimer</a>
    </body>
</html>
