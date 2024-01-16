<%-- 
    Document   : erreur
    Created on : 11 janv. 2024, 15:24:44
    Author     : Diamondra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    h2{
        color: red;
        font-size: 20px;
    }
</style>
    <div><center>
            <% out.print((String)request.getAttribute("erreur")); %>
    </center></div>