<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>vente</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
</head>

<body>
    <section class="position-relative py-4 py-xl-5">
        <div class="container position-relative">
            <div class="row d-flex justify-content-center">
                <div class="col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                    <div class="card mb-5">
                        <div class="card-body p-sm-5">
                            <h2 class="text-center mb-4">&nbsp;Insertion client</h2>
                            <form method="post" action="<%=request.getContextPath()%>/InsertClient">
                                <div class="mb-3"><input class="form-control" type="text" id="" name="nom" placeholder="Nom"></div>
                                <div class="mb-3"><input class="form-control" type="text" id="" name="prenom" placeholder="Prenom"></div>
                                <select name="genre" id="">
                                    <option value=""></option>
                                    <option value=0>Homme</option>
                                    <option value=1>Femme</option>
                                </select>
                                <div class="mb-3"></div>
                                <div><button class="btn btn-primary d-block w-100" type="submit">Send </button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>