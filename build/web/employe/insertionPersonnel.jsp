<%-- 
    Document   : insertionPersonnel
    Created on : 23 janv. 2024, 15:34:19
    Author     : Diamondra
--%>
<%@page import="java.util.List"%>
<%@page import="model.Poste"%>
<%List<Poste> emp = (List<Poste>) request.getAttribute("postes"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertion experience d'employé</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertEmploye">
            <div>
                <label>Nom</label>
                <input type="text" name="nom">
            </div>
            <div>
                <label>Prenom</label>
                <input type="text" name="prenom">
            </div>
            <div>
                <label>Date de naissance</label>
                <input type="date" name="date_naissance">
            </div><div>
                <label>Date d'embauche</label>
                <input type="date" name="date_embauche">
            </div>
            <div>
                <label>Poste</label>
                <select name='poste'>
                    <%for (Poste Poste : emp) { %>
                        <option value=<%out.print(Poste.getNom());%>></option>
                    <% } %>
                </select>
            </div>
                <button class="submit">OK</button>
        </form>
    </body>
</html>
