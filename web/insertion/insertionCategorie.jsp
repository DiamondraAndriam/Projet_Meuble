<%-- 
    Document   : insertionCategorie
    Created on : 19 déc. 2023, 15:24:46
    Author     : nyanj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion catégorie</title>
    </head>
    <body>
        <h1>Insertion catégorie</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertCategorie">
            <div>
                <label>Nom</label>
                <input type="text" name="categorie">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
