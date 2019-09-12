<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
                    <h3 class="text-secondary text-uppercase">${medecin.name} ${medecin.surname}
                    </h3>
                </div>
                <fieldset>
                    <ul class="none-list">
                        <li><a class="list-group-item list-group-item-action active">Consultation</a>
                        </li>
                        <li><a href="ModifierProfilMedecin" class="list-group-item list-group-item-action bg-light">Modifier
                                profile</a></li>
                        <li><a href="DoctorHome" class="list-group-item list-group-item-action bg-light">Historique
                                des consultations</a></li>
                    </ul>
                </fieldset>
                
            </div>
				
				             <!--Main content area-->
    <div class="col-lg-8 col-md-8 text-wrap display">
                <!--Main page content here-->
        <form method="post" action="ConsultationServlet"> 
            <p class="info">${alert}</p>
            <table>
              <tr>
                <td> <label for="identifier">IdAssuré : 
                    <span class="requis">*</span>
                 </label>
                 </td>
                 <td> 
                     <input type="text" id ="identifier" name="identifier" value="" class="form-control" placeholder="identifiant de l'assuré" required values="${cons.idAssure}">
                 </td>
              </tr> 
           </table>
            <table>
                <thead><h5>Informations biométriques</h5></thead>
                    <tr>
                       <td> <label for="height">Taille(en mètres) : </label></td>
                       <td> <input type="text" step="0.0001" name="taille" id="height" class="form-control" placeholder="Taille" values="${taille}"></td>
                    </tr>

                    <tr>      
                        <td> <label for="weight">Poids(en Kg) :</label></td>
                        <td><input type="number" step="0.0001" name="poids" id="weight" class="form-control" placeholder="poids" values="${poids}"></td>
                    </tr>
                    <tr>
                        <td><label for="temperature">Temperature :<br/> (en degrés celsius) </label></td>
                        <td> <input type="text" step="0.0001" name="temperature" id="temperature" class="form-control" placeholder="temperature" values="${temperature}"></td>
                    </tr>
            </table>
            <div class="form-group shadow-textarea">
              <label for="consultation"><h5>Détails de la consultation</h5></label>
              <textarea class="form-control" name="consultation" id="consultation" values="${observation}" required="required"></textarea>
            </div>			
            <div class="form-group">
                 <label for="medocs"><h5>Prescription</h5></label>
                 <select name="medicaments" id="medicaments" multiple="multiple" class="form-control">
                    <c:forEach var="name" items="${medicaments}">
                       <option value="${name.id}">${name.name}</option>
                    </c:forEach>
                 </select>
            </div>
            <input type="reset" value="Remettre à  zéro" class="bton bton-primary">
            <input type = "submit" value="Enregistrer" class="bton bton-primary">
        </form>
    </div>
</body>
</html>