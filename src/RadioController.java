/**
 * Clase Principal
 * @author Carlos_Edgardo_López_Barrera
 * @author Brian_Anthony_Carrillo_Monzón
 * @version 1.0 29/01/2022
 *
 * La clase Controlador, sirve para definir todos los metodos y funcionalidades del programa.
 */

public class RadioController implements Radio{
	
	/**
    *
    */
	
	//Variables de instacia de la clase
	private boolean encendido;
	private boolean tipoSenal=false;
	private float AMactual;
	private float FMactual;
	private float emisorasGuardadas[] = new float[12];
	private float emisoraActual=87.9f;
	
	/**
     * Constructor sin parametros
     */
    public RadioController(){
    }
	
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
		
		if(numBoton <= 12 && numBoton >0) {
			emisorasGuardadas[numBoton-1] = emisoraActual;
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
		String mensaje;
		
		if(numBoton <= 12 && numBoton >0) {
			if(emisorasGuardadas[numBoton-1] >0) {
				emisoraActual = emisorasGuardadas[numBoton-1];
				mensaje = "La emisora: " + emisoraActual + " ha sido seleccionada correctamente";
				
				if(emisoraActual>=530 && emisoraActual<=1610) {
					this.tipoSenal = true;
				}else if(emisoraActual>=87.9 && emisoraActual<=107.9) {
					this.tipoSenal = false;
				}
				
			}else {
				mensaje = "El boton seleccionado no contiene una emisora guardada.";
			}
			return mensaje;
		}else {
			mensaje = "El boton ingresado no existe, solo tiene disponibles 12 botones";
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
		
		if(opcion) {
			tipoSenal = true;
			this.emisoraActual = 530f;
			String mensaje = "El tipo de senal ha cambiado de FM a AM";
			return mensaje;
		}else {
			tipoSenal = false;
			this.emisoraActual = 87.9f;
			String mensaje = "El tipo de senal ha cambiado de AM a FM";
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
			//Definicion del limite de la frecuencia superior
			if(emisoraActual + 10f <= 1610f) {				
				emisoraActual = (float) emisoraActual + 10f;
			}else {
				emisoraActual = (float) 530;
			}
			
		}else{
			//Definicion del limite de la frecuencia superior
			if(emisoraActual + 0.2f <= 107.9f) {				
				emisoraActual = (float) (emisoraActual + 0.2f);
			}else {
				emisoraActual = (float) 87.9;
			}
			
		}
	
	}

	/**
     * Metodo bajarEmisora: sirve para cambiar la senal hacia abajo.
     * 
     */
	@Override
	public void bajarEmisora() {
		
		if(tipoSenal) {
			//Definicion del limite de la frecuencia inferior
			if(emisoraActual - 10f >= 530f) {				
				emisoraActual = (float) emisoraActual - 10f;
			}else {
				emisoraActual = (float) 1610;
			}
			
		}else{
			//Definicion del limite de la frecuencia inferior
			if(emisoraActual - 0.2f >= 87.9f) {				
				emisoraActual = (float) (emisoraActual - 0.2f);
			}else {
				emisoraActual = (float) 107.9;
			}
			
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
