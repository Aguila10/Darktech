<%-- 
    Document   : registrarProfesor
    Created on : 9/04/2014, 07:58:20 PM
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
        <link rel="stylesheet" href="css/FormularioProfesor.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <script src="js/registrarProfesor.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({		
                });
            });
        </script>
        <title>Registrar Profesor</title>
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
                    <a href="#"><span>Cuenta</span></a>
                    <a href="#"><span>Cursos</span></a>
                    <a href="#"><span>Contacto</span></a>
                </div>
            </div>
        </header>
        <!--fin encabezado-->
        <!--inicio formulario-->
        <div class="container">
            <div class="row" id="formularioProfesor">
                <form action="">
                    <fieldset class="login">
                        <legend>Detalles Login</legend>
                        <div>
                            <label>Login</label> <input type="text" id="login" onclick="quitaLogin()" onblur="revisaDisponibilidad()" maxlength="15" >
                            <div id="respuestaLogin" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Contraseña</label> <input type="password" id="contraseniaUno" onclick="quitaContrasenia()" maxlength="15" value="holamundo">
                            <div id="respuestaContraseniaUno" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Confirma Contraseña</label> <input type="password" id="contraseniaDos" onclick="confirmaContrasenia()" maxlength="15" value="holamundo">
                            <div id="respuestaContraseniaDos"class="respuesta"></div>
                        </div>
                    </fieldset>
                    <fieldset class="contact">
                        <legend>Detalles Usuario</legend>
                        <div>
                            <label>Nombre</label> <input type="text" id="nombre" onclick="quitaNombre()" maxlength="70" value="pray">
                            <div id="respuestaNombre" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Telefono</label> <input type="text" id="telefono" onclick="quitaTelefono()" maxlength="15" value="123456789">
                            <div id="respuestaTelefono" class="respuesta"></div>
                        </div>
                        <div>
                            <label>E-mail</label> <input type="text" id="mail" onclick="quitaMail()" maxlength="70" value="soy@profesor.com">
                            <div id="respuestaMail" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Nivel</label>
                            <select id="nivel">
                                <option>Principiante</option>
                                <option>Intermedio</option>
                                <option>Avanzado</option>
                                <option>Conversación</option>
                            </select>
                        </div>
                        <div>
                            <label>Horario</label>
                            <select id="horario">
                                <option>10:00hrs-11:00hrs</option>
                                <option>11:00hrs-12:00hrs</option>
                            </select>
                        </div>
                        <div>
                            <label>Constancia:</label>
                        </div>
                        <div>
                            <input type="file" class="archivo" id="constancia" onclick="quitaConstancia()">
                            <div id="respuestaArchivo" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Video:</label>
                        </div>
                        <div>
                            <input type="file" class="archivo" id="video" onclick="quitaVideo()">
                            <div id="respuestaVideo" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <%--<a href="#popup" class="fancyBox">--%>
                    <button type="button" id="aceptar" onclick="completeRevisa(callbackRevisa)">Aceptar</button>
                </form>
            </div>
            <!--fin formulario-->
        </div>
        <img src="img/listonProfesor.png" height="150" width="151" style='position:absolute; top:0; right:0;'/>
        <!--inicio ventana popUp para indicar que el registro fue exitoso-->
        <div id="popup">
            <div class="row" id="contenidoPop">
                <div class="col-md-6" id="contenedorImagenPop">
                    <img src="" height="100%" width="100%" id="imagenPop">
                </div>
                <div class="col-md-6" id="contenidoRespuesta">
                    <div id="respuesta"></div>
                </div>
                <br>
                <a href="" id="aceptarPop" onClick="parent.jQuery.fancybox.close();"><button>Aceptar</button></a>
            </div>
        </div>
        <!--fin ventana popUp para indicar que el registro fue exitoso-->
    </body>
</html>