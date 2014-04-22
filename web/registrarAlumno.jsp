<%-- 
    Document   : registrarAlumno
    Created on : 9/04/2014, 07:58:37 PM
    Author     : rae
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">    
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/RibbonMenu.css"/>
        <link rel="stylesheet" href="css/FormularioAlumno.css"/>
        <link rel="stylesheet" href="css/alerta.css">
        <script src="js/jquery-1.10.1.min.js"></script>
        <script src="js/registrarAlumno.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">    
        <script src="js/iniciarSesion.js"></script>
        <title>Registrar Alumno</title>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({});
            }); 
            
            function limpia(){ 
                document.getElementById("login").value = "";
                document.getElementById("contrasenia").value = "";
                document.getElementById("contestaSesion").innerHTML = "";
            }   
        </script>
    </head>
    <body>
        <!--inicio encabezado-->
        <header>
            <div class="row">
                <img src="img/escuela.png" height="140" width="214">
            </div>
            <div class="row">
                <div class="ribbon">
                    <a href="index.jsp"><span>Inicio</span></a>
                    <a href="#popupTres" class="fancyBox"><span>Registrar</span></a>
                    <a href="#popupDos" class="fancyBox" onclick="limpia()"><span>Iniciar Sesión</span></a>
                    <a href="elegirCurso.jsp"><span>Cursos</span></a>
                    <a href="contacto.jsp"><span>Contacto</span></a>
                </div>
            </div>
        </header>
        <!--fin encabezado-->
        <!--inicio formulario-->
        <div class="container">
            <div class="row" id="formularioAlumno">
                <form action="">
                    <fieldset class="login">
                        <legend>Detalles Login</legend>
                        <div>
                            <label>Login</label> <input id ="login" type="text" onclick="quitaLogin()" onblur="revisaDisponibilidad()" maxlength="15" placeholder="Ej. login_12">
                            <div id="respuestaLogin" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Contraseña</label> <input id ="contraseniaUno" type="password" onclick="quitaContrasenia()" maxlength="15">
                            <div id="respuestaContraseniaUno" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Confirma Contraseña</label> <input id="contraseniaDos" type="password" onclick="confirmaContrasenia()" maxlength="15">
                            <div id="respuestaContraseniaDos" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <fieldset class="contact">
                        <legend>Detalles Usuario</legend>
                        <div>
                            <label>Nombre</label> <input id="nombre" type="text" onclick="quitaNombre()" maxlength="70"  placeholder="Ej. Carlos Escalona Navarro">
                            <div id="respuestaNombre" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Telefono</label> <input id="telefono" type="text" onclick="quitaTelefono()" maxlength="15"  placeholder="Ej. 5512345678 ">
                            <div id="respuestaTelefono" class="respuesta"></div>
                        </div>
                        <div>
                            <label>E-mail</label> <input id="mail" type="text" onclick="quitaMail()" maxlength="70"  placeholder="Ej. soy@alumno.com">
                            <div id="respuestaMail" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <button type="button" id="aceptar" onclick="completeRevisa(callbackRevisa)">Aceptar</button>
                </form>
            </div>
            <!--fin formulario-->
        </div>
        <img src="img/listonAlumno.PNG" style='position:absolute; top:0; right:0;'/>
        <!--inicio ventana popUp para indicar que el registro fue exitoso-->
        <div id="popup" class="overlay-bg">
            <div class="row overlay-content">
                <div class="col-md-6" id="contenedorImagenPop">
                    <img src="img/ok.png" height="100%" width="100%">
                </div>
                <div class="col-md-6" id="contenedorParrafo">
                    <p>¡Registro Exitoso!</p>
                </div>
                <br>
                <a href="vistaAlumno.jsp"><button id="AceptarPop">Aceptar</button></a>
            </div>
        </div>
        <!--fin ventana popUp para indicar que el registro fue exitoso-->
        <!--inicio registrar-->
        <div id="popupTres">
            <a href="registrarProfesor.jsp"><img src="img/profesor.png" height="128" width="128" class="seleccionImagen"></a>
            <a href="registrarAlumno.jsp"><img src="img/alumno.png" height="128" width="128" class="seleccionImagen"></a>
            <br>
            <a id="prof">Profesor</a>
            <a id="al">Alumno</a>
        </div>
        <!--fin registrar-->
        <!--inicio iniciar sesion-->
        <div id="popupDos">
            <input type="text" placeholder =" Login" id="login" value="">
            <br>
            <p id="espacio"></p>
            <input type="password" placeholder = " Contraseña" id ="contrasenia" value="">
            <br>
            <p id="espacio2"></p>
            <button id="aceptar" onclick="iniciarSesion('elegirCurso.jsp')">Aceptar</button>
            <p id="espacio3"></p>
            <div id="contestaSesion"></div>
        </div>
        <!--fin iniciar sesion-->    
    </body>
</html>