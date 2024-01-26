<%-- 
    Document   : filtreStock.jsp
    Created on : 16 janv. 2024, 14:08:18
    Author     : Diamondra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Filtrer stock</h1>
        <form action="<%=request.getContextPath()%>/EtatStockMateriau" method="post">
            <label>Nom du materiau</label>
            <input type="text" name="nom">
            <button class="submit"> Filtrer</button>
        </form>
    </body>
</html>
