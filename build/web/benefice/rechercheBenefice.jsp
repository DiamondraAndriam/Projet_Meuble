<%-- 
    Document   : rechercheBenefice
    Created on : 16 janv. 2024, 16:01:46
    Author     : nyanj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche par bénéfice</title>
    </head>
    <body>
        <h1>Recherche par bénéfice</h1>
        <form method="<%=request.getContextPath()%>/RechercheBenefice" action="post">
            <div>
                <label>Min</label>
                <input type="text" name="min">
            <div>
            <div>
                <label>Max</label>
                <input type="text" name="max">
            <div>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
