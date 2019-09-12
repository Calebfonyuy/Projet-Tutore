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
                    <li class="page-item page-link"><a href="signout">Sign out</a></li>
                </ol>
            </div>
        </header>

        <div class="container-fluid content">
            <!--Left navigation area-->
            <div class="col-lg-9 col-md-9">
                <div>
                    <h3 class="text-light text-uppercase">${personel.name} ${personel.surname}
                    </h3>
                </div>
            </div>

            <!--Main content area-->
            <div class="text-wrap display">
                <h3 class="text-justify text-uppercase">Accueil</h3>
                <div class="row">
                    <div class="card home-card bg-warning">
                        <a href="admin_patients">
                            <img src="ressources/patient.png" alt="PATIENTS" width="200" height="150" />
                            <div class="card-body">
                                <h4 class="card-title">PATIENTS</h4>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-light text-dark">
                        <a href="admin_medecins">
                            <img src="ressources/medecin.png" alt="MEDECINS" width="200" height="150" />
                            <div class="card-body">
                                <h4 class="card-title">MEDECINS</h4>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-success">
                        <a href="admin_consultations">
                            <img src="ressources/consultation.jpeg" alt="CONSULTATIONS" width="200" height="150" />
                            <div class="card-body">
                                <h5 class="card-title">CONSULTATION</h5>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-light text-dark">
                        <a href="admin_medicaments">
                            <img src="ressources/medicament.png" alt="MEDICAMENTS" width="200" height="150"/>
                            <div class="card-body">
                                <h5 class="card-title">MEDICAMENTS</h5>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-light text-dark">
                        <a href="admin_reimboursement">
                            <img src="ressources/reimbourse.jpeg" alt="REIMBOUSEMENTS" width="200" height="150" />
                            <div class="card-body">
                                <h6 class="card-title">REIMBOUSEMENTS</h6>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-light text-dark">
                        <a href="admin_personel">
                            <img src="ressources/personnel.jpeg" alt="PERSONEL" width="200" height="150" />
                            <div class="card-body">
                                <h5 class="card-title">PERSONEL</h5>
                            </div>
                        </a>
                    </div>
                    <div class="card home-card bg-light text-dark">
                        <a href="admin_profil">
                            <img src="ressources/profile.png" alt="PERSONEL" width="200" height="150" />
                            <div class="card-body">
                                <h5 class="card-title">MON PROFIL</h5>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>