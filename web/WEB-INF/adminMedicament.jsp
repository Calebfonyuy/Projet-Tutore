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
                        <li><a class="list-group-item list-group-item-action active">Medicaments</a>
                        </li>
                        <li><a href="admin_personel"
                                class="list-group-item list-group-item-action bg-light">Personel</a>
                        </li>
                        <li><a href="admin_reimboursements"
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
                <h3 class="text-justify text-uppercase">Gestion des Medicaments</h3>
                <div class="row">
                    <div class="col-lg-7 col-md-7">
                        <table class="table bg-dark text-light">
                            <thead class="bg-dark text-light">
                                <th scope="row">ID</th>
                                <th scope="row">NAME</th>
                                <th scope="row">DESCRIPTION</th>
                            </thead>
                            <tbody class="text-white">
                                <c:forEach items="${meds}" var="m">
                                    <tr>
                                        <td>${m.id}</td>
                                        <td>${m.name}</td>
                                        <td>${m.description}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <fieldset>
                            <label class="text-danger text-uppercase">Nouveau Medicament</label>
                            <form action="admin_medicaments" method="post">
                                <label class="text-danger">${warning}</label>
                                <table class="table text-light bg-secondary">
                                    <tr>
                                        <td>Nom</td>
                                        <td><input type="text" name="name" value="${name}" id="name" required></td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td><textarea name="desc" id="desc" height="300" value="${desc}" required></textarea></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="AJOUTER"></td>
                                    </tr>
                                </table>
                            </form>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>