<%-- 
    Document   : administrarCuentaProfesor
    Created on : 9/04/2014, 07:56:55 PM
    Author     : rae
--%>
<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">    
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/RibbonMenu.css"/>
        <link rel="stylesheet" href="css/FormularioProfesor.css">
        <link rel="stylesheet" href="css/administrarCuentaProfesor.css">
        <link rel="stylesheet" href="css/alerta.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script type="text/javascript" src="js/administrarCuentaProfesor.js"></script>
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
        <script src="js/cerrarSesion.js"></script>
        <title>Administrar Cuenta: Profesor</title>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({
			
                });
            });

        </script>
        
        <script>
            function eliminaCuenta(){    
                $.post('EliminaCuenta',{
                }, function(data){         
                    location.href="index.jsp";
                });
            }
        </script>
        
    </head>
    <body>
        <!--inicio sesion-->
        <div class="container">
            <div class="row">
                <h2>Profesor: <%=sesion.getAttribute("login")%></h2>
            </div>
        </div>
        <!--fin sesion-->
        <!--inicio encabezado-->
        <header>
            <div class="row">
                <img src="img/escuela.png" height="140" width="214">
            </div>
            <div class="row">
                <div class="ribbon">
                    <a href="vistaProfesor.jsp"><span>Inicio</span></a>
                    <a href="#" onclick="cerrarSesion()"><span>Cerrar Sesión</span></a>
                    <a href="#"><span>Cuenta</span></a>
                    <a href="elegirCurso.jsp"><span>Cursos</span></a>
                    <a href="#"><span>Metodología</span></a>
                    <a href="contacto.jsp"><span>Contacto</span></a>
                </div>
            </div>
        </header>
        <!--fin encabezado-->
        <div class="row">
            <!--inicio submenu-->
            <div class="col-md-3" id="submenu">
                <ul class="ca-menu">
                    <li onclick="muestraFormulario();">
                        <a>
                            <span class="ca-icon">S</span>
                            <div class="ca-content">
                                <h4>Modificar Datos</h4>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a onclick="agregarCursos()">
                            <span class="ca-icon">+</span>
                            <div class="ca-content">
                                <h4>Agregar Curso</h4>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a onclick="aceptarCursos()">
                            <span class="ca-icon">.</span>
                            <div class="ca-content">
                                <h4>Aceptar Curso</h4>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a onclick="calificaCursos()">
                            <span class="ca-icon">Q</span>
                            <div class="ca-content">
                                <h4>Calificar</h4>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#popup" class="fancyBox">
                            <span class="ca-icon">-</span>
                            <div class="ca-content">
                                <h4>Eliminar Cuenta</h4>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <!--fin submenu-->
            <div class="col-md-9" id="contenidoPagina">
                <div class="row" id="agregarCurso">
                    <form>
                    <fieldset class="contact">
                        <legend>Nuevo Curso:</legend>
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
                    </fieldset>
                    <button onclick="nuevoCurso()">Aceptar</button>
                    </form>
                </div>
                <div class="row" id="aceptarCurso"></div>
                <div class="row" id="calificaCurso"></div>
                <div class="row" id="modificarDatos">
                    <form action="">
                        <fieldset class="login">
                            <legend>Detalles Login</legend>
                            <div>
                                <label>Anterior Contraseña</label> <input type="password" id="contraseniaCero" onclick="quitaContraseniaCero()">
                                <div id="respuestaContraseniaCero" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Contraseña</label> <input type="password" id="contraseniaUno" onclick="quitaContrasenia()">
                                <div id="respuestaContraseniaUno" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Confirma Contraseña</label> <input type="password" id="contraseniaDos" onclick="confirmaContrasenia()">
                                <div id="respuestaContraseniaDos" class="respuesta"></div>
                            </div>
                            <button type="button" id="aceptarLogin" onclick="revisaContraseña(callbackContraseña)">Aceptar</button>
                        </fieldset>
                        <fieldset class="contact">
                            <legend>Detalles Usuario</legend>
                            <div>
                                <label>Nombre</label> <input type="text" id="nombre" onclick="quitaNombre()" value=<%=(String)sesion.getAttribute("nombre")%> >
                                <div id="respuestaNombre" class="respuesta"></div>
                            </div>
                            <div>
                                <label>E-mail</label> <input type="text" id="mail" onclick="quitaMail()" value=<%=(String)sesion.getAttribute("mail")%> >
                                <div id="respuestaMail" class="respuesta"></div>
                            </div>
                            <button type="button" id="aceptarUsuario" onclick="revisaDatos()">Aceptar</button>
                        </fieldset>                      
                    </form>
                </div>
            </div>
        </div>       
        <!--inicio ventana popup eliminar-->
        <div id="popup">
            <img src="img/eliminar.png" height="150" width="150">
            <h1>¿Desea eliminar su cuenta?</h1>
            <button type="button" class="aceptar" onclick="eliminaCuenta()">Aceptar</button>
        </div>
        <!--fin ventana popup eliminar-->
        <!--inicio ventana popUp para indicar que el registro fue exitoso-->
        <div id="popup" class="overlay-bg">
            <div class="row overlay-content">
                <div class="col-md-6" id="contenedorImagenPop">
                    <img src="img/ok.png" height="100%" width="100%">
                </div>
                <div class="col-md-6" id="contenedorParrafo">
                    <p>¡Actualización Exitosa!</p>
                </div>
                <br>
                <a href="administrarCuentaProfesor.jsp"><button id="AceptarPop">Aceptar</button></a>
            </div>
        </div>
        <!--fin ventana popUp para indicar que el registro fue exitoso-->
    </body>
</html>
