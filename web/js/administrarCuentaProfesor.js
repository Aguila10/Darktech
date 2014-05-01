function limpiaPanel(){
    document.getElementById("modificarDatos").style.display ="none";
    document.getElementById("agregarCurso").style.display ="none";
    document.getElementById("aceptarCurso").style.display ="none";
    document.getElementById("calificaCurso").style.display ="none";
}

function muestraFormulario(){
    limpiaPanel();
    document.getElementById("modificarDatos").style.display ="block";
    document.getElementById("contenidoPagina").style.height ="600px";
}

function quitaContraseniaCero(){
    document.getElementById("respuestaContraseniaCero").innerHTML = "";
    document.getElementById("contraseniaCero").classList.remove("incorrecto");
}

function quitaContrasenia(){
    document.getElementById("respuestaContraseniaUno").innerHTML = "";
    document.getElementById("contraseniaUno").classList.remove("incorrecto");
}

function confirmaContrasenia(){
    document.getElementById("respuestaContraseniaDos").innerHTML = "";
    document.getElementById("contraseniaDos").classList.remove("incorrecto");
}

function quitaNombre(){
    document.getElementById("respuestaNombre").innerHTML = "";
    document.getElementById("nombre").classList.remove("incorrecto");
}

function quitaMail(){
    document.getElementById("respuestaMail").innerHTML = "";
    document.getElementById("mail").classList.remove("incorrecto");
}

function revisaContrasenia(){
    
    var contraseniaUno = document.getElementById("contraseniaUno").value;
    var contraseniaDos = document.getElementById("contraseniaDos").value;
    
    if(contraseniaUno === ""){
        document.getElementById("respuestaContraseniaUno").innerHTML ="El campo no puede quedar vacio";
        document.getElementById("contraseniaUno").classList.add("incorrecto");
        return false;   
    }   
    if(contraseniaUno.length < 5 || contraseniaUno.length > 15){
        document.getElementById("respuestaContraseniaUno").innerHTML ="Contraseña de tamaño inválido";
        document.getElementById("contraseniaUno").classList.add("incorrecto");
        return false;
    } 
    if(contraseniaUno !== contraseniaDos){
        document.getElementById("respuestaContraseniaDos").innerHTML ="Las contraseñas no coinciden";
        document.getElementById("contraseniaDos").classList.add("incorrecto");
        return false;
    }
    return true;
    
}

function revisaNombre(){
    
    var nombre = document.getElementById("nombre").value;
    var nombre_pat = /^([A-Za-z])+([\s]{1}[A-Za-z]+)?([\s]{1}[A-Za-z]+)?$/;
    
    if(nombre.match(nombre_pat)){
        if(nombre.length >= 2 && nombre.length <= 70){ //Tamaño [2,70]
            return true;
        }else{
            document.getElementById("respuestaNombre").innerHTML = "Nombre de tamaño inválido";
            document.getElementById("nombre").classList.add("incorrecto");
            return false;
        }
    }else{        
        if(nombre === ""){
            document.getElementById("respuestaNombre").innerHTML = "Este campo no pude quedar vacio";
            document.getElementById("nombre").classList.add("incorrecto");      
        }else{
            document.getElementById("respuestaNombre").innerHTML = "Nombre con estructura inválida";
            document.getElementById("nombre").classList.add("incorrecto");      
        }
        return false;
    }
    
}

function revisaMail(){
    
    var mail = document.getElementById("mail").value;
    var mail_pat = /^[A-Za-z](\.?[\w-]+)*@[a-zA-Z]+(\.[a-zA-z]+){1,2}$/;
    
    if(mail.match(mail_pat)){
        if(mail.length <= 70){  // Si cumple la estructura y su tamaño es menor a 70 
            return true;
        }else{
            document.getElementById("respuestaMail").innerHTML = "Mail de tamaño inválido";
            document.getElementById("mail").classList.add("incorrecto");
            return false;
        }     
    }else{        
        if(mail === ""){
            document.getElementById("respuestaMail").innerHTML = "Este campo no puede quedar vacio";
            document.getElementById("mail").classList.add("incorrecto");  
        }else{
            document.getElementById("respuestaMail").innerHTML = "Mail de estructura inválida";
            document.getElementById("mail").classList.add("incorrecto");    
        }
        return false;
    }
    
}


