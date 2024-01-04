<%-- 
    Document   : insertionTaille
    Created on : 19 déc. 2023, 15:27:07
    Author     : nyanj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion taille</title>
    </head>
    <body>
        <h1>Insertion taille</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertTaille">
            <div>
                <label>Nom</label>
                <input type="text" name="nom">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
