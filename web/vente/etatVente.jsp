<%-- 
    Document   : etatVente
    Created on : 25 janv. 2024, 14:56:51
    Author     : Diamondra
--%>
<%@page import="java.util.List"%>
<%@page import="model.Meuble"%>
<% 
    int qteHomme = (Integer) request.getAttribute("homme"); 
    int qteFemme = (Integer) request.getAttribute("femme");
    List<Meuble> meubles = Meuble.findAll(null);
    if(request.getAttribute("meuble")!=null){ 
        Meuble meuble = (Meuble) request.getAttribute("meuble");%>
    <p>Pour le meuble : <%out.print(meuble.getNom());%></p> 
    <%}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<label>Filtre par meuble:</label>
<form action="<%=request.getContextPath()%>/EtatVenteMeuble" method="post">
<select name ="meuble"><option value=""></option>
    <%for (Meuble elem : meubles) {
    %>
    <option value="<%out.print(elem.getId());%>"><%out.print(elem.getNom());%></option>
    <%}%>
</select>
<button class="submit">Rechercher</button>
</form>
<table>
    <tr>
        <th>Genre</th>
        <th>Vente</th>
    </tr>
    <tr>
        <td>Homme</td>
        <td><%out.print(qteHomme);%></td>
    </tr>
    <tr>
        <td>Femme</td>
        <td><%out.print(qteFemme);%></td>
    </tr>
</table>

<div class="chart-pie pt-4">
    <canvas id="myPieChart"></canvas>
</div>
<canvas></canvas>
<script src="asset/js/Chart.min.js"></script>
<script>
    // Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Homme", "Femme"],
    datasets: [{
      data: [<%out.print(qteHomme);%>, <%out.print(qteFemme);%>],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }]
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80
  },
});
</script>
