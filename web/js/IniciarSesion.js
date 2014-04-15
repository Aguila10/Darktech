function logea(){	
	$.post('SesionInicio', {
		login : document.getElementById("login").value,
		contrasenia : document.getElementById("contrasenia").value
	},function(responseText){
		$("#contestaSesion").html(responseText);
	});
}