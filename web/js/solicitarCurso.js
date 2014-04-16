function regresaCursos(nivel) {

$.post('MuestraCursos',{
	nivel:nivel
        }, function(data){         
            $("#contenidoPagina").html(data);
      });
}





