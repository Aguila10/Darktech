<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
%>
<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Cursos</title>
	<meta name="viewport" content="width=device-width">
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/RibbonMenu.css"/>
    <link rel="stylesheet" href="css/cursos.css">
            <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
        <script src="js/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
    <script src="js/solicitarCurso.js"></script>
</head>
<body>
<!--inicio sesion-->
	<div class="container">
		<div class="row">
                    <% 
    if(request.getSession(true).getAttribute("identidad") != null){
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
				<a href="#"><span>Registrar</span></a>
				<a href="#"><span>Iniciar Sesión</span></a>
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
		<div class="col-md-9" id="contenidoPagina">
			a ver
		</div>
	</div>
</body>
</html>