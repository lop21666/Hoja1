/**
 * Clase Principal
 * @author Carlos_Edgardo_López_Barrera
 * @author Brian_Anthony_Carrillo_Monzón
 * @version 1 29/01/2022
 *
 * La clase Controlador, sirve para definir todos los metodos y funcionalidades del programa.
 */

public class RadioController implements Radio{
	
	/**
    *
    */
	
	private boolean encendido;
	private boolean tipoSenal;
	private float AMactual = 530;
	private float FMactual = (float) 87.90;
	private float emisorasGuardadas[] = new float[12];
	private float emisoraActual;

	/**
     * Metodo encenderApagar: sirve para encender o apagar el radio dependiendo del estado actual.
     * 
     */
	@Override
	public void encenderApagar() {
		if(encendido) {
			encendido = false;
		}else {
			encendido = true;
		}	
	}

	/**
     * Metodo guardarEmisoraActual: sirve para almacenar la emisora que se esta escuchando en ese momento en el boton que el usuario desee.
     *
     * @param numBoton: (int)
     * @return mensaje: (String)
     * 
     */
	@Override
	public String guardarEmisoraActual(int numBoton) {
		
		if(numBoton <= 12) {
			emisorasGuardadas[numBoton] = emisoraActual;
			String mensaje = "La emisora: " + emisoraActual + " se ha guardado correctamente en el boton " + numBoton;
			return mensaje;
		}else {
			String mensaje = "El boton ingresado no existe, solo tiene disponibles 12 botones";
			return mensaje;
		}
	}

	/**
     * Metodo seleccionarEmisoraGuardada: sirve seleccionar una emisora que se haya guardado en alguno de los botones.
     *
     * @param numBoton: (int)
     * @return mensaje: (String)
     * 
     */
	@Override
	public String seleccionarEmisoraGuardada(int numBoton) {
		
		if(numBoton <= 12) {
			emisoraActual = emisorasGuardadas[numBoton];
			String mensaje = "La emisora: " + emisoraActual + " ha sido seleccionada correctamente";
			return mensaje;
		}else {
			String mensaje = "El boton ingresado no existe, solo tiene disponibles 12 botones";
			return mensaje;
		}
	}

	/**
     * Metodo cambiarSenal: sirve para cambiar de FM a AM o de AM a FM dependiendo de la situacion actual.
     *
     * @param opcion: (boolean)
     * @return mensaje: (String)
     * 
     */
	@Override
	public String cambiarSenal(boolean opcion) {
		
		if(tipoSenal) {
			tipoSenal = false;
			String mensaje = "El tipo de senal ha cambiado de AM a FM";
			return mensaje;
		}else {
			tipoSenal = true;
			String mensaje = "El tipo de senal ha cambiado de FM a AM";
			return mensaje;
		}
	}

	/**
     * Metodo getTipoSenal: sirve para obtener el valor de la variable tipoSenal.
     * 
     */
	@Override
	public boolean getTipoSenal() {
		return tipoSenal;
	}

	/**
     * Metodo subirEmisora: sirve para cambiar la senal hacia arriba.
     * 
     */
	@Override
	public void subirEmisora() {
		
		if(tipoSenal) {
			emisoraActual = emisoraActual + 10;
		}else{
			emisoraActual = (float) (emisoraActual + 0.2);
		}
	
	}

	/**
     * Metodo bajarEmisora: sirve para cambiar la senal hacia abajo.
     * 
     */
	@Override
	public void bajarEmisora() {
		
		if(tipoSenal) {
			emisoraActual = emisoraActual - 10;
		}else{
			emisoraActual = (float) (emisoraActual - 0.2);
		}
		
	}

	/**
     * Metodo getEmisoraActual: sirve para obtener el valor de la variable emisoraActual.
     * 
     */
	@Override
	public float getEmisoraActual() {
		return emisoraActual;
	}

	/**
     * Metodo comprobarEncendida: sirve para obtener el valor de la variable encendido.
     * 
     */
	@Override
	public boolean comprobarEncendida() {
		return encendido;
	}
	
	

}
