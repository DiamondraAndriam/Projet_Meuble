<%@page import="model.Meuble"%>
<%@page import="java.util.List"%>
<%@page import="model.Client"%>
<%List<Client> client = Client.findAll(null);%>
<%List<Meuble> meuble = Meuble.findAll(null);%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vente</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <section class="position-relative py-4 py-xl-5">
        <div class="container position-relative">
            <div class="row d-flex justify-content-center">
                <div class="col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                    <div class="card mb-5">
                        <div class="card-body p-sm-5">
                            <h2 class="text-center mb-4">&nbsp;Vente</h2>
                            <form method="post" action="<%=request.getContextPath()%>/InsertVente">
                                <select name="client" id="">
                                    <%for (Client cli : client) { %>
                                            <option value="<%out.print(cli.getId());%>"><%out.print(cli.getNom());%></option>
                                    <%   } %>
                                </select><br>
                                <label>Date d'achat: </label>
                                <input type="date" name="date">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>Meuble</th>
                                        <th>Quantite</th>
                                    </tr>
                                    <%for (Meuble meub : meuble) { %>
                                    <tr>
                                        <td><%out.print(meub.getNom());%></td>
                                        <td>
                                            <input type="number" name="quantite">
                                        </td>
                                    </tr>
                                    <%    }
                                    %>
                                </table>
                                <div><button class="btn btn-primary d-block w-100" type="submit">Acheter </button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>