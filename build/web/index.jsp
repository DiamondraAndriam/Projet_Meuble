<%-- 
    Document   : index
    Created on : 13 déc. 2023, 12:50:23
    Author     : HERINIAINA
--%>
<%
    String linkPage = request.getParameter("page");
    if(linkPage == null){
        linkPage = "home.jsp";
    } 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Container</title>
    <link rel="stylesheet" href="asset/css/header.css">
    <link rel="stylesheet" href="asset/css/cont.css">
</head>
<body>
    <div class="header">
        <div class="logo">Meuble+</div>
        <div class="menu">
            
        </div>
    </div>
    <div class="container">
        <div class="left-menu">
            <div class="cont-btn">
                <h3 class="h3">Insertion</h3>
                <a href ="<%=request.getContextPath()%>/index.jsp?page=insertion/insertionMateriau.jsp"><button class="left-btn"> Matériau</button></a>
                <a href="<%=request.getContextPath()%>/index.jsp?page=insertion/insertionCategorie.jsp"><button class="left-btn"> Categorie</button></a>
                <a href="<%=request.getContextPath()%>/index.jsp?page=insertion/insertionStyle.jsp"><button class="left-btn"> Style</button></a>
                <a href="<%=request.getContextPath()%>/index.jsp?page=insertion/insertionTaille.jsp"><button class="left-btn"> Taille</button></a>
                <a href="<%=request.getContextPath()%>/AjoutMeuble"><button class="left-btn"> Meuble</button></a>
                <a href="<%=request.getContextPath()%>/MeubleFormule"><button class="left-btn"> Formule de meuble</button></a>
            </div>
            <div class="cont-btn">
                <h3 class="h3">Style</h3>
                <a href="<%=request.getContextPath()%>/SetStyleMateriaux"><button class="left-btn">Ajouter Matériau pour un style</button></a>
                <a href="<%=request.getContextPath()%>/DetailsStyle"><button class="left-btn">Recherche de style par matériau</button></a>
            </div>
            <div class="cont-btn">
                <h3 class="h3">Matériau</h3>
                <a href="<%=request.getContextPath()%>/PrixMateriau"><button class="left-btn">Update prix matériau</button></a>
                <a href="<%=request.getContextPath()%>/AchatMateriau"><button class="left-btn">Acheter matériau</button></a>
            </div>
            <div class="cont-btn">
                <h3 class="h3">Matériau</h3>
                <a href="<%=request.getContextPath()%>/FabriquerMeuble"><button class="left-btn">Fabriquer un meuble</button></a>
                <a href="<%=request.getContextPath()%>/EtatStock"><button class="left-btn">Etat de stock</button></a>
            </div>
            <div class="cont-btn">
                <h3 class="h3">RH</h3>
                <a href="<%=request.getContextPath()%>/index.jsp?page=employe/insertionPoste.jsp/"><button class="left-btn">Insérer un nouveau poste</button></a>
                <a href="<%=request.getContextPath()%>/BesoinHoraireFabrication"><button class="left-btn">Insérer un besoin par catégorie</button></a>
                <a href="<%=request.getContextPath()%>/BesoinRHFabrication"><button class="left-btn">Insérer un besoin par taille</button></a>
                <a href="<%=request.getContextPath()%>/BesoinMeuble"><button class="left-btn">Insérer un besoin par meuble</button></a>
                <a href="<%=request.getContextPath()%>/NewEmploye"><button class="left-btn">Insérer un employé</button></a> 
                <a href="<%=request.getContextPath()%>/ListeEmploye"><button class="left-btn">Liste des employés</button></a> 
            </div>
            <div class="cont-btn">
                <h3 class="h3">Recherche de Meuble</h3>
                <a href="<%=request.getContextPath()%>/Rechercher"><button class="left-btn">Par matériau</button></a>
                <a href="<%=request.getContextPath()%>/RecherchePrixMeuble"><button class="left-btn">Par prix</button></a>
                <a href="<%=request.getContextPath()%>/RechercheBeneficeMeuble"><button class="left-btn">Par benefice</button></a>
            </div>
            <div class="cont-btn">
                <h3 class="h3">Vente de Meuble</h3>
                <a href="<%=request.getContextPath()%>/EtatVente"><button class="left-btn">Etat de vente par genre</button></a>
                <a href="<%=request.getContextPath()%>/index.jsp?page=vente/Vente.jsp"><button class="left-btn">Insertion de vente</button></a>
                <a href="<%=request.getContextPath()%>/index.jsp?page=vente/insertion_client.jsp"><button class="left-btn">Insrtion de client</button></a>
             </div>
        </div>
        <div class="elements">
            <jsp:include page="<%= linkPage %>"/>
        </div>
    </div>
</body>
</html>