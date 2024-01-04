<%-- 
    Document   : formuleDetail
    Created on : 19 déc. 2023, 15:30:48
    Author     : nyanj
--%>
<%@page import="model.Meuble"%>
<%@page import="java.util.List"%>
<%@page import="model.Materiau"%>
<% List<Materiau> liste = (List<Materiau>) request.getAttribute("liste");%>
<% Meuble meuble = (Meuble) request.getAttribute("meuble");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails formule de fabrication</title>
    </head>
    <body>
        <h1>Détails formule</h1>
        <form method="" action="post">
            <p>Meuble :<%out.print(meuble.getNom());%></p>
            <div>
                <label>Qté matériau 1</label>
                <input type="number" name="">
            </div>
            <div>
                <label>Qté matériau 1</label>
                <input type="number" name="">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
