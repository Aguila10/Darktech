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
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
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
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Principiante</h4>
						</div>
					</a>
				</li>
				<li>
					<a href="#popup" class="fancyBox">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Intermedio</h4>
						</div>
					</a>
				</li>
				<li>
					<a href="#popup" class="fancyBox">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Nivel Avanzado</h4>
						</div>
					</a>
				</li>
				<li>
					<a href="#popup" class="fancyBox">
						<span class="ca-icon">j</span>
						<div class="ca-content">
							<h4>Conversación</h4>
						</div>
					</a>
				</li>
			</ul>
		</div>
		<!--fin submenu-->
                <!--inicio contenido cursos-->
		<div class="col-md-9" id="contenidoPagina">
		</div>
                <!--fin contenido cursos-->
	</div>
</body>
</html>