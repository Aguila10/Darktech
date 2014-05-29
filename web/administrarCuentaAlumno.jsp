<%-- 
    Ddocument   : administrarCuentaAlumno
    Created on : 9/04/2014, 07:56:40 PM
    Author     : rae
--%>
<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
        
    if(sesion.getAttribute("identidad") == null || sesion.getAttribute("identidad").equals("profesor")){
        response.sendRedirect("index.jsp");
            
    } 

    %>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">    
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/RibbonMenu.css"/>
        <link rel="stylesheet" href="css/FormularioAlumno.css">
        <link rel="stylesheet" href="css/administrarCuentaAlumno.css">
        <link rel="stylesheet" href="css/alerta.css">
        <script src="js/administrarCuentaAlumno.js"></script>
        <script src="js/cerrarSesion.js"></script>
        <script src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
        
        <title>Administrar Cuenta: Alumno</title> 
        
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
        <!--incio sesion-->
        <div class="container">
            <div class="row">
                <h2>Alumno: <%=sesion.getAttribute("login")%></h2>
            </div>
        </div>
        <!--div sesion-->
        <!--inicio encabezado-->
        <header>
            <div class="row">
                <img src="img/escuela.png" height="140" width="214">
            </div>
            <div class="row">
                <div class="ribbon">
                    <a href="vistaAlumno.jsp"><span>Inicio</span></a>                    
                    <a href="#" onclick="cerrarSesion()"><span>Cerrar Sesión</span></a>
                    <a href="#"><span>Cuenta</span></a>
                    <a href="elegirCurso.jsp"><span>Cursos</span></a>
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
                    <li onclick="inscripcion()">
                        <a>
                            <span class="ca-icon">S</span>
                            <div class="ca-content">
                                <h4>Inscripción</h4>
                            </div>
                        </a>
                    </li>
                    <li onclick="historial()">
                        <a>
                            <span class="ca-icon">S</span>
                            <div class="ca-content">
                                <h4>Historial</h4>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#popupEliminar" class="fancyBox">
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
                <div class="row" id="historial"></div>
                <div class="row" id="inscripcion"></div>
                <div class="row" id="modificarDatos">
                    <form action="">
                        <fieldset class="login">
                            <legend>Modificar Detalles Login</legend>
                            <div>
                                <label>Anterior Contraseña</label> <input type="password" id="contraseniaCero" onclick="quitaContraseniaCero()">
                                <div id="respuestaContraseniaCero" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Contraseña</label> <input type="password" id="contraseniaUno" onclick="quitaContrasenia();">
                                <div id="respuestaContraseniaUno" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Confirma Contraseña</label> <input type="password" id="contraseniaDos" onclick="confirmaContrasenia()">
                                <div id="respuestaContraseniaDos" class="respuesta"></div>
                            </div>
                            <button type="button" id="aceptarLogin" onclick="revisaContraseña(callbackContraseña)">Aceptar</button>
                        </fieldset>
                        <fieldset class="contact">
                            <legend>Modificar Detalles Usuario</legend>
                            <div>
                                <label>Nombre</label> <input type="text" id="nombre" onclick="quitaNombre()" value="<%=(String)sesion.getAttribute("nombre")%>">
                                <div id="respuestaNombre" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Telefono</label> <input type="text" id="telefono" onclick="quitaTelefono()" value="<%=(String)sesion.getAttribute("telefono")%>" >
                                <div id="respuestaTelefono" class="respuesta"></div>
                            </div>
                            <div>
                                <label>E-mail</label> <input type="text" id="mail" onclick="quitaMail()" value="<%=(String)sesion.getAttribute("mail")%>">
                                <div id="respuestaMail" class="respuesta"></div>
                            </div>
                            <button type="button" id="aceptarUsuario" onclick="revisaDatos()">Aceptar</button>
                        </fieldset>
                        
                    </form>	
                </div>
            </div>
        </div>     
        <!--inicio ventana popup eliminar-->
        <div id="popupEliminar">
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
                <a href="administrarCuentaAlumno.jsp"><button id="AceptarPop">Aceptar</button></a>
            </div>
        </div>
        <!--fin ventana popUp para indicar que el registro fue exitoso-->
    </body>
</html>