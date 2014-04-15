function cerrarSesion(){	
    $.post("CerrarSesion", {
    },function(data){
        location.href="index.jsp";
        });
    }