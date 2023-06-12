package gestion;

import java.io.IOException;


/**
 * Clase "main" encargada de llamar a los métodos necesarios para el funcionamiento del programa.
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class Main { 
	 
	/**
	 * 
	 * @param args Parámetro de entrada del método principal.
	 * @throws IOException Si existe algún problema llamar al los métodos.
	 */
	public static void main(String[] args) throws IOException {
		// Muestra los datos del paciente en la consola
		Menu.muestraDatosPac();
		// Muestra los datos de la visita en la consola
		Menu.muestraDatosVis();
		// Llama al menú encargado de gestionar la aplicación 
		Menu.menu();
	}
}
