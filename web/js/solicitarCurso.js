function regresaCursos(nivel) {
$.post('MuestraCursos',{
	nivel:nivel
        }, function(data){         
            $("#contenidoPagina").html(data);
      });
}

function solicita(curso, alumno){
    noDisponible(curso);
    $.post('SolicitarCurso',{
	curso:curso, 
        alumno: alumno
        }, function(data){         
            
      });
}

function noDisponible(id){
    document.getElementById(id).style.display = "none";
}

/*Para video*/
function showVideo(id){
  $.post('MuestraVideo',{
  idCurso: id
        }, function(data){         
        document.getElementById("videoProfe").src =data;
        document.getElementById("videoProfe").play();
      });
}