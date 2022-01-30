/**
 * Interfaz Radio
 * @author Carlos_Edgardo_López_Barrera
 * @author Brian_Anthony_Carrillo_Monzón
 * @version 1.0 29/01/2022
 *
 * En esta interfaz se definen los metodos que implementa un radio.
 */

public interface Radio {

	//Cambia el estado encendido/apagado
	public void encenderApagar();
	
	//Guarda la emisora como favorita en el boton indicado (array de 12 espacios).
	public String guardarEmisoraActual(int numBoton);
	
	//Reproduce la emisora guardada en uno de los 12 botones.
	public String seleccionarEmisoraGuardada(int numBoton);
	
	// Cambia la senial del radio - true: AM // false:FM
	public String cambiarSenal(boolean opcion);
	
	//Devuelve la senial actual en el radio - true: AM // false:FM
	public boolean getTipoSenal();
	
	// Aumenta la emisora actual en 0.2 si la señal actual es FM, o en 10 si es AM
	public void subirEmisora();
	
	// Disminuye la emisora actual en 0.2 si la señal actual es FM, o en 10 si es AM
	public void bajarEmisora();
	
	// Devuelve la emisora actual en el radio
	public float getEmisoraActual();
	
	// Devulve el estado en el que se encuentra el radio - true: encendido // false: apagado
	public boolean comprobarEncendida();
	
}
