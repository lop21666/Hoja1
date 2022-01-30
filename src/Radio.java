
public interface Radio {

	//Cambia el estado encendido/apagado
	public void encenderApagar();
	
	//Guarda la emisora como favorita en el botón indicado (array de 12 espacios).
	public String guardarEmisoraActual(int numBoton);
	
	//Reproduce la emisora guardada en uno de los 12 botones.
	public String seleccionarEmisoraGuardada(int numBoton);
	
	//true: AM // false:FM
	public String cambiarSenal(boolean opcion);
	
	//true: AM // false:FM
	public boolean getTipoSenal();
	
	// Aumenta la emisora actual en 0.2 si la señal actual es FM, o en 10 si es AM
	public void subirEmisora();
	
	// Disminuye la emisora actual en 0.2 si la señal actual es FM, o en 10 si es AM
	public void bajarEmisora();
	
	public float getEmisoraActual();
	
	public boolean comprobarEncendida();
	
}
