package gestion;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase encargada de leer los ficheros almacenados en los documentos de texto Visitas.txt, Pacientes.txt y Medicos.txt.
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class TratamientoFichero {
	// Variables para leer los ficheros pacientes
	static String rutaPac = "C:/Users/sergi/git/GestionPacientes/ficheros/Pacientes.txt";	// Variable que almacena la ruta del archivo Pacientes.txt.
	static String rutaVis = "C:/Users/sergi/git/GestionPacientes/ficheros/Visitas.txt";		// Variable que almacena la ruta del archivo Visitas.txt.
	static String rutaMed = "C:/Users/sergi/git/GestionPacientes/ficheros/Medicos.txt";		// Variable que almacena la ruta del archivo Medicos.txt.
	
	// Variables para escribir en los ficheros
	static PrintWriter pw = null;															// Variable para mostrar los datos por pantalla
	static FileWriter fichero = null;														// Variable para escribir en los ficheros

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
			pw.println(Pacientes.DNI + ", " + Visitas.f + ", " + Visitas.h + ", " + Visitas.peso + Visitas.kg + ", " + Visitas.altura + Visitas.m + ", " + ((double)Math.round(Visitas.IMC * 100d) / 100d) + " IMC" + ", " + Profesionales_Medicos.id_codigo);
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
	 * Método por el cual guardamos los datos de los profesionales medicos en un documento .txt
	 */
	public static void tryCatchMedico() {
		try {
			// Añadir flag a true para no machacar contenido del
			fichero = new FileWriter(rutaMed, true);
			pw = new PrintWriter(fichero);
			
			//---------------------------------------------- Inicio 
			pw.println(
					Profesionales_Medicos.id_codigo + ", " + 
					Profesionales_Medicos.telefono + ", " + 
					Profesionales_Medicos.especialidad + ", " + 
					Profesionales_Medicos.nombre + ", "+
					Profesionales_Medicos.apellidos + ", " + 
					Profesionales_Medicos.DNI + ", "+
					Profesionales_Medicos.localidad);
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