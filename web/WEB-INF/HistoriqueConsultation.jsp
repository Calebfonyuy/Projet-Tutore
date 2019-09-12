<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>${medecin.name}</title>

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
            <div class="col-lg-3 col-md-3 bg-info">
                <div>
                    <h3 class="text-secondary text-uppercase">${medecin.name}  ${medecin.surname}</h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a href="ConsultationServlet" class="list-group-item list-group-item-action bg-light">Consultation</a>
                        </li>
                        <li><a href="ModifierProfilMedecin" class="list-group-item list-group-item-action bg-light">Modifier
                                profile</a></li>
                        <li><a class="list-group-item list-group-item-action active">Historique
                                des consultations</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
                <h3 class="text-justify text-uppercase">Historique des consultations</h3>
                <table class="table text-white">
                    <thead class="thead-light">
                        <th scope="col">ID</th>
                        <th scope="col">Patient(ID)</th>
                        <th scope="col">Observation</th>
                        <th scopt="col">Medicaments prescrits</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${consultations}" var="cons">
                            <tr>
                                <th scope="row">${cons.id}</th>
                                <td>${cons.patient.name} (${cons.patient.id})</td>
                                <td>${cons.observation}</td>
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