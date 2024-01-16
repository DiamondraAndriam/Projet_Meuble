<%-- 
    Document   : achatMateriau
    Created on : 11 janv. 2024, 14:40:38
    Author     : nyanj
--%>
<%@page import="java.util.List"%>
<%@page import="model.Materiau"%>
<% List<Materiau> liste = (List<Materiau>) request.getAttribute("materiau");%>        
<h1>Achat materiau</h1>
        <form method="post" action="<%=request.getContextPath()%>/InsertAchatMateriau">
            <div>
                <label>Materiau</label>
                <select name="materiau">
                    <% for (Materiau mat : liste) { %>
                    <option value="<%out.print(mat.getId());%>"><%out.print(mat.getNom());%></option>
                    <% } %>
                </select>
            </div>
            <div>
                <label>Quantité</label>
                <input type="text" name="qte">
            </div>
            <button class="submit"> OK </button>
        </form>
    