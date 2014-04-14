function quitaLogin(){
    document.getElementById("respuestaLogin").innerHTML = "";
    document.getElementById("login").classList.remove("incorrecto");
}

function quitaContrasenia(){
    document.getElementById("respuestaContraseniaUno").innerHTML = "";
    document.getElementById("contrasenia").classList.remove("incorrecto");
}

function confirmaContrasenia(){
    document.getElementById("respuestaContrasenia").innerHTML = "";
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

function quitaConstancia(){
    document.getElementById("respuestaArchivo").innerHTML = "";
}

function quitaVideo(){
    document.getElementById("respuestaVideo").innerHTML = "";
}

function revisa_login(){
    
    var login = document.getElementById("login").value;
    var login_pat = "[A-Za-z1-9]+";
    
    if(login.match(login_pat)){
        if(login.length > 0 && login.length <= 15){
            return true;
        }else{
            document.getElementById("respuestaLogin").innerHTML = "Login de tamaño inválido";
            document.getElementById("login").classList.add("incorrecto");
            return false;
        }
    }else{
        document.getElementById("respuestaLogin").innerHTML = "Login con estructura inválida";
        document.getElementById("login").classList.add("incorrecto");
        return false;
    }
    
}

function revisa_nombre(){
    
    var nombre = document.getElementById("nombre").value;
    var nombre_pat = "([A-Za-z])([\s]{1}[A-Za-z]+)?([\s]{1}[A-Za-z]+)?";
    
    if(nombre.match(nombre_pat)){
        if(nombre.length > 0 && nombre.length <= 70){
            return true;
        }else{
            document.getElementById("respuestaNombre").innerHTML = "Nombre de tamaño inválido";
            document.getElementById("nombre").classList.add("incorrecto");
            return false;
        }
    }else{
        document.getElementById("respuestaNombre").innerHTML = "Nombre con estructura inválida";
        document.getElementById("nombre").classList.add("incorrecto");  
    }
    
}





function revisa(){
    var continua= true;
    /*Revisar que el login no sea vacio*/
    if(document.getElementById("login").value ==""){
        document.getElementById("respuestaLogin").innerHTML = "Login inválido";
        document.getElementById("login").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que la contrasenia no sea vacia*/
    if(document.getElementById("contrasenia").value == ""){
        document.getElementById("respuestaContraseniaUno").innerHTML = "Contraseña inválida";
        document.getElementById("contrasenia").classList.add("incorrecto");
        continua = false;
    }
    
    /*Revisar que ambas contrasenias coincidan*/
    if(document.getElementById("contrasenia").value != document.getElementById("contraseniaDos").value){
        document.getElementById("respuestaContrasenia").innerHTML ="Confirmación contraseña incorrecta";
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
    
    /*Revisar que la constancia no sea vacia*/
    if(document.getElementById("constancia").value == ""){
        document.getElementById("respuestaArchivo").innerHTML = "Agregar constancia";
        continua = false;
    }
    
    /*Revisar que el video no sea vacio*/
    if(document.getElementById("video").value == ""){
        document.getElementById("respuestaVideo").innerHTML = "Agregar video";
        continua = false;
    }
    
    
    /*Si pasa las validaciones, se envian los datos*/
    if(continua){
        jQuery.post("RegistrarProfesor",{
            login: document.getElementById("login").value,
            contrasenia: document.getElementById("contrasenia").value,
            contraseniaDos : document.getElementById("contraseniaDos").value,
            nombre: document.getElementById("nombre").value,
            telefono: document.getElementById("telefono").value
        }, function(data){
            
            //Mensaje a regresar.
            
        }
                );
    }
}