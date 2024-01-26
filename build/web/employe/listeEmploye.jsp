<%-- 
    Document   : listeEmploye
    Created on : 23 janv. 2024, 15:38:16
    Author     : Diamondra
--%>
<%@page import="java.util.List"%>
<%@page import="model.Personnel"%>
<%List<Personnel> person = (List<Personnel>) request.getAttribute("personnel"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Personnel</title>
    </head>
    <body>
        <h1>Liste Personnel</h1>
        <table>
            <tr>
                <th>Nom et prénom </th>
                <th>Experience</th>
                <th>Taux horaire</th>
            </tr>
            <% for (Personnel elem : person) { %>
            <tr>
                <td><%out.print(elem.getNom()+" "+elem.getPrenom());%></td>
                <td><%out.print(elem.getExperience());%></td>
                <td><%out.print(elem.getTauxHoraire());%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
