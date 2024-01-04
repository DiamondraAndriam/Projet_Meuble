<%-- 
    Document   : formuleDetail
    Created on : 19 déc. 2023, 15:30:48
    Author     : nyanj
--%>
<%@page import="model.Meuble"%>
<%@page import="java.util.List"%>
<%@page import="model.Materiau"%>
<% List<Materiau> liste = (List<Materiau>) request.getAttribute("materiaux");%>
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
        <form method="post" action="<%=request.getContextPath()%>/InsertFormule">
            <input type="hidden" value="<% out.print(meuble.getId());%>" name="id_meuble">
            <p>Meuble :<%out.print(meuble.getNom());%></p>
            <% for(Materiau mat : liste){ %>
            <div>
                <label>Quantité de <% out.print(mat.getNom()); %></label>
                <input type="number" name=<%out.print(mat.getId());%>>
            </div>
            <% } %>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
