function iniciarSesion(){
    
    
    $.post("IniciarSesion", {
        login : document.getElementById("login").value,
        contrasenia : document.getElementById("contrasenia").value
    },function(data){
        var respuesta = data.valueOf().toString();
        document.getElementById("login").value = "";
        document.getElementById("contrasenia").value = "";
        if(respuesta.match("error")){
            $("#contestaSesion").html("El login o la contraseña son incorrectas");
        }else{ 
            location.href="index.jsp";
        }
        
    });
}

function limpia(){ 
    document.getElementById("login").value = "";
    document.getElementById("contrasenia").value = "";
    document.getElementById("contestaSesion").innerHTML = "";

}   
