<%-- 
    Document   : fabricationMeuble
    Created on : 11 janv. 2024, 14:43:47
    Author     : nyanj
--%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble"%>
<%List<Meuble> meubles = (List<Meuble>) request.getAttribute("meuble");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabrication de meuble</title>
    </head>
    <body>
        <h1>Fabriccation de meuble</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertFabriquerMeuble">
            <div>
                <label>Meuble</label>
                <select name="idmeuble">
                    <%for(Meuble meuble: meubles){ %>
                    <option value="<%out.print(meuble.getId());%>"><%out.print(meuble.getNom());%></option>
                    <% }%>
                </select>
            </div>
            <div>
                <label>Quantité</label>
                <input type="numeric" name="qte">
            </div>
                <button class="submit">OK</button>
        </form>
    </body>
</html>
