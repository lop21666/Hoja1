
public class RadioController implements Radio{
	
	private boolean encendido;
	private boolean tipoSenal;
	private float AMactual;
	private float FMactual;
	private float emisorasGuardadas[] = new float[12];
	private float emisoraActual;

	@Override
	public void encenderApagar() {
		if(encendido) {
			encendido = false;
		}else {
			encendido = true;
		}	
	}

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

	@Override
	public String cambiarSenal(Boolean opcion) {
		
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

	@Override
	public boolean getTipoSenal() {
		return tipoSenal;
	}

	@Override
	public void subirEmisora() {
		
		if(tipoSenal) {
			emisoraActual = emisoraActual + 10;
		}else{
			emisoraActual = (float) (emisoraActual + 0.2);
		}
	
	}

	@Override
	public void bajarEmisora() {
		
		if(tipoSenal) {
			emisoraActual = emisoraActual - 10;
		}else{
			emisoraActual = (float) (emisoraActual - 0.2);
		}
		
	}

	@Override
	public float getEmisoraActual() {
		return emisoraActual;
	}

	@Override
	public boolean comprobarEncendida() {
		return encendido;
	}
	
	

}
