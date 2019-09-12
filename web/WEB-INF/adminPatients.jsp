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
                        <li><a href="admin_consultations" class="list-group-item list-group-item-action bg-light">Historique
                                des consultations</a></li>
                        <li><a class="list-group-item list-group-item-action active">Patients</a>
                        </li>
                        <li><a href="admin_medecins"
                                class="list-group-item list-group-item-action bg-light">Medecins</a>
                        </li>
                        <li><a href="admin_medicaments"
                                class="list-group-item list-group-item-action bg-light">Medicaments</a>
                        </li>
                        <li><a href="admin_personel"
                                class="list-group-item list-group-item-action bg-light">Personel</a>
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
                <h3 class="text-justify text-uppercase">Liste des patients inscrits</h3>
                <table class="table bg-dark text-white">
                    <thead class="thead-light text-dark">
                        <th scope="col">ID</th>
                        <th scope="col">Nom complet</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Contact</th>
                        <th scope="col">Medecin</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${patients}" var="pat">
                            <tr>
                                <th scope="row">${pat.getId()}</th>
                                <th scope="row">${pat.getName()} ${pat.getSurname()}</th>
                                <td>${pat.getAddress()}</td>
                                <td>${pat.getContact()}</td>
                                <td>${pat.medecin==null ? "None":pat.medecin.id}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>

</html>