<%-- 
    Document   : liste
    Created on : 12 déc. 2023, 10:03:38
    Author     : HERINIAINA
--%>
<%@page import="java.util.List"%>
<%@page import="model.Model" %>
<%List<Model> models = (List<Model>) request.getAttribute("models");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Liste de Model</h1>
        <table>
            <tr>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>
    </body>
</html>