function revisaContraseña(callback){
    
    $.post("VerificaContrasenia",{
        contrasenia: document.getElementById("contraseniaCero").value
    }, function(data){
        var respuesta = data.valueOf().toString();
        if(respuesta.match("error")){ 
            document.getElementById("respuestaContraseniaCero").innerHTML = "La contraseña es incorrecta";
            document.getElementById("contraseniaCero").classList.add("incorrecto"); 
        }else{    
            callback();
        }    
    });
    
    
    
}

function callbackContraseña(){
    
    var continua = revisaContrasenia();
    
    if(continua){      
        $.post("AdministrarCuentaProfesor",{
            identificador: "contrasenia",
            contraseniaCero : document.getElementById("contraseniaCero").value,
            contraseniaUno : document.getElementById("contraseniaUno").value,
            contraseniaDos : document.getElementById("contraseniaDos").value
        }, function(data){
            
            var respuesta = data.valueOf().toString();
            
            if(respuesta.match("error")){ 
                revisarContrasenia();
            }else{    
                var docHeight = $(document).height(); //grab the height of the page
                var scrollTop = $(window).scrollTop(); //grab the px value from the top of the page to where you're scrolling      
                $('.overlay-bg').show().css({'height' : docHeight}); //display your popup and set height to the page height
                $('.overlay-content').css({'top': scrollTop+20+'px'}); //set the content 20px from the window top      
                
            }    
        });
        
    }
    
}
function marcaDatos(){   
    revisaNombre();
    revisaMail();
}

function revisaDatos(){
    
    var continua = true;
    
    continua = revisaNombre() && continua;
    continua = revisaMail() && continua; 
    
    if(continua){      
        $.post("AdministrarCuentaProfesor",{
            identificador: "datos",
            nombre: document.getElementById("nombre").value,
            mail: document.getElementById("mail").value
        }, function(data){
            var respuesta = data.valueOf().toString();
            if(respuesta.match("error")){ 
                marcaDatos();
            }else{    
                var docHeight = $(document).height(); //grab the height of the page
                var scrollTop = $(window).scrollTop(); //grab the px value from the top of the page to where you're scrolling      
                $('.overlay-bg').show().css({'height' : docHeight}); //display your popup and set height to the page height
                $('.overlay-content').css({'top': scrollTop+20+'px'}); //set the content 20px from the window top      
                
            }    
        });
        
        
    }
}


// hide popup when user clicks on close button
$('.close-btn').click(function(){
    $('.overlay-bg').hide(); // hide the overlay
});

// hides the popup if user clicks anywhere outside the container
$('.overlay-bg').click(function(){
    $('.overlay-bg').hide();
});
// prevents the overlay from closing if user clicks inside the popup overlay
$('.overlay-content').click(function(){
    return false;
});

/*Para agregarCursos*/
function agregarCursos(){
    limpiaPanel();
    document.getElementById("agregarCurso").style.display ="block";
}

function nuevoCurso(){
    alert("Curso");
}

/*Para aceptar solicitudes de cursos*/
function aceptarCursos(){
    limpiaPanel();
    document.getElementById("aceptarCurso").style.display ="block";
    
    $.post('MuestraAceptarCursos',{
	
        }, function(data){         
        $("#aceptarCurso").html(data);    
      });
}

function aceptoCurso(idCurso){
    $.post('AceptarCursos',{
	id: idCurso,
        acepto: true
        }, function(data){         
        
      });
}

function rechazoCurso(idCurso){
    $.post('AceptarCursos',{
	id: idCurso,
        acepto: false
        }, function(data){         
        
      });
}


/*Para calificar cursos*/
function calificaCursos(){
    limpiaPanel();
    document.getElementById("calificaCurso").style.display ="block";
    
    $.post('MuestraCalificaCursos',{
	
        }, function(data){         
        $("#calificaCurso").html(data);    
      });
}

function calificacion(idCurso){
    $.post('CalificaCursos',{
          id: idCurso
        }, function(data){         
      });
}