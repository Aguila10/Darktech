<%-- 
    Document   : index
    Created on : 9/04/2014, 07:55:01 PM
    Author     : rae
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width"> 
        <link rel="stylesheet" href="css/paginaPrincipal.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <title>Escuela de Inglés</title>
            
        <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({
                    
                });
            });
            
        </script>
            
    </head>
    <body>
        <header>
            <div class="container">
                <div class="row">
                    <img src="img/logo.jpg" height="140" width="214" id="logo">
                </div>
            </div>
        </header>
        <!--inicio contenido de la pagina-->
        <div class="container">
            <div class="row">
                <ul class="ca-menu">
                    <li>
                        <a href="#popupDos" class="fancyBox">
                            <span><img src="img/iniciarSesion.png" height="200" width="200"></span>
                            <div class="ca-content">
                                <h2 class="ca-main">Iniciar Sesión</h2>
                                <h3 class="ca-sub">
                                    Iniciar Sesión
                                </h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#popup" class="fancyBox">
                            <span>
                                <img src="img/registrar.png" height="200" width="200">
                            </span>
                            <div class="ca-content">
                                <h2 class="ca-main">
                                    Registrar
                                </h2>
                                <h3 class="ca-sub">
                                    Registrar
                                </h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <span>
                                <img src="img/cursos.png" height="200" width="200">
                            </span>
                            <div class="ca-content">
                                <h2 class="ca-main">
                                    Cursos
                                </h2>
                                <h3 class="ca-sub">
                                    Cursos
                                </h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <span>
                                <img src="img/contacto.jpg" height="200" width="200">
                            </span>
                            <div class="ca-content">
                                <h2 class="ca-main">
                                    Contacto
                                </h2>
                                <h3 class="ca-sub">
                                    Contacto
                                </h3>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <!--fin contenido de la pagina-->
            
        <!--inicio registrar-->
        <div id="popup">
            <img src="img/profesor.png" height="128" width="128">
            <img src="img/alumno.png" height="128" width="128">
            <br>
            <a href="registrarProfesor.jsp" id="prof">Profesor</a>
            <a href="registrarAlumno.jsp" id="al">Alumno</a>
        </div>
        <!--fin registrar-->
            
        <!--inicio iniciar sesion-->
        <div id="popupDos">
            <input type="text" placeholder ="login">
            <br>
            <input type="text" placeholder = "contraseña" id ="contrasenia">
            <br>
            <button type="button" id="aceptar">Aceptar</button>
        </div>
        <!--fin iniciar sesion-->
    </body>
</html>