/**
 * Clase Principal
 * @author Brian_Anthony_Carrillo_Monzon
 * @author Carlos_Edgardo_Lopez_Barrera
 * @version 1.0 29.01.2022
 *
 * En esta clase se maneja el metodo main que permite la ejecucion del 
 * programa. Desde el metodo main se ejecuta el menu y los metodos del 
 * radio.
 */

//Importacion de la clase Scanner del paquete java.util
import java.util.Scanner;

//Importacion de la clase ArrayList
import java.util.ArrayList;

public class Principal {
    /**
    *
    */

	
    /**
     * Metodo Principal del programa
     *
     * @param args: (String[])
     * @see System.out#println()
     * @see java.util.Scanner#Scanner()
     * @see java.util.Scanner#nextLine()
     * @see java.util.Scanner#nextInt()
     * @see RadioController#RadioController()
     * @see RadioController#encenderApagar()
     * @see RadioController#guardarEmisoraActual()
     * @see RadioController#seleccionarEmisoraGuardada()
     * @see RadioController#cambiarSenal()
     * @see RadioController#getTipoSenal()
     * @see RadioController#subirEmisora()
     * @see RadioController#bajarEmisora()
     * @see RadioController#getEmisoraActual()
     * @see RadioController#comprobarEncendida()
     */
	public static void main(String[] args) {
		
		//Instancia de la clase controlador
		RadioController radio = new RadioController();
		
		//Instancia de la clase Scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenido\n");
		
		//Banderas para el manejo de menu y errores
		boolean menu = true;
		boolean error = false;
		
		//Ciclo menu
		do {
			if(radio.comprobarEncendida()) {
				int opcion=0;

                do{
                    //Verificacion de entrada de las opciones del menu
                    try{
                        //Solicitud de opcion de menu
                        System.out.println("\n---MENU---");
                        String frecuenciaActual = radio.getTipoSenal()?"AM":"FM";
                        System.out.println("Frecuencia actual: "+frecuenciaActual);
                        System.out.print("Emisora actual: "+radio.getEmisoraActual());
                        System.out.println("\nEscoja una de las siguientes opciones:");
                        System.out.println("1. Cambiar tipo de frecuencia");
                        System.out.println("2. Subir emisora.");
                        System.out.println("3. Bajar emisora.");
                        System.out.println("4. Guardar emisora actual.");
                        System.out.println("5. Seleccionar emisora guardada.");
                        System.out.println("6. Apagar radio.");
                        opcion = scanner.nextInt();
                        error = false;

                    //En caso de error
                    }catch(Exception e){
                        System.out.println("Error de ingreso, intente de nuevo.\n");
                        error = true;
                    //Finalmente
                    }finally{
                        scanner.nextLine();
                    }
                }while(error);
                
                //Opciones del menu
                switch(opcion) {
                	case 1:
                		//Cambio de senal
                		System.out.println(radio.cambiarSenal(!radio.getTipoSenal()));
                		break;
                	case 2:
                		//Aumento de emisora
                		radio.subirEmisora();
                		System.out.println("Emisora aumentada: "+radio.getEmisoraActual());
                		break;
                	case 3:
                		//Disminucion de Emisora
                		radio.bajarEmisora();
                		System.out.println("Emisora disminuida: "+radio.getEmisoraActual());
                		break;
                	case 4:
                		//Reproduccion de emisora
                		int opcionBoton=0;
                		
                		do{
                            //Verificacion de entrada de las opciones del menu
                            try{
                                //Solicitud de opcion de menu
                                System.out.println("\nIngrese el numero del boton en el que desea guardar la emisora [1-12]");
                                opcionBoton = scanner.nextInt();
                                error = false;

                            //En caso de error
                            }catch(Exception e){
                                System.out.println("Error de ingreso, intente de nuevo.\n");
                                error = true;
                            //Finalmente
                            }finally{
                                scanner.nextLine();
                            }
                        }while(error);
                		
                		System.out.println(radio.guardarEmisoraActual(opcionBoton));
                		break;
                	case 5:
                		//Seleccion de emisora
                		int boton=0;
                		
                		do{
                            //Verificacion de entrada de las opciones del menu
                            try{
                                //Solicitud de opcion de menu
                                System.out.println("\nIngrese el numero del boton en el que se encuentra guardada la emisora [1-12]");
                                boton = scanner.nextInt();
                                error = false;

                            //En caso de error
                            }catch(Exception e){
                                System.out.println("Error de ingreso, intente de nuevo.\n");
                                error = true;
                            //Finalmente
                            }finally{
                                scanner.nextLine();
                            }
                        }while(error);
                		
                		System.out.println(radio.seleccionarEmisoraGuardada(boton));              		
                		break;
                	case 6:
                		//Apagado de radio
                		radio.encenderApagar();
                		System.out.println("Apagando radio...");
                		break;
                	default:
                		//Mensaje de opcion incorrecta
                        System.out.println("Opcion incorrecta. Intentelo de nuevo.");
                		break;
                }
			}else {
				int opcionApagado = 0;
				
				//Menu para radio apagado
				do {
					//Verificacion de entrada de las opciones del menu
					try {
						//Solicitud de opcion de menu
                        System.out.println("\n---MENU---");
                        System.out.println("Escoja una de las siguientes opciones:");
                        System.out.println("1. Encender radio");
                        System.out.println("2. Salir");
                        opcionApagado = scanner.nextInt();
                        error = false;
					}catch(Exception e) {
						 System.out.println("Error de ingreso, intente de nuevo.\n");
	                     error = true;
					}finally {
						scanner.nextLine();
					}
				}while(error);
				
				//Opciones para radio apagado
				switch(opcionApagado) {
					case 1:
						//Encendido de radio
						radio.encenderApagar();
						break;
					case 2:
						//Mensaje de despedida
                        System.out.println("Saliendo...");
                        System.out.println("Feliz Dia.");

                        //Cambio de valor para salir del ciclo while
                        menu = false;
                		break;
                	default:
                		//Mensaje de opcion incorrecta
                        System.out.println("Opcion incorrecta. Intentelo de nuevo.");
                		break;
				}
			}
		}while(menu);

	}

}
