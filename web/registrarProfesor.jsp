<%-- 
    Document   : registrarProfesor
    Created on : 9/04/2014, 07:58:20 PM
    Author     : rae
--%>
    
<% 
    
    HttpSession sesion = request.getSession(true);
    
    if(sesion.getAttribute("resultado") == null){
        sesion.setAttribute("login", "");
        sesion.setAttribute("contraseniaUno", "");
        sesion.setAttribute("contraseniaDos", "");
        sesion.setAttribute("nombre", "");
        sesion.setAttribute("mail", "");
        sesion.setAttribute("dia", "");
        sesion.setAttribute("mes", "");
        sesion.setAttribute("nivel", "");
        sesion.setAttribute("horario", "");
    }else{%>
   <%}%>
  
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
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
        <script src="js/iniciarSesion.js"></script>
            
        <title>Registrar Profesor</title>
             
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
            <div class="row" id="formularioProfesor">
                <form action="RegistrarProfesor" method="post" enctype="multipart/form-data" id="formulario" name="formulario">
                    <fieldset class="login">
                        <legend>Detalles Login</legend>
                        <div>
                            <label>Login</label> <input type="text" id="login" name="login" onclick="quitaLogin()" onblur="revisaDisponibilidad()" 
                                                        maxlength="15"  placeholder="Ej. login_12" value=${login} >
                            <div id="respuestaLogin" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Contraseña</label> <input type="password" id="contraseniaUno" name="contraseniaUno" onclick="quitaContrasenia()"
                                                             maxlength="15" value=<%=sesion.getAttribute("contraseniaUno") %> >
                            <div id="respuestaContraseniaUno" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Confirma Contraseña</label> <input type="password" id="contraseniaDos" name="contraseniaDos" onclick="confirmaContrasenia()"
                                                                      maxlength="15" value=<%=sesion.getAttribute("contraseniaDos") %> >
                            <div id="respuestaContraseniaDos" class="respuesta"></div>
                        </div>
                    </fieldset>
                    <fieldset class="contact">
                        <legend>Detalles Usuario</legend>
                        <div>
                            <label>Nombre</label> <input type="text" id="nombre" name="nombre" onclick="quitaNombre()" maxlength="70"  
                                                         placeholder="Ej. Carlos Escalona Navarro" value=<%=(String)sesion.getAttribute("nombre") %>>
                            <div id="respuestaNombre" class="respuesta"></div>
                        </div>
                        <div>
                            <label>E-mail</label> <input type="text" id="mail" name="mail" onclick="quitaMail()" maxlength="70" 
                                                         placeholder="Ej. soy@profesor.com" value=<%=sesion.getAttribute("mail") %>>
                            <div id="respuestaMail" class="respuesta"></div>
                        </div>
                        <div>
                            <label>Fecha incio</label>
                            <select id="dia" name="dia">
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
                            <select id="mes" name="mes">
                                <option value="01">Enero</option>
                                <option value="02">Febrero</option>
                                <option value="03">Marzo</option>
                                <option value="04">Abri l</option>
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
                            <select id="nivel" name="nivel">
                                <option>Principiante</option>
                                <option>Intermedio</option>
                                <option>Avanzado</option>
                                <option>Conversación</option>
                            </select>
                        </div>
                        <div>
                            <label>Horario</label>
                            <select id="horario" name="horario" >
                                <option>10:00hrs-11:00hrs</option>
                                <option>11:00hrs-12:00hrs</option>
                            </select>
                        </div>
                        <div>
                            <label>Constancia:</label>
                        </div>
                        <div>
                            <input type="file" class="archivo" id="constancia" name ="constancia" onclick="quitaConstancia()">                            
                           
                            <%if(sesion.getAttribute("pdf") != null){%>
                             <div id="respuestaConstancia" class="respuesta"><%=sesion.getAttribute("pdf")%></div>  
                            <%}else{%>
                             <div id="respuestaConstancia" class="respuesta" ></div>
                            <%}%>
                        </div>
                        <div>
                            <label>Video:</label>
                        </div>
                        <div>
                            <input type="file" class="archivo" id="video" name="video" onclick="quitaVideo()">
                            <%if(sesion.getAttribute("video") != null){%>
                            <div id="respuestaVideo" class="respuesta"><%=sesion.getAttribute("video")%></div> 
                            <%}else{%>
                            <div id="respuestaVideo" class="respuesta"></div>
                            <%}%>
                        </div>
                    </fieldset>
                    <button type="button" id="aceptar" onclick="completeRevisa(callbackRevisa)">Aceptar</button>
                </form>
     
            </div>
         <%if(sesion.getAttribute("resultado") != null && sesion.getAttribute("resultado").equals("error")){%>   
           <script>completeMarca(callbackMarca);</script>   
           <%}%>
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
        <!--inicio registrar-->
        <div id="popupTres">
            <a href="registrarProfesor.jsp"><img src="img/profesor.png" height="128" width="128" class="seleccionImagen"></a>
            <a href="registrarAlumno.jsp"><img src="img/alumno.png" height="128" width="128" class="seleccionImagen"></a>
            <br>
            <a id="prof">Profesor</a>
            <a id="al">Alumno</a>
        </div>
        <!--fin registrar-->
        <!--inicio iniciar request-->
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
        <!--fin iniciar request-->  
            
    <%
      if(sesion.getAttribute("resultado") != null){
          if(sesion.getAttribute("resultado").equals("exito")){
            sesion.removeAttribute("contraseniaUno");
            sesion.removeAttribute("contraseniaDos");
            sesion.removeAttribute("dia");
            sesion.removeAttribute("mes");
            sesion.removeAttribute("nivel");
            sesion.removeAttribute("horario");
            sesion.removeAttribute("resultado");%>
            <script>muestraPopup();</script>
<%}else{
           sesion.removeAttribute("login");
           sesion.removeAttribute("contraseniaUno");
           sesion.removeAttribute("contraseniaDos");
           sesion.removeAttribute("nombre");
           sesion.removeAttribute("mail");
           sesion.removeAttribute("dia");
           sesion.removeAttribute("mes");
           sesion.removeAttribute("nivel");
           sesion.removeAttribute("horario");
           sesion.removeAttribute("resultado");
           sesion.removeAttribute("video");
           sesion.removeAttribute("pdf");

          }
      }
%>
    </body>

</html>