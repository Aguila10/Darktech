<%-- 
    Document   : administrarCuentaProfesor
    Created on : 9/04/2014, 07:56:55 PM
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
        <link rel="stylesheet" href="css/FormularioProfesor.css">
        <link rel="stylesheet" href="css/administrarCuentaProfesor.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <title>Administrar Cuenta</title>
        <script type="text/javascript" src="js/administrarCuentaProfesor.js"></script>
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({
			
                });
            });

        </script>
        
    </head>
    <body>
        <!--inicio encabezado-->
        <header>
            <div class="row">
                <img src="img/logo.jpg" height="140" width="214">
            </div>
            <div class="row">
                <div class="ribbon">
                    <a href="vistaProfesor.jsp"><span>Inicio</span></a>
                    <a href="#"><span>Registrar</span></a>
                    <a href="#"><span>Cerrar Sesión</span></a>
                    <a href="#"><span>Cuenta</span></a>
                    <a href="#"><span>Cursos</span></a>
                    <a href="#"><span>Contacto</span></a>
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
                        <a href="#popupELimina" class="fancyBox">
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
                                <label>Login</label> <input type="text">
                            </div>
                            <div>
                                <label>Contraseña</label> <input type="password">
                            </div>
                            <div>
                                <label>Confirma Contraseña</label> <input type="password">
                            </div>
                        </fieldset>
                        <fieldset class="contact">
                            <legend>Detalles Usuario</legend>
                            <div>
                                <label>Nombre</label> <input type="text">
                            </div>
                            <div>
                                <label>Telefono</label> <input type="text">
                            </div>
                            <div>
                                <label>E-mail</label> <input type="text">
                            </div>
                            <div>
                                <label>Nivel</label>
                                <select>
                                    <option>Principiante</option>
                                    <option>Intermedio</option>
                                    <option>Avanzado</option>
                                    <option>Conversación</option>
                                </select>
                            </div>
                            <div>
                                <label>Horario</label>
                                <select>
                                    <option>10:00hrs-11:00hrs</option>
                                    <option>11:00hrs-12:00hrs</option>
                                </select>
                            </div>
                            <div>
                                <label>Constancia:</label>
                            </div>
                            <div>
                                <input type="file" class="archivo">
                            </div>
                            <div>
                                <label>Video:</label>
                            </div>
                            <div>
                                <input type="file" class="archivo">
                            </div>
                        </fieldset>
                        <button type="button" id="aceptar">Aceptar</button>
                    </form>
                </div>
            </div>
        </div>
        
        <!--inicio ventana popup eliminar-->
        <div id="popupElimina">
            <img src="img/eliminar.png" height="150" width="150">
            <h1>¿Desea eliminar su cuenta?</h1>
            <button type="button" class="aceptar">Aceptar</button>
        </div>
        <!--fin ventana popup eliminar-->
    </body>
</html>
