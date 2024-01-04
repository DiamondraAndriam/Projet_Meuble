<%-- 
    Document   : InsertStyleMateriau
    Created on : 12 déc. 2023, 16:17:08
    Author     : HERINIAINA
--%>
<%@page import="model.Style"%>
<%@page import="java.util.List" %>
<%@page import="model.Materiau" %>
<% List<Style> styles = (List<Style>) request.getAttribute("styles"); %>
<% List<Materiau> liste = (List<Materiau>) request.getAttribute("materiaux"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion Matériau au style</title>
    </head>
    <body>
        <h1>Insertion Matériau au style</h1>
        <form action="<%=request.getContextPath()%>/InsertStyleMateriau" method="get">
            Style : <select name="style">
                <% for (Style style : styles) { %>
                <option value="<%out.print(style.getId());%>"><%out.print(style.getNom());%></option>        
                <% }
                %>
            </select><br>
            <%for (Materiau materiau : liste) { %>
            <input type="checkbox" value="<%out.print(materiau.getId());%>" name="materiau"> <%out.print(materiau.getNom());%><br/> 
            <% } %>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
