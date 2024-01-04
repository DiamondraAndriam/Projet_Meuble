<%-- 
    Document   : resultat
    Created on : 4 janv. 2024, 15:13:49
    Author     : HERINIAINA
--%>
<%@page import="java.util.List"%>
<%@page import="model.FormuleQuantite"%>
<% 
    List<FormuleQuantite> resultat = (List<FormuleQuantite>) request.getAttribute("liste"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  if(resultat != null){
                if(resultat.isEmpty()==false){ %>
        <table>
            <tr>
                <th>Meuble</th>
                <th>Quantité</th>
            </tr>
            <% for(FormuleQuantite formule : resultat){ %>
            <tr>
                <td><% out.print(formule.getMeuble().getNom());%></td>
                <td><% out.print(formule.getQuantite()); %></td>
            </tr>
            <% } %>
        </table>
        <% }} %>
    </body>
</html>
