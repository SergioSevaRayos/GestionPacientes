package gestion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Clase encargada de leer los ficheros almacenados en los documentos de texto Visitas.txt, Pacientes.txt y Medicos.txt.
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class LeerFichero {
	static String rutaVis = "C:/Users/sergi/git/GestionPacientes/ficheros/Visitas.txt";		// Variable que almacena la ruta del archivo Visitas.txt.
	static String rutaPac = "C:/Users/sergi/git/GestionPacientes/ficheros/Pacientes.txt";	// Variable que almacena la ruta del archivo Pacientes.txt.
	static String rutaMed = "C:/Users/sergi/git/GestionPacientes/ficheros/Medicos.txt";		// Variable que almacena la ruta del archivo Medicos.txt.
	static String archivo;																	// Variable que almacena el contenido.
	static String cadena;																	// Variable que muestra el contenido.
	
	/**
	 * Muestra el contenido de un archivo por consola.
	 * 
	 * @param archivo es el archivo del que se quiere mostrar el contenido.
	 * @throws FileNotFoundException si no se encuentra el archivo en la ubicación especificada.
	 * @throws IOException si ocurre un error al leer el archivo.
	 */
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		
		FileReader f = new FileReader(archivo);												// Objeto creado para leer el archivo
		BufferedReader b = new BufferedReader(f);											// Objeto creado para leer el contenido del archivo
			
		// Bucle para leer cada línea e imprimirla en la consola
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}	
	/**
	 * Método principal que muestra por consola la información de los pacientes, visitas y médicos.
	 * 
	 * @param args Parámetro de entrada del método principal.
	 * @throws IOException Si existe algún problema al leer los archivos de datos.
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("--------------------------------------------------");
		System.out.println("		Datos de los pacientes");
		System.out.println("__________________________________________________");
		
		// Llama al método "muestraContenido" para que lea el archivo Pacientes.txt
		muestraContenido(rutaPac);															
		System.out.println("###################################################");
		System.out.println("--------------------------------------------------");
		System.out.println("		Datos de las visitas");
		System.out.println("__________________________________________________");
		
		// Llama al método "muestraContenido" para que lea el archivo Visitas.txt
		muestraContenido(rutaVis);
	}
}