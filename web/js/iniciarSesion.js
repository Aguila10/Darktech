function iniciarSesion(){

    var login = document.getElementById("login").value;
    var contrasenia = document.getElementById("contrasenia").value;
    
    var login_pat = /^[A-Za-z0-9_ñ]+$/;
    var contrasenia_pat = /^[^';]+$/;
    
    if(login.match(login_pat) && contrasenia.match(contrasenia_pat)){
        
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
                location.href="index.jsp";
            }  
        });  
        
    }else{
        $("#contestaSesion").html("Login o contraseña incorrecta");
    }
}

function limpia(){ 
    document.getElementById("login").value = "";
    document.getElementById("contrasenia").value = "";
    document.getElementById("contestaSesion").innerHTML = "";

}   
