<%-- 
    Document   : insertionEmploye
    Created on : 16 janv. 2024, 15:53:10
    Author     : nyanj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion employé</title>
    </head>
    <body>
        <h1>Insertion poste d'employé</h1>
        <form method="post" action="<%=request.getContextPath()%>/IsnertPoste">
            <div>
                <label>Type</label>
                <input type="text" name="type">
            </div>
            <div>
                <label>Taux horaire</label>
                <input type="numeric" name="taux">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
