<%-- 
    Document   : insertion
    Created on : 12 déc. 2023, 10:03:50
    Author     : HERINIAINA
--%>
<%@page import="model.Model"%>
<%Model model = (Model) request.getAttribute("");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="post" method="insertModel">
            <h1>Modifier Model</h1>
            Nom: <input type="text" name="nom" value="<%%>"><br/>
            Détails: <input type="text" name="details" value="<%%>"><br/>
            <input type="submit" value="Ajouter">
        </form>
    </body>
</html>
