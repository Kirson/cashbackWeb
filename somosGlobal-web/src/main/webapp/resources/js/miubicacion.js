function iniciar() {
	var boton = document.getElementById('obtener');
	boton.addEventListener('click', obtener, false);
}

function obtener() {
	navigator.geolocation.getCurrentPosition(mostrar, gestionarErrores);
}

function mostrar(posicion) {
	// var ubicacion = document.getElementById('localizacion');
	// var datos = '';
	// datos += 'Latitud: ' + posicion.coords.latitude + '<br>';
	// datos += 'Longitud: ' + posicion.coords.longitude + '<br>';
	// datos += 'Exactitud: ' + posicion.coords.accuracy + ' metros.<br>';
	var longitud = posicion.coords.longitude;
	var latitud = posicion.coords.latitude;
	console.log(longitud + " " + latitud);
	document.getElementById("frmId:latitud").value = latitud;
	document.getElementById("frmId:longitud").value = longitud;
	// ubicacion.innerHTML = datos;
}

function gestionarErrores(error) {
	alert('Error: '
			+ error.code
			+ ' '
			+ error.message
			+ '\n\nPor favor compruebe que est� conectado '
			+ 'a internet y habilite la opci�n permitir compartir ubicaci�n f�sica');
}

window.addEventListener('load', iniciar, false);
