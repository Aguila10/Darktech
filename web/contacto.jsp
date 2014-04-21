<%
    /*Obtener la sesion ya iniciada*/
    HttpSession sesion = request.getSession(true);
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/RibbonMenu.css"/>
    <link rel="stylesheet" href="css/contacto.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />
    <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.fancybox.js?v=2.1.5"></script>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Londrina Solid">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=McLaren">
    <script src="js/cerrarSesion.js"></script>
    
    <title>Contacto</title>
    
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
    
    $(document).ready(function(){
                $(".fancyBox").fancybox({
                    
                });
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
            location.href="contacto.jsp";
        }
        
    });
}
</script>
<!--fin detalles googleMap-->
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
                <a href="elegirCurso.jsp"><span>Cursos</span></a>
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
                    <img src="img/contact.png" height="50%" width="50%" id="imgContacto">
                </div>
                <div class="row">
                    <h4>Telefono:</h4>
                    <h5>5658-111</h5>
                    <h4>Correo Electronico:</h4>
                    <h5>escuelaIngles@ingles.com</h5>
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