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
            
            
            
        <title>Registrar Alumno</title>
    </head>
    <body>
        <!--inicio encabezado-->
        <header>
            <div class="row">
                <img src="img/logo.jpg" height="140" width="214">
            </div>
            <div class="row">
                <div class="ribbon">
                    <a href="index.jsp"><span>Inicio</span></a>
                    <a href="#"><span>Registrar</span></a>
                    <a href="#"><span>Iniciar Sesión</span></a>
                    <a href="administrarCuentaAlumno.jsp"><span>Cuenta</span></a>
                    <a href="#"><span>Cursos</span></a>
                    <a href="#"><span>Contacto</span></a>
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
                            <label>Login</label> <input id ="login" type="text" onclick="quitaLogin()" onblur="revisaDisponibilidad()" maxlength="15">
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
                            <label>Nombre</label> <input id="nombre" type="text" onclick="quitaNombre()" maxlength="70">
                            <div id="respuestaNombre" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Telefono</label> <input id="telefono" type="text" onclick="quitaTelefono()" maxlength="15">
                            <div id="respuestaTelefono" class="respuesta"></div>
                        </div>
                        <div>
                            <label>E-mail</label> <input id="mail" type="text" onclick="quitaMail()" maxlength="70">
                            <div id="respuestaMail" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <%--<a href="#popup" class="fancyBox">--%>
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
                <a href="vistaProfesor.jsp"><button id="AceptarPop">Aceptar</button></a>
            </div>
        </div>
        <!--fin ventana popUp para indicar que el registro fue exitoso-->
            
    </body>
</html>