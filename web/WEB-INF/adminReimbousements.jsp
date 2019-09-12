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
                        <li><a href="admin_patients"
                                class="list-group-item list-group-item-action bg-light">Patients</a>
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
                        <li><a
                                class="list-group-item list-group-item-action active">Reimboursements</a>
                        </li>
                        <li><a href="admin_profil"
                                class="list-group-item list-group-item-action bg-light">Modifier mon
                                profile</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
                <div class="row">
                    <div class="col-lg-5 col-md-5">
                        <form action="admin_reimboursement" method="post">
                            <h3>Effectuer un reimboursement</h3>
                            <label class="text-warning">${warning}</label>
                            <table class="table">
                                <tr>
                                    <td><input type="text" name="consid" id="consid" value="${consid}" placeholder="ID de la consultation" class="form-control" required="required"></td>
                                </tr>
                                <tr>
                                    <td><input type="number" step="0.0001" min="0" name="amount" value="${amount}" id="amount" placeholder="Montant" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <td><input type="date" name="date" id="date" value="${date}" placeholder="Date" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="VALIDER" class="validate-btn"></td>
                                </tr>
                            </table>
                        </form>
                        
                        <h4>Reimboursements</h4>
                        <table class="table text-white">
                            <thead class="thead-light">
                                <th>ID</th>
                                <th>Consultation</th>
                                <th>Montant</th>
                                <th>Date effectué</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${reimboursements}" var="rem">
                                    <tr>
                                        <td>${rem.id}</td>
                                        <td>${rem.consultation.id}</td>
                                        <td>${rem.amount}</td>
                                        <td>${rem.refundDate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-1 col-md-1"></div>
                    <div class="col-lg-6 col-md-6">
                        <h3 class="text-justify text-uppercase text-info">consultations</h3>
                        <table class="table text-white">
                            <thead class="thead-light">
                                <th scope="col">ID</th>
                                <th scope="col">ID Medecin</th>
                                <th scope="col">Patient</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${consultations}" var="cons">
                                    <tr>
                                        <td scope="row">${cons.id}</td>
                                        <td scope="row">${cons.doctor.id}</td>
                                        <td scope="row">${cons.patient.id} ${cons.patient.name}</td>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>