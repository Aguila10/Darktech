function quitaLogin(){
    document.getElementById("respuestaLogin").innerHTML = "";
    document.getElementById("login").classList.remove("incorrecto");
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

function quitaTelefono(){
    document.getElementById("respuestaTelefono").innerHTML = "";
    document.getElementById("telefono").classList.remove("incorrecto");
}

function quitaMail(){
    document.getElementById("respuestaMail").innerHTML = "";
    document.getElementById("mail").classList.remove("incorrecto");
}

function revisaLogin(){
    
    var login = document.getElementById("login").value;
    var login_pat = /^[A-Za-z0-9_ñ]+$/;
    
    if(login.match(login_pat)){
        if(login.length >= 4 && login.length <= 15){ //  tamaño [4,15]
            return true;
        }else{
            document.getElementById("respuestaLogin").innerHTML = "El login debe tener un mínimo de 4 caracteres y un máximo de 15";
            document.getElementById("login").classList.add("incorrecto");
            return false;
        }
    }else{
        if(login === ""){
            document.getElementById("respuestaLogin").innerHTML = "El campo no puede quedar vacio";
            document.getElementById("login").classList.add("incorrecto");
        }else{
            document.getElementById("respuestaLogin").innerHTML = "El login solo puede contener numeros,letras y guiones bajos";
            document.getElementById("login").classList.add("incorrecto");    
        }
        return false;
    }
}

function revisaContrasenia(){
    var contraseniaUno = document.getElementById("contraseniaUno").value;
    var contraseniaDos = document.getElementById("contraseniaDos").value;
    var contrasenia_pat = /^[^';]+$/;
    
    if(contraseniaUno.match(contrasenia_pat)){
        if(contraseniaUno.length < 5 || contraseniaUno.length > 15){
            document.getElementById("respuestaContraseniaUno").innerHTML ="La contraseña debe tener un mínimo de 5 caracteres y un máximo de 15";
            document.getElementById("contraseniaUno").classList.add("incorrecto");
            return false;
        }    
    }else{
        if(contraseniaUno === ""){
            document.getElementById("respuestaContraseniaUno").innerHTML ="El campo no puede quedar vacio";
            document.getElementById("contraseniaUno").classList.add("incorrecto");
        }else{
            document.getElementById("respuestaContraseniaUno").innerHTML = "La contraseña no puede contener comillas simples (') ni comas (;)";
            document.getElementById("contraseniaUno").classList.add("incorrecto");
        }  
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
    var nombre_pat = /^([A-Za-zñáéíóú])+([\s]{1}[A-Za-zñáéíóú]+)?([\s]{1}[A-Za-zñáéíóú]+)?$/;
    
    if(nombre.match(nombre_pat)){
        if(nombre.length >= 2 && nombre.length <= 70){ //Tamaño [2,70]
            return true;
        }else{
            document.getElementById("respuestaNombre").innerHTML = "El nombre debe tener un mínimo de 2 caracteres y un máximo de 70";
            document.getElementById("nombre").classList.add("incorrecto");
            return false;
        }
    }else{        
        if(nombre === ""){
            document.getElementById("respuestaNombre").innerHTML = "Este campo no pude quedar vacio";
            document.getElementById("nombre").classList.add("incorrecto");      
        }else{
            document.getElementById("respuestaNombre").innerHTML = "El nombre solo puede contener letras y debe tener la estructura: [Nombre] [ApellidoP (opcional)] [ApellidoM (opcional)].";
            document.getElementById("nombre").classList.add("incorrecto");      
        }
        return false;
    }
    
}


function revisaMail(){
    
    var mail = document.getElementById("mail").value;
    var mail_pat = /^[A-Za-z0-9_](\.?[\w-]+)*@[a-zA-Z]+(\.[a-zA-z]+){1,2}$/;
    
    if(mail.match(mail_pat)){
        if(mail.length <= 70){  // Si cumple la estructura y su tamaño es menor a 70 
            return true;
        }else{
            document.getElementById("respuestaMail").innerHTML = "El mail debe tener un tamaño máximo de 70 caracteres";
            document.getElementById("mail").classList.add("incorrecto");
            return false;
        }     
    }else{        
        if(mail === ""){
            document.getElementById("respuestaMail").innerHTML = "Este campo no puede quedar vacio";
            document.getElementById("mail").classList.add("incorrecto");  
        }else{
            document.getElementById("respuestaMail").innerHTML = "El mail debe tener la siguiente estructura: </br> \n\
                                                                  [nombre]@[dominio].[subdominio (opcional)].com";
            document.getElementById("mail").classList.add("incorrecto");    
        }
        return false;
    }
    
}

function revisaTelefono(){
    
    var telefono = document.getElementById("telefono").value;
    var telefono_pat = /^[0-9]+$/;
    
    if(telefono.match(telefono_pat)){
        if(telefono.length >= 8 && telefono.length <= 15){  // Tamaño [8,15]
            return true;
        }else{
            document.getElementById("respuestaTelefono").innerHTML = "El telefono debe tener un mínimo de 8 numeros y un máximo de 15";
            document.getElementById("telefono").classList.add("incorrecto");
            return false;
        }
    }else{
        if(telefono === ""){
            document.getElementById("respuestaTelefono").innerHTML = "Este campo no puede quedar vacio";
            document.getElementById("telefono").classList.add("incorrecto");
        }else{
            document.getElementById("respuestaTelefono").innerHTML = "El telefono solo puede contener numeros";
            document.getElementById("telefono").classList.add("incorrecto");
            
        }   
        return false;
    }
}

function revisaDisponibilidad(){
    
    $.post("DisponibilidadLogin",{
        login: document.getElementById("login").value   
    },function(data){
        var respuesta = data.valueOf().toString();  
        if(respuesta.match("ocupado")){    
            document.getElementById("respuestaLogin").innerHTML = "Login no disponible";
            document.getElementById("login").classList.add("incorrecto");    
        }         
    });
    
}

function completeMarca(callback){
    $.post("DisponibilidadLogin",{
        login: document.getElementById("login").value   
    },function(data){
        var respuesta = data.valueOf().toString();  
        if(respuesta.match("ocupado")){    
            callback(false);
        }else{
            callback(true);
        }         
    });
    
}

function callbackMarca(valor){
    
    if(revisaLogin() === true && valor === false ){
        document.getElementById("respuestaLogin").innerHTML = "Login no disponible";
        document.getElementById("login").classList.add("incorrecto");       
    }   
    revisaContrasenia();
    revisaNombre();
    revisaTelefono();
    revisaMail();
    
}

function completeRevisa(callback){
    
    $.post("DisponibilidadLogin",{
        login: document.getElementById("login").value   
    },function(data){
        var respuesta = data.valueOf().toString();  
        if(respuesta.match("ocupado")){    
            callback(false);
        }else{
            callback(true);
        }         
    });
    
}

function callbackRevisa(valor){
    
    var continua = true;
    
    continua = revisaLogin() && continua; 
    if(continua === true && valor === false){
        document.getElementById("respuestaLogin").innerHTML = "Login no disponible";
        document.getElementById("login").classList.add("incorrecto");    
    }
    continua = valor && continua;
    continua = revisaContrasenia() && continua;
    continua = revisaNombre() && continua;
    continua = revisaTelefono() && continua;
    continua = revisaMail() && continua; 

    if(continua){    
        
        $.post("RegistrarAlumno",{
            login: document.getElementById("login").value,
            contraseniaUno: document.getElementById("contraseniaUno").value,
            contraseniaDos: document.getElementById("contraseniaDos").value,
            nombre: document.getElementById("nombre").value,
            telefono: document.getElementById("telefono").value,
            mail: document.getElementById("mail").value
        }, function(data){
            
            //---Desactivar revision de JS para probar complete_marca(callback_marca);
            //---Poner nombres deacuerdo al estandar;
            //---Checar lo de los commit;
            
            var respuesta = data.valueOf().toString();
            if(respuesta.match("error")){ // Si el servidor detecta un error marca
                completeMarca(callbackMarca);
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
})
// prevents the overlay from closing if user clicks inside the popup overlay
$('.overlay-content').click(function(){
    return false;
});
