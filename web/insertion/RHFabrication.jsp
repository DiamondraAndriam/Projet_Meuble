<%-- 
    Document   : RHFabrication
    Created on : 16 janv. 2024, 15:20:01
    Author     : nyanj
--%>
<%@page import="model.Taille"%>
<%@page import="java.util.List"%>
<% Taille taille = (Taille) request.getAttribute("taille"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Besoin RH fabrication</title>
    </head>
    <body>
        <h1>Besoin RH fabrication</h1>
        <form method="post" action="<%=request.getContextPath()%>/BesoinRHFabrication">
            <div>
                <label>Taille: <%out.print(taille.getNom());%></label>
            </div>
            <div>
                <label>Nombre</label>
                <input type="numeric" name="nombre">
            </div>
                <div>
                <label>Multiplicateur</label>
                <input type="numeric" name="multi">
            </div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
