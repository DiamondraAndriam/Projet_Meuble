<%-- 
    Document   : insertionExperience
    Created on : 23 janv. 2024, 15:15:41
    Author     : Diamondra
--%>
<%@page import="model.Employe"%>
<%@page import="java.util.List"%>
<%List<Employe> emp = (List<Employe>) request.getAttribute("emp"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion experience</title>
    </head>
    <body>
        <form action='post' method='<%=request.getContextPath()%>/InsertExperience'>
          <label>
                Poste:
            <select name='poste'>
                    <%for (Employe employe : emp) { %>
                    <option value=<%out.print(employe.getType());%>></option><%   }
                    %>
            </select>
          </label>
            <p>
                Niveau:
                <input type='text' name='niveau'>
            </p>
            <p>
                Experience minimum:
                <input type='numeric' name='min'>
            </p>
            <p>
                Experience maximum:
                <input type='numeric' name='max'>
            </p>
            <p>
                Multiplicateur:
                <input type='numeric' name='multi'>
            </p>
            <p>
                
                <input type='submit' value='OK'>
            </p>
            
        </form>
    </body>
</html>
