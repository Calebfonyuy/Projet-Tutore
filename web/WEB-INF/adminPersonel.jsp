<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>${personel.name}</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Your custom styles (optional) -->
        <link href="css/style.css" rel="stylesheet">
    </head>


    <!--Body beginning Background in dark color and text all in white-->
    
    <body class="bg-dark text-white">

        <header class="navbar navbar-nav bg-info">
            <a class="navbar-brand" style="float: left;">
                <h2 class="bg-highlight text-warning">BATCH INSURANCE</h2>
            </a>
            <div class="pagination pagination-sm justify-content-right" style="float: left;">
                <ol class="none-list nav-list">
                    <li class="page-item page-link"><a href="admin_home">Home</a></li>
                    <li class="page-item page-link"><a href="signout">Sign out</a></li>
                </ol>
            </div>
        </header>

        <div class="container-fluid content">
            <!--Left navigation area-->
            <div class="col-lg-3 col-md-3 bg-info">
                <div>
                    <h3 class="text-secondary text-uppercase">${personel.name} ${personel.surname}
                    </h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a href="admin_consultations"
                                class="list-group-item list-group-item-action bg-light">Historique
                                des consultations</a></li>
                        <li><a href="admin_patients" class="list-group-item list-group-item-action bg-light">Patients</a>
                        </li>
                        <li><a href="admin_medecins"
                                class="list-group-item list-group-item-action bg-light">Medecins</a>
                        </li>
                        <li><a href="admin_medicaments"
                                class="list-group-item list-group-item-action bg-light">Medicaments</a>
                        </li>
                        <li><a
                                class="list-group-item list-group-item-action active">Personel</a>
                        </li>
                        <li><a href="admin_reimboursement"
                                class="list-group-item list-group-item-action bg-light">Reimboursements</a>
                        </li>
                        <li><a href="admin_profil"
                                class="list-group-item list-group-item-action bg-light">Modifier mon
                                profil</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <h3 class="text-info">Inscrire personel</h3>
                        <form action="personel" method="post">
                            <table class="table text-white">
                                <tr>
                                    <td>Nom</td>
                                    <td><input type="text" name="name" id="name"
                                            class="form-control" value="${npers.name}"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td>Prenom</td>
                                    <td><input type="text" name="surname" id="surname"
                                            value="${npers.surname}" class="form-control"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td>Adresse</td>
                                    <td><input type="text" name="address" id="address"
                                            class="form-control" value="${npers.address}"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td>Contact</td>
                                    <td><input type="tel" name="telephone" id="telephone"
                                            class="form-control" value="${npers.contact}"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td>Mot de passe</td>
                                    <td><input type="password" name="password" id="password"
                                            class="form-control" value="${npers.password}"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td>Confirmer mot de passe</td>
                                    <td><input type="password" name="password2" id="password2"
                                            class="form-control" value="${npers.password}"
                                            required="required"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Valider" class="validate-btn">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div class="col-lg-1 col-md-1"></div>
                    <div class="col-lg-6 col-md-6">
                        <h3 class="text-justify text-uppercase">Liste des personels</h3>
                        <table class="table text-white">
                            <thead class="thead-light">
                                <th scope="col">ID</th>
                                <th scope="col">Nom complet</th>
                                <th scope="col">Adresse</th>
                                <th scope="col">Contact</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${personels}" var="pat">
                                    <tr>
                                        <th scope="row">${pat.id}</th>
                                        <th scope="row">${pat.name} ${pat.surname}</th>
                                        <td>${pat.address}</td>
                                        <td>${pat.contact}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>