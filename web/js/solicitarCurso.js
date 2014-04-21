function regresaCursos(nivel) {
$.post('MuestraCursos',{
	nivel:nivel
        }, function(data){         
            $("#contenidoPagina").html(data);
      });
}

function solicita(curso, alumno){
    $.post('SolicitarCurso',{
	curso:curso, 
        alumno: alumno
        }, function(data){         
            
      });
}
