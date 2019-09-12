<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>${patient.name}</title>

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
                    <li class="page-item page-link">Home</li>
                    <li class="page-item page-link"><a href="signout">Sign out</a></li>
                </ol>
            </div>
        </header>

        <div class="container-fluid content">
            <!--Left navigation area-->
            <div class="col-lg-3 col-md-3 bg-info">
                <div>
                    <h3 class="text-secondary text-uppercase">${patient.name} ${patient.surname}
                    </h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a href=""
                                class="list-group-item list-group-item-action bg-light">Choisir
                                Medecin</a>
                        </li>
                        <li><a 
                                class="list-group-item list-group-item-action active">Modifier
                                profil</a></li>
                        <li><a href="" class="list-group-item list-group-item-action bg-light">Historique
                                des consultations</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
                <h3>Modifier votre profile: ${patient.id}</h3>
                <p class="info">${alert}</p>
                <fieldset>
                    <form action="post">
                        <table class="table text-white">
                            <tr>
                                <td>Nom</td>
                                <td><input type="text" name="name" id="name" class="form-control"
                                        value="${patient.name}" required="required"></td>
                            </tr>
                            <tr>
                                <td>Prenom</td>
                                <td><input type="text" name="surname" id="surname"
                                        value="${patient.surname}" class="form-control"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td>Adresse</td>
                                <td><input type="text" name="address" id="address"
                                        class="form-control" value="${patient.address}"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td>Contact</td>
                                <td><input type="tel" name="telephone" id="telephone"
                                        class="form-control" value="$patient.contact"
                                        required="required"></td>
                            </tr>
                                                        <tr>
                                <td>Mot de passe</td>
                                <td><input type="password" name="password" id="password"
                                        class="form-control" value="${patient.password}"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td>Confirmer mot de passe</td>
                                <td><input type="password" name="password2" id="password2"
                                        class="form-control" value="${patient.password}"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Valider" class="validate-btn"></td>
                            </tr>
                        </table>
                    </form>
                </fieldset>
            </div>
        </div>
    </body>

</html>