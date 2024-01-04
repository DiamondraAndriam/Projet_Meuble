<%-- 
    Document   : insertionStyle
    Created on : 12 déc. 2023, 16:09:23
    Author     : HERINIAINA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertion style</h1>
        <form action="<%=request.getContextPath()%>/InsertStyle" method="post">
            Nom: <input type="text" name="nom"><br>
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
