<%-- 
    Document   : ajoutMeuble
    Created on : 19 déc. 2023, 15:19:33
    Author     : nyanj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout meuble</title>
    </head>
    <body>
        <h1>Meuble</h1>
        <form method="" action="">
            <div>
                <label>Catégorie</label>
                <select name="categorie">
                    <option value=""></option>
                </select>
            </div>
            <div>
                <label>Taille</label>
                <select name="taille">
                    <option value=""></option>
                </select>
            </div>
            <div>
                <label>Style</label>
                <select name="style">
                    <option value=""></option>
                </select>
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
