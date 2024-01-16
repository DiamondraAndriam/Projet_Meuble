<%-- 
    Document   : formuleFabrication
    Created on : 19 déc. 2023, 15:22:29
    Author     : nyanj
--%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble"%>
<% List<Meuble> liste =(List<Meuble>) request.getAttribute("liste"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formule de fabrication</title>
    </head>
    <body>
        <h1>Formule fabrication</h1>
        <form method="post" action="<%=request.getContextPath()%>/AjoutFormule">
            <label>Meuble</label>
            <select name="meuble">
                <% for (Meuble meuble : liste) { %>
                <option value="<% out.print(meuble.getId()); %>"><% out.print(meuble.getNom()); %></option>
                <% } %>
            </select>
            <button class="submit">OK</button>
        </form>
    </body>
</html>
