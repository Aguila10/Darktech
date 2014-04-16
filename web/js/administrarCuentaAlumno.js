function muestraFormulario(){
	var x = document.getElementById("modificarDatos").style.display ="block";
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

function revisaTelefono(){
    
    var telefono = document.getElementById("telefono").value;
    var telefono_pat = /^[0-9]+$/;
    
    if(telefono.match(telefono_pat)){
        if(telefono.length >= 8 && telefono.length <= 15){  // Tamaño [8,15]
            return true;
        }else{
            document.getElementById("respuestaTelefono").innerHTML = "Telefono de tamaño inválido";
            document.getElementById("telefono").classList.add("incorrecto");
            return false;
        }
    }else{
        if(telefono === ""){
            document.getElementById("respuestaTelefono").innerHTML = "Este campo no puede quedar vacio";
            document.getElementById("telefono").classList.add("incorrecto");
        }else{
            document.getElementById("respuestaTelefono").innerHTML = "Telefono de estructura inválida";
            document.getElementById("telefono").classList.add("incorrecto");
            
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


function marca(){
    
    revisaContrasenia();
    revisaNombre();
    revisaTelefono();
    revisaMail();
    
}


function revisa(){
    
    var continua = true;
    
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
                marca();
            }else{
                
                alert("El registro fue un exito");
                location.href="vistaAlumno.jsp";        

            }    
        });
        
        
    }
}


