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
	/**
	 * Este método se encarga de insertar en la base de datos varios profesionales médicos.
	 * Se utilizan diferentes llamadas al método "TestConexion.insert_Profesional" para insertar los registros.
	 */
	public static void insert_medicos() {
		TestConexion.insert_Profesional(1, "111111111","Cirujia","Pepe","Elda","33333333o","Serna");
		TestConexion.insert_Profesional(2, "222222222","Cardiologia","Maria","Alicante","44444444p","Gonzalez");
		TestConexion.insert_Profesional(3, "333333333","Ginicologia","Jose","Ceuta","55555555p","Pinto");
		TestConexion.insert_Profesional(4, "444444444","General","Vicente","Alicante","66666666o","Jimenez");
		TestConexion.insert_Profesional(5, "555555555","Podologia","Andres","Cadiz","99999999y","Armario");
	}
	
}
