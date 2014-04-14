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

function revisa(){
    var continua = true;
    
    /*Revisar que el login no sea vacio*/
    if(document.getElementById("login").value ==""){
        document.getElementById("respuestaLogin").innerHTML = "Login inválido";
        document.getElementById("login").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que la contrasenia no sea vacia*/
    if(document.getElementById("contraseniaUno").value == ""){
        document.getElementById("respuestaContraseniaUno").innerHTML = "Contraseña inválida";
        document.getElementById("contraseniaUno").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que ambas contrasenias coincidan*/
    if(document.getElementById("contraseniaUno").value != document.getElementById("contraseniaDos").value){
        document.getElementById("respuestaContraseniaDos").innerHTML ="Confirmación contraseña incorrecta";
        document.getElementById("contraseniaDos").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que el nombre solo conste del alfabeto*/
    var patronNombre = /^[a-z | A-Z]+[a-z | ' ' | A-Z]*[a-z A-Z]$/;
    if(!document.getElementById("nombre").value.match(patronNombre)){
        document.getElementById("respuestaNombre").innerHTML = "Nombre inválido";
        document.getElementById("nombre").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que el telefono solo conste de numero*/
    var patronTelefono = /^[0-9]+[0-9]*[0-9]+$/;
    if(!document.getElementById("telefono").value.match(patronTelefono)){
        document.getElementById("respuestaTelefono").innerHTML = "Telefono inválido";
        document.getElementById("telefono").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar mail*/
    var patronMail = /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
    if(!document.getElementById("mail").value.match(patronMail)){
        document.getElementById("respuestaMail").innerHTML = "Mail inválido";
        document.getElementById("mail").classList.add("incorrecto");
        continua = false;
    }
    
    
      alert("holas");
    
    /*Si pasa las validaciones, se envian los datos*/
	/*Si pasa las validaciones, se envian los datos*/
	if(!continua){
		jQuery.post("RegistrarAlumno",{
			login: document.getElementById("login").value,
			//contrasenia: document.getElementById("contrasenia").value,
                        //contraseniaDos : document.getElementById("contraseniaDos").value,
			//nombre: document.getElementById("nombre").value,
			//telefono: document.getElementById("telefono").value
		}, function(data){
                        
                        //Mensaje a regresar.
                        
		}
			);
	}
    
        alert("paso");
    
    
}

