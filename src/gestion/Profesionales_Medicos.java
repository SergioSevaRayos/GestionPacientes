package gestion;

/**
 * Clase para agregar profesionales médicos
 * 
 * @author		Sergio Seva Rayos
 * @version		V0.5.
 * @since 		01/05/2023
 */
public class Profesionales_Medicos {
	// Variables generales
	static int id_codigo;																	// Variable para almacenar el id_codigo
	static String telefono;																	// Variable para almacenar el telefono
	static String especialidad;																// Variable para almacenar la especialidad
	static String nombre;																	// Variable para almacenar el nombre
	static String apellidos;																// Variable para almacenar los apellidos
	static String DNI;																		// Variable para almacenar el DNI
	static String localidad;																// Variable para almacenar la localidad
	
	/**
	 * Crea un objeto profesional con los datos proporcionados
	 * 
	 * @param cod el código del profesional
	 * @param tel el número de teléfono del profesional
	 * @param esp la especialidad del profesional
	 * @param nom el nombre del profesional
	 * @param apll el apellido del profesional
	 * @param dni el DNI del profesional
	 * @param loc la localidad del profesional 
	 */
	public static void Profesional(int cod, String tel, String esp, String nom, String apll, String dni, String loc) {
		id_codigo = cod;
		telefono = tel;
		especialidad = esp;
		nombre = nom;
		apellidos = apll;
		DNI = dni;
		localidad = loc;
	}

	
}
