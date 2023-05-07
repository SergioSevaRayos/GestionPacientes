package gestion;

import java.io.FileWriter;
import java.io.PrintWriter;


/*
 * Aquí contemplamos una de las opciones a la hora de capturar 
 * excepciones.
 * En esta parte lo hacemos con la estructura try + catch y añadimos la 
 * opción de ejecución obligatoria con la sentencia finally.
 */

/**
 * 
 * @author Sergio Seva Rayos
 * @version 1.0
 *
 */
public class TratamientoFichero {
	// Variables para leer los ficheros pacientes
	static String rutaPac = "C:/Users/sergi/git/GestionPacientes/ficheros/Pacientes.txt";
	static String rutaVis = "C:/Users/sergi/git/GestionPacientes/ficheros/Visitas.txt";
	
	// Variables para escribir en los ficheros
	static PrintWriter pw = null;
	static FileWriter fichero = null;

	/**
	 * Método por el cual guardamos los datos de los pacientes en un documento .txt
	 */
	public static void tryCatchPaci() {
		try {
			// Añadir flag a true para no machacar contenido del
			fichero = new FileWriter(rutaPac, true);
			pw = new PrintWriter(fichero);
			
			//---------------------------------------------- Inicio 
			pw.println(Pacientes.DNI + ", " + Pacientes.nombre + ", " + Pacientes.edad + ", " + Pacientes.calle + ", " + Pacientes.localidad + ", " + Pacientes.cod_postal);
			//---------------------------------------------- Fin   
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			} finally {
				try {
					// Nuevamente aprovechamos el finally para
					// asegurarnos que se cierra el fichero.
					if (null != fichero) {
						fichero.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método por el cual guardamos los datos de las consultas en un documento .txt
	 */
	public static void tryCatchVisi() {
		try {
			// Añadir flag a true para no machacar contenido del
			fichero = new FileWriter(rutaVis, true);
			pw = new PrintWriter(fichero);
			
			//---------------------------------------------- Inicio 
			pw.println(Pacientes.DNI + ", " + Visitas.f + ", " + Visitas.h + ", " + Visitas.peso + Visitas.kg + ", " + Visitas.altura + Visitas.m + ", " + ((double)Math.round(Visitas.IMC * 100d) / 100d) + " IMC");
			//---------------------------------------------- Fin   
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			} finally {
				try {
					// Nuevamente aprovechamos el finally para
					// asegurarnos que se cierra el fichero.
					if (null != fichero) {
						fichero.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}