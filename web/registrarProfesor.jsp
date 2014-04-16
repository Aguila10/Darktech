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
        <link rel="stylesheet" href="css/alerta.css">
        <script src="js/jquery-1.10.1.min.js"></script>
        <script src="js/registrarProfesor.js"></script>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
            
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
                    <a href="elegirCurso.jsp"><span>Cursos</span></a>
                    <a href="contacto.jsp"><span>Contacto</span></a>
                </div>
            </div>
        </header>
        <!--fin encabezado-->
        <!--inicio formulario-->
        <div class="container">
            <div class="row" id="formularioProfesor">
                <form action="SubirArchivo" method="post" enctype="multipart/form-data" id="formulario">
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
                            <div id="respuestaContraseniaDos" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <fieldset class="contact">
                        <legend>Detalles Usuario</legend>
                        <div>
                            <label>Nombre</label> <input type="text" id="nombre" onclick="quitaNombre()" maxlength="70" value="pray">
                            <div id="respuestaNombre" class="respuesta"></div>
                        </div>
                        <div>
                            <label>E-mail</label> <input type="text" id="mail" onclick="quitaMail()" maxlength="70" value="soy@profesor.com">
                            <div id="respuestaMail" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Fecha incio</label>
                            <select id="dia">
                                <option value="01">1</option>
                                <option value="02">2</option>
                                <option value="03">3</option>
                                <option value="04">4</option>
                                <option value="05">5</option>
                                <option value="06">6</option>
                                <option value="07">7</option>
                                <option value="08">8</option>
                                <option value="09">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                            </select>
                            <select id="mes">
                                <option value="01">Enero</option>
                                <option value="02">Febrero</option>
                                <option value="03">Marzo</option>
                                <option value="04">Abril</option>
                                <option value="05">Mayo</option>
                                <option value="06">Junio</option>
                                <option value="07">Julio</option>
                                <option value="08">Agosto</option>
                                <option value="09">Septiembre</option>
                                <option value="10">Octubre</option>
                                <option value="11">Noviembre</option>
                                <option value="12">Diciembre</option>
                            </select>
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
                    <button type="button" id="aceptar" onclick="completeRevisa(callbackRevisa)">Aceptar</button>
                </form>
            </div>
            <!--fin formulario-->
        </div>
        <img src="img/listonProfesor.png" height="150" width="151" style='position:absolute; top:0; right:0;'/>
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