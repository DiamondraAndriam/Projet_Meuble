<%-- 
    Document   : getMateriau
    Created on : 14 déc. 2023, 14:11:35
    Author     : HERINIAINA
--%>
<%@page import="java.util.List"%>
<%@page import="model.Style"%>
<%List<Style> styles = (List<Style>) request.getAttribute("style");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Les matériaux du style</h1>
        <form action="<%=request.getContextPath()%>/ListeMateriauStyle" method="post">
            Style:
            <select name="style">
                <%for (Style elem : styles) { %>
                <option value="<%out.print(elem.getId());%>"><%out.print(elem.getNom());%></option>
                <% } %>
            </select>
            <input type="submit" value="Ok">
        </form>
    </body>
</html>
