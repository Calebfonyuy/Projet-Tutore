<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <a  class="navbar-brand" style="float: left;">
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
                    <h3 class="text-secondary text-uppercase">${medecin.name} ${medecin.surname}
                    </h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a href="ConsultationServlet" class="list-group-item list-group-item-action bg-light">Consultation</a>
                        </li>
                        <li><a class="list-group-item list-group-item-action active">Modifier
                                profile</a></li>
                        <li><a href="DoctorHome" class="list-group-item list-group-item-action bg-light">Historique
                                des consultations</a></li>
                    </ul>
                </fieldset>
            </div>

            <!--Main content area-->
            <div class="col-lg-9 col-md-9 text-wrap display">
            
                <h3>Modifier votre profile: ${patient.id}</h3>
                <fieldset>
                    <form>
                        <table class="table text-white">
                            <tr>
                                <td>Nom</td>
                                <td><input type="text" name="name" id="name" class="form-control"
                                        value="${medecin.name}" required="required"></td>
                            </tr>
                            <tr>
                                <td>Prenom</td>
                                <td><input type="text" name="surname" id="surname"
                                        value="${medecin.surname}" class="form-control"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td>Adresse</td>
                                <td><input type="text" name="address" id="address"
                                        class="form-control" value="${medecin.address}"
                                        required="required"></td>
                            </tr>
                            <tr>
                                <td>Contact</td>
                                <td><input type="tel" name="telephone" id="telephone"
                                        class="form-control" value="${medecin.contact}"
                                        required="required"></td>
                            </tr>
                           <tr>
                                <td>Mot de passe</td>
                                <td><input type="password" name="pass" class="form-control"
                                id="pass" value="${patient.password}" required="required"></td>
                       		</tr>
                       		<tr>
                                <td>Confirmer mot de passe</td>
                                <td><input type="password" name="passwd" class="form-control"
                                id="passwd" value="${patient.password}" required="required"></td>
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