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
                        <li><a class="list-group-item list-group-item-action active">Historique
                                des consultations</a></li>
                        <li><a href="admin_patients"
                                class="list-group-item list-group-item-action bg-light">Patients</a>
                        </li>
                        <li><a href="admin_medecins"
                                class="list-group-item list-group-item-action bg-light">Medecins</a>
                        </li>
                        <li><a href="admin_medicaments" class="list-group-item list-group-item-action bg-light">Medicaments</a>
                        </li>
                        <li><a href="admin_personel" class="list-group-item list-group-item-action bg-light">Personel</a>
                        </li>
                        <li><a href="admin_reimboursement"
                                class="list-group-item list-group-item-action bg-light">Reimboursements</a>
                        </li>
                        <li><a href="admin_profil"
                                class="list-group-item list-group-item-action bg-light">Modifier mon
                                profile</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
                <h3 class="text-justify text-uppercase">Historique des consultations</h3>
                <table class="table text-white">
                    <thead class="thead-light">
                        <th scope="col">ID</th>
                        <th scope="col">Patient</th>
                        <th scope="col">Date</th>
                        <th scope="col">Medecin</th>
                        <th scope="col">Medicaments prescrits</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${consultations}" var="cons">
                            <tr>
                                <th scope="row">${cons.id}</th>
                                <th scope="row">${cons.patient.name} ${cons.patient.surname}(${cons.patient.id})</th>
                                <td>${cons.date}</td>
                                <td>${cons.doctor.name} ${cons.doctor.surname}(${cons.doctor.id})</td>
                                <td>
                                    <ul>
                                        <c:forEach items="${cons.medicaments}" var="med">
                                            <li>${med.name}</li>
                                        </c:forEach>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>

</html> 