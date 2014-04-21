function regresaCursos(nivel) {
$.post('MuestraCursos',{
	nivel:nivel
        }, function(data){         
            $("#contenidoPagina").html(data);
      });
}

/*Botones solo habiltiados para alumnos*/
    function botonesAlumno(){
        alert("hola");
        var list=document.getElementsByTagName("BUTTON");
        for(i=0; i<list.length; i++){
            list[i].setAttribute('disabled','disabled');
        }
    }

