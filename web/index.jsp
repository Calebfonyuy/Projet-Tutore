
<!DOCTYPE html>
<html>
    <head>
        <title>Batch Insurance</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
        <script type="text/javascript" src="js/popper.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </head>
    <!-- body -->
    <body style="background-image: url('ressources/bgimg5.jpg'); background-repeat: no-repeat; background-size: cover;">
        <header>
            <!--Navbar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-info">

                <!-- Navbar brand //mettre le logo ici -->
                <img src="ressources/logo.png" alt="Logo" width="150px" height="100px">
            
                <!-- Collapse button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
            
                <!-- Collapsible content -->
                <div class="collapse navbar-collapse">
        
                    <form class="form-inline my-1" method="post" action="login">
                    	<label class="text-danger">${warning}</label>
                        <div class="md-form input-group my-0">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon11">@</span>
                            </div>
                            <input class="form-control mr-sm-2" type="text" id="logIdentifiant" name="logIdentifiant" value="${identifiant}" placeholder="identifiant" required="required">
                        </div>
                        <div class="md-form input-group my-0">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon11">&</span>
                            </div>
                            <input class="form-control mr-sm-2" type="password" id="logPassword" name="logPassword" placeholder="mot de passe" required="required">
                        </div>
                        <div class="md-form my-0">
                            <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                    </form>
                </div>
                <!-- Collapsible content -->
            
            </nav>
            <!--/.Navbar-->

        </header>
        <main class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <h1 class="text-uppercase text-danger">Batch Insurance</h1>
                </div>
                <div class="col-offset-lg-2 col-lg-4">
                    <!-- boostsrap form-->
                    <!-- Material form login -->
                    <div class="card bg-transparent text-danger">

                            <h5 class="card-header text-center py-4">
                            <strong>Inscription</strong>
                            </h5>

                        
                        
                            <!--Card content-->
                            <div class="card-body px-lg-5 pt-0">
                        
                                <!-- Form -->
                                <form class="form-horizontal font-weight-bold" method="post" action="inscription">
                        
                                    <!-- Nom -->
                                    <div class="md-form">
                                    <label for="nom">Nom</label><br>
                                    <input type="text" id="nom" name="nom" class="form-control" value="${personne.name}" required="required">
                                    </div>

                                    <!-- Prenom -->
                                    <div class="md-form mb-0">
                                    <label for="prenom">Prenom</label><br>
                                    <input type="text" id="prenom" name="prenom" class="form-control" value="${personne.surname}" require="required">
                                    </div>

                                    <!-- Contact -->
                                    <div class="md-form">
                                    <label for="contact">Contact</label><br>
                                    <input type="number" id="contact" name="contact" class="form-control" value="${personne.contact}" require="required">
                                    </div>
                                    
                                    <div class="md-form">
                                    <label for="adresse">Adresse</label><br>
                                    <input type="text" id="adresse" name="adresse" class="form-control" value ="${personne.address}" require="required">
                                    </div>
                           
                                    <!-- Password -->
                                    <div class="md-form">
                                    <label for="password">Mot de passe</label><br>
                                    <input type="password" id="password" name="password" class="form-control" required="required">
                                    </div>

                                    <!--categorie-->
                                    <div>
                                        <table>
                                            <tc>
                                                <td><input type="radio" name="categorie" value="assure" required="required" checked="checked"></td>
                                                <td>Assure</td>
                                            </tc>
                                            <tc>
                                                <td><input type="radio" name="categorie" value="generaliste" required="required"></td>
                                                <td>Generaliste</td>
                                            </tc>
                                            <tc>
                                                <td><input type="radio" name="categorie" value="specialiste" required="required"></td>
                                                <td>Specialiste</td>
                                            </tc>
                                        </table>
                                    </div>


                                    <!-- Sign in button -->
                                    <button class="btn btn-outline-danger btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Enregistrer</button>
                            
                        
                            
                                </form>
                                <!-- Form -->
                        
                            </div>
                        
                    </div>
                    <!-- Material form login -->


                </div>
            </div>

        </main>
    </body>
</html>