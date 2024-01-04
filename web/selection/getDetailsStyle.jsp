<%-- 
    Document   : getDetailsStyle
    Created on : 12 déc. 2023, 17:06:04
    Author     : HERINIAINA
--%>
<%@page import="model.Materiau"%>
<%@page import="model.Style"%>
<%@page import="java.util.List"%>
<%List<Style> style = (List<Style>) request.getAttribute("listeStyle");%>
<%List<Materiau> mat = (List<Materiau>) request.getAttribute("listeMateriau");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Details Style</h1>
        <form action="GetMateriauxStyle">
            <select>
                <%for (Style elem : style) { %>
                <option value="<% out.print(elem.getId()); %>"><% out.print(elem.getNom()); %></option>
                <% } %>
            </select>
            <%for (Materiau elem : mat) { %>
            <input type="checkbox" name="materiau" value ="<% out.print(elem.getId()); %>"> <% out.print(elem.getNom()); %> <br>
            <% } %>
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
