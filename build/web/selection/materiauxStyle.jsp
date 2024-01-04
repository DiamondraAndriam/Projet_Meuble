<%-- 
    Document   : newjsp
    Created on : 12 déc. 2023, 17:22:18
    Author     : HERINIAINA
--%>
<%@page import="model.Style"%>
<%@page import="java.util.List"%>
<%@page import="model.Materiau"%>
<% List<Materiau> materiau = (List<Materiau>) request.getAttribute("materiaux");%>
<% Style style = (Style) request.getAttribute("style"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Style : <%out.print(style.getNom());%></h1>
        Materiaux: <li>
        <%for (Materiau elem : materiau) { %>
         <ul><%out.print(elem.getNom());%></ul>
        <% } %>
    </li>
    </body>
</html>
