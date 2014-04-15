<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
%>
<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width"> 
	<link rel="stylesheet" href="css/paginaPrincipal.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
	<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
	<title>Escuela de Inglés: Alumno</title>

	<script type="text/javascript">
        /*Para ventana popUp*/
	$(document).ready(function(){
        	$(".fancyBox").fancybox({
                	});
            });
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
	<!--inicio logo-->
	<header>
		<div class="container">
			<div class="row">
				<img src="img/logo.jpg" height="140" width="214" id="logo">
			</div>
		</div>
	</header>
	<!--fin logo-->
	<!--inicio contenido de la pagina-->
	<div class="container">
		<div class="row">
			<ul class="ca-menu">
				<li>
					<a href="#popup" class="fancyBox">
						<span><img src="img/iniciarSesion.png" height="200" width="200"></span>
						<div class="ca-content">
							<h2 class="ca-main">Cerrar Sesi�n</h2>
							<h3 class="ca-sub">
								Cerrar Sesi�n
							</h3>
						</div>
					</a>
				</li>
				<li>
					<a href="administrarCuentaProfesor.jsp">
						<span>
							<img src="img/cuenta.png" height="256" width="256">
						</span>
						<div class="ca-content">
							<h2 class="ca-main">
								Cuenta
							</h2>
							<h3 class="ca-sub">
								Cuenta
							</h3>
						</div>
					</a>
				</li>
				<li>
					<a href="">
						<span>
							<img src="img/cursos.png" height="200" width="200">
						</span>
						<div class="ca-content">
							<h2 class="ca-main">
								Cursos
							</h2>
							<h3 class="ca-sub">
								Cursos
							</h3>
						</div>
					</a>
				</li>
				<li>
					<a href="">
						<span>
							<img src="img/contacto.jpg" height="200" width="200">
						</span>
						<div class="ca-content">
							<h2 class="ca-main">
								Contacto
							</h2>
							<h3 class="ca-sub">
								Contacto
							</h3>
						</div>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<!--fin contenido de la pagina-->
	<!--inicio cerrar sesion-->
	<div id="popup">
            <input type="text" placeholder ="login" id="login" name="login">
		<br>
		<p id="errorLogin"></p>
		<input type="password" placeholder = "contraseña" id ="contrasenia">
		<br>
		<p id="errorContrasenia"></p>
		<button type="button" id="iniciar" onclick="logea()">Aceptar</button>
		<div id="contestaSesion"></div>
	</div>
	<!--fin cerrar sesion-->
</body>
</html>