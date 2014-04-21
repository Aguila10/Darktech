<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
%>
<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/RibbonMenu.css"/>
        <link rel="stylesheet" href="css/cursos.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
        <script src="js/solicitarCurso.js"></script>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">    
        <script src="js/cerrarSesion.js"></script>
        
        <title>Cursos</title>
</head>

    <script type="text/javascript">
            $(document).ready(function(){
                $(".fancyBox").fancybox({});
            });
            
            function iniciarSesion(){
                $.post("IniciarSesion", {
                    login : document.getElementById("login").value,
                    contrasenia : document.getElementById("contrasenia").value
                },function(data){
                    var respuesta = data.valueOf().toString();
                    document.getElementById("login").value = "";
                    document.getElementById("contrasenia").value = "";
                        if(respuesta.match("error")){
                            $("#contestaSesion").html("Login o contraseña incorrecta");
                        }else{ 
                            location.href="elegirCurso.jsp";
                        }});
                }
    </script>
    
<body>
        <!--inicio sesion-->
	<div class="container">
		<div class="row">
                    <%if(request.getSession(true).getAttribute("identidad") != null){
                        if(request.getSession(true).getAttribute("identidad").equals("alumno")){%>
                            <h2>Alumno: <%=sesion.getAttribute("login")%></h2>
                    <% }else{%>
                            <h2>Profesor: <%=sesion.getAttribute("login")%></h2>
                            <%}
                    }%>       
		</div>
	</div>
	<!--fin sesion-->
	<!--inicio encabezado-->
	<header>
		<div class="row">
			<img src="img/logo.jpg" height="140" width="214">
		</div>
		<div class="row">
			<div class="ribbon">
				<a href="index.jsp"><span>Inicio</span></a>
                                <!--inicio menu dinamico iniciar/cerrar sesion-->
                                <%if(request.getSession(true).getAttribute("identidad") != null){%>
                                    <a href="#" onclick="cerrarSesion('elegirCurso.jsp')"><span>Cerrar Sesión</span></a>
                                  <%}else{%>
                                  <a href="#popupDos" class="fancyBox" onclick="limpia()"><span>Iniciar Sesión</span></a>
                                  <a href="#popup" class="fancyBox"><span>Registrar</span></a>
                                  <%}%>
                                <!--fin menu dinamico iniciar/cerrar sesion-->
                                <!--inicio menu dinamico cuenta alumno/profesor-->
                                <%if(request.getSession(true).getAttribute("identidad") != null){
                                        if(request.getSession(true).getAttribute("identidad").equals("alumno")){%>
                                            <a href="administrarCuentaAlumno.jsp"><span>Cuenta</span></a>
                                        <%}else{%>
                                            <a href="administrarCuentaProfesor.jsp"><span>Cuenta</span></a>
                                                <%}
                                        }%>  
                                <!--fin menu dinamico cuenta alumno/profesor-->
				<a href="#"><span>Cursos</span></a>
				<a href="contacto.jsp"><span>Contacto</span></a>
			</div>
		</div>
	</header>
	<!--fin encabezado-->
	<div class="row">
		<!--inicio submenu-->
		<div class="col-md-3" id="submenu">
			<ul class="ca-menu">
				<li>
					<a onclick="regresaCursos('Principiante')">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Principiante</h4>
						</div>
					</a>
				</li>
				<li>
					<a onclick="regresaCursos('Intermedio')">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Intermedio</h4>
						</div>
					</a>
				</li>
				<li>
					<a onclick="regresaCursos('Avanzado')">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Avanzado</h4>
						</div>
					</a>
				</li>
				<li>
					<a onclick="regresaCursos('Conversación')">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Conversación</h4>
						</div>
					</a>
				</li>
			</ul>
		</div>
		<!--fin submenu-->
                <!--inicio muestra cursos-->
		<div class="col-md-9" id="contenidoPagina">
		</div>
                <!--fin muestra cursos-->
	</div>
        
        <!--inicio registrar-->
        <div id="popup">
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