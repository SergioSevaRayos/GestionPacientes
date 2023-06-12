package gestion;

import java.io.IOException;


/**
 * Clase "main" encargada de llamar a los m�todos necesarios para el funcionamiento del programa.
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class Main { 
	 
	/**
	 * 
	 * @param args Par�metro de entrada del m�todo principal.
	 * @throws IOException Si existe alg�n problema llamar al los m�todos.
	 */
	public static void main(String[] args) throws IOException {
		// Muestra los datos del paciente en la consola
		Menu.muestraDatosPac();
		// Muestra los datos de la visita en la consola
		Menu.muestraDatosVis();
		// Llama al men� encargado de gestionar la aplicaci�n 
		Menu.menu();
	}
}
