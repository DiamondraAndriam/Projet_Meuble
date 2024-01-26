<%-- 
    Document   : insertionEmployeMeuble
    Created on : 16 janv. 2024, 15:38:37
    Author     : nyanj
--%>
<%@page import="model.Employe"%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble"%>
<%@page import=""%>
<%List<Meuble> meubles = (List<Meuble>) request.getAttribute("meubles");%>
<%List<Employe> employes = (List<Employe>) request.getAttribute("employes");%>
<%%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion besoin d'employé par meuble</title>
    </head>
    <body>
        <h1>Insertion besoin d'employé par meuble</h1>
        <form method="" action="">
            <select name="">
                <% for(Meuble meuble : meubles) { %>
                    <option value="<%meuble.getId();%>">
                        <%meuble.getNom();%>
                    </option>
                <%} %>
            </select>
            <input type="submit" value="OK">
        </form>
            <table>
                <tr>
                    <th>Type Employe</th>
                    <th>Nombre</th>
                    <th>Horaire</th>
                </tr>
                <% for(Employe employe : employes) { %>
                <tr>
                    <td><%employe.getType();%></td>
                    <td><input name="nombre" type="text" ></td>
                    <td><input name="horaire" type="text"></td>
                </tr>
                <% } %>
            </table>
    </body>
</html>
