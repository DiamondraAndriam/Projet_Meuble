<%-- 
    Document   : rechercheMeuble
    Created on : 9 janv. 2024, 14:30:11
    Author     : nyanj
--%>
<% String erreur = request.getParameter("erreur");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(erreur!=null) out.print("<div style='color:red'>"+erreur+"</div>");%>
        <h1>Recherche meuble par prix</h1>
        <form method="post" action="<%=request.getContextPath()%>/RecherchePrixMeuble">
            <div>
                <label>Montant max</label>
                <input type="numeric"name="max">
            </div>
            <div>
                <label>Montant min</label>
                <input type="numeric" name="min">
            </div>
            <input type="submit"value="Rechercher">
        </form>
        <br>
    </body>
</html>
