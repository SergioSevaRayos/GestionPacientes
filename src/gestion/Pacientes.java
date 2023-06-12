package gestion;

//import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase para agregar pacientes
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class Pacientes {
	// Variables para gestionar los pacientes
		static String DNI; 																	// Variable para almacenar el DNI
		static String nombre; 																// Variable para almacenar nombre
		static String edad; 																// Variable para almacenar la edad
		static String calle; 																// Variable para almacenar la calle
		static String localidad; 															// Variable para almacenar la localidad
		static String cod_postal; 															// Variable para almacenar el código postal
		
		static int op = 0; // Variable para la selección de las diferentes opciones
		static Scanner sc = new Scanner(System.in); // Variable para escanear las diferentes opciones
		
		public static void inDNI() throws FileNotFoundException, IOException {
			// Recolección del dato "DNI"
			System.out.println("FORMATO: El DNI contiene 8 caracteres numericos y uno alfabetico al final");
			System.out.println("Ej. 99999999y");
			System.out.print("\nIntroduce el DNI del paciente: ");
			DNI = sc.nextLine();
			
			// Mediante esta sentencia comprobamos que el "DNI" tiene el formato correcto
			if (DNI != null && DNI.matches("\\d{8}[A-Za-z]")) {
				System.out.println("");
//				compruebaDNI();
				Menu.menu();
			}else {
				System.out.print("DNI incorrecto, vuelve a introducirlo: ");
				inDNI();
			}
		}
		
		 /**
		 * Método para la introducción del dato "nombre", mediante este método nos aseguramos
		 * que los datos introducidos son correctos
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void inNombre() throws FileNotFoundException, IOException {
			// Recolección del dato "nombre"
			op = 1;
			System.out.println("FORMATO: El nombre consta de caracteres alfabeticos sin numeros ");
			System.out.println("Ej. Pepe Ventana Armario");
			System.out.println("\nIntroduce el nombre del paciente: ");
			nombre = sc.nextLine();
			
			// Mediante esta sentencia nos aseguramos que el menú aparece una vez se ha introducido el dato
			if (nombre != null) {
				Menu.op = 1;
				Menu.menu();
			}else {
				inNombre();
			}
		}
		
		/**
		 * Método para la introducción del dato "edad", mediante este método nos aseguramos
		 * que los datos introducidos son correctos
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void inEdad() throws FileNotFoundException, IOException {
			// Recolección del dato "edad"
			op = 1;
			System.out.println("FORMATO: La edad se compone de caracteres numericos");
			System.out.println("Ej. 34");
			System.out.println("\nIntroduce la edad del paciente: ");
			edad = sc.nextLine();

			// Mediante esta sentencia nos aseguramos que la edad tiene el formato correcto
			if (edad != null && edad.matches("^[0-9]+$")) {
				System.out.println("Edad correcta");
				Menu.op = 1;
				Menu.menu();
			}else {
				System.err.println("Edad incorrecta, vuelve a introducirla");
				inEdad();
			}
		}
		
		/**
		 * Método para la introducción del dato "calle", mediante este método nos aseguramos
		 * que los datos introducidos son correctos
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void inCalle() throws FileNotFoundException, IOException {
			// Recolección del dato "calle"
			op = 1;
			System.out.println("FORMATO: La calle consta de caracteres alfanumericos");
			System.out.println("Ej. Calle Santa Pola 4");
			System.out.println("\nIntroduce la calle del paciente: ");
			calle = sc.nextLine();
			
			// Mediante esta sentencia nos aseguramos que el menú aparece una vez se ha introducido el dato
			if (calle != null) {
				Menu.op = 1;
				Menu.menu();
			} else {
				System.err.println("Calle incorrecta, vuelve a introducirla");
				inCalle();
			}
		}
		
		/**
		 * Método para la introducción del dato "localidad", mediante este método nos aseguramos
		 * que los datos introducidos son correctos
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void inLocalidad() throws FileNotFoundException, IOException {
			// Recolección del dato "localidad"
			op = 1;
			System.out.println("FORMATO: El nombre consta de caracteres alfabeticos sin numeros ");
			System.out.println("Ej. Lorca");
			System.out.println("Introduce la localidad del paciente: ");
			localidad = sc.nextLine();
			
			// Mediante esta sentencia nos aseguramos que el menú aparece una vez se ha introducido el dato
			if (localidad != null) {
				Menu.op = 1;
				Menu.menu();
			} else {
				inLocalidad();
			}
		}
		
		/**
		 * Método para la introducción del dato "código postal", mediante este método nos aseguramos
		 * que los datos introducidos son correctos
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void inCodPostal() throws FileNotFoundException, IOException {
			// Recolección del dato "cod_postal"
			op = 1;
			System.out.println("FORMATO: El codigo postal consta de caracteres alfanumericos");
			System.out.println("Ej. 03349");
			System.out.println("\nIntroduce el cod_postal del paciente: ");
			cod_postal = sc.nextLine();
			
			// Mediante esta sentencia nos aseguramos que el menú aparece una vez se ha introducido el dato
			if (cod_postal != null) {
				Menu.op = 1;
				Menu.menu();
			} else {
				inCodPostal();
			}
		}
		
		/**
		 * Método para preparar las variables para la recolección de datos 
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void iniciaDatosPac() throws FileNotFoundException, IOException {
			DNI = "";
			nombre = "";
			edad = "";
			calle = "";
			localidad = "";
			cod_postal = "";
			op = 0;
			Menu.menu();
		}
		
}
