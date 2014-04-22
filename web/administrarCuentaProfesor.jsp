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
                <div class="col-md-row" id="modificarDatos">
                    <form action="">
                        <fieldset class="login">
                            <legend>Detalles Login</legend>
                            <div>
                                <label>Contraseña</label> <input type="password" id="contraseniaUno">
                                <div id="respuestaContraseniaUno" class="respuesta"></div>
                            </div>
                            <div>
                                <label>Confirma Contraseña</label> <input type="password" id="contraseniaDos">
                                <div id="respuestaContraseniaDos" class="respuesta"></div>
                            </div>
                        </fieldset>
                        <fieldset class="contact">
                            <legend>Detalles Usuario</legend>
                            <div>
                                <label>Nombre</label> <input type="text" id="nombre" value=<%=(String)sesion.getAttribute("nombre")%> >
                                <div id="respuestaNombre" class="respuesta"></div>
                            </div>
                            <div>
                                <label>E-mail</label> <input type="text" id="mail" value=<%=(String)sesion.getAttribute("mail")%> >
                                <div id="respuestaMail" class="respuesta"></div>
                            </div>
                        </fieldset>
                        <button type="button" id="aceptar">Aceptar</button>
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
    </body>
</html>
