<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <li class="page-item page-link">Sign out</li>
                </ol>
            </div>
        </header>
        
        <div class="container-fluid content">
            <!--Left navigation area-->
            <div class="col-lg-3 col-md-3 bg-info">
                <div>
                    <h3 class="text-secondary text-uppercase">${patient.name}  ${patient.surname}</h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a href="" class="list-group-item list-group-item-action bg-light">Choisir Medecin</a>
                        </li>
                        <li><a href="" class="list-group-item list-group-item-action bg-light">Modifier
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
                        <th scope="col">Date</th>
                        <th scope="col">Medecin</th>
                        <th scope="col">Observation</th>
                        <th scope="col">Medicaments prescrits</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${consultations}" var="cons">
                            <tr>
                                <th scope="row">${cons.id}</th>
                                <td>${cons.date}</td>
                                <td>${cons.doctor.name} ${cons.doctor.surname}</td>
                                <td>${cons.observation}</td>
                                <td>
                                    <ul>
                                        <c:forEach items="${cons.maladie}" var="mal">
                                            <li>${mal.name}</li>
                                        </c:forEach>
                                    </ul>
                                </td>
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