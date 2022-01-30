import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioCotrollerTest {

	RadioController radio = new RadioController();
	
	@Test
	void testGuardarEmisoraActual() {
		float valorEsperado = 88.1f;
		radio.subirEmisora();
		radio.guardarEmisoraActual(1);
		float valorRecibido = radio.getEmisoraActual();
		assertEquals(valorEsperado, valorRecibido, 0);
	}

	@Test
	void testSeleccionarEmisoraGuardada() {
		float emisora = 88.1f;
		radio.subirEmisora();
		String mensajeEsperado = "La emisora: " + emisora + " ha sido seleccionada correctamente";
		radio.guardarEmisoraActual(1);
		String mensajeRecibido = radio.seleccionarEmisoraGuardada(1);
		assertEquals(mensajeEsperado, mensajeRecibido, "");
	}

	
	@Test
	void testCambiarSenal() {
		String mensajeEsperado = "El tipo de senal ha cambiado de FM a AM";
		String mensajeRecibido = radio.cambiarSenal(true);
		assertEquals(mensajeEsperado, mensajeRecibido, "");
	}
	

}
