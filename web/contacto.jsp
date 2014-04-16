<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Contacto</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/RibbonMenu.css"/>
    <link rel="stylesheet" href="css/contacto.css">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
</head>
<!--inicio detalles googleMap-->
<style>
#map_canvas {
    width: 500px;
    height: 400px;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script>
    function initialize() {
        var map_canvas = document.getElementById('map_canvas');
        var map_options = {
          center: new google.maps.LatLng(44.5403, -78.5463),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        var map = new google.maps.Map(map_canvas, map_options)
      }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>
<!--fin detalles googleMap-->
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
    <!--inicio contenido-->
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="row">
                    <img src="img/contacto.png" height="50%" width="50%" id="imgContacto">
                </div>
                <div class="row">
                    <h3>Telefono:</h3>
                    <h4>5658-111</h4>
                    <h3>Correo Electronico:</h3>
                    <h4>escuelaIngles@ingles.com</h4>
                </div>
            </div>
            <div class="col-md-6">
                <!--inicio googleMap-->
                <div id="map_canvas"></div>
                <!--fin googleMap-->
            </div>
        </div>
    </div>
    <!--fin contenido-->
</body>
</html>