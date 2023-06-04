package gestion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Visitas {
	// Variables para formato de fecha
	static Date fecha = new Date(); // Variable para generar la fecha y la hora
	
	static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); // Variable para darle el formato a la fecha
	static SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss"); // Variable para darle el formato a la hora
			
	// Variables para gestionar las visitas
	static String fechaCons = formatoFecha.format(fecha); // Variable para la fecha
	static String horaCons = formatoHora.format(fecha); // Variable para almacenar la hora de la consulta 
	static String h = horaCons;
	static String f = fechaCons;
	static double peso = 000.00; // Variable para almacenar el peso
	static double altura; // Variable para almacenar la altura
	static double IMC; // Variable para almacenar el índice de masa corporal
	static final String kg = "kg"; // Variable para indicar la unidad de medida del peso
	static	final String m = "m"; // Variable para indicar la unidad de medida de la altura

	
	static int op = 0; // Variable para la selección de las diferentes opciones
	static Scanner sc = new Scanner(System.in); // Variable para escanear las diferentes opciones
	
	
	/**
	 * Método para la introducción de la variable "peso"
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */   
	public static void inPeso() throws FileNotFoundException, IOException{
		// Mediante try/catch nos aseguramos que el programa no se detiene cuando haya un error
		try {
			// Recolección del dato "peso"
			Menu.op = 2;
			System.out.println("FORMATO: El peso consta de caracteres numericos");
			System.out.println("Ej. 90");
			System.out.println("\nIntroduce el peso del paciente: ");
			peso = sc.nextDouble();
			
			// Mediante esta sentencia nos aseguramos que el peso tiene el formato correcto
			if (peso != 0) {
				System.out.println("Peso correcto");
				Menu.op = 2;
				Menu.menu();
			}else {
				System.err.println("Peso incorrecto, vuelve a introducirlo");
				inPeso();
			}
		} catch (Exception e) {
			// Vuelve al menú si el programa falla
			System.err.println("ERROR: El programa ha fallado");
			Menu.menu();
		}
	}
	
	/**
	 * Método para la introducción de la variable "altura"
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void inAltura() throws FileNotFoundException, IOException {
		// Mediante try/catch nos aseguramos que el programa no se detiene cuando haya un error
		try {
			// Recolección del dato "altura"
			Menu.op = 2;
			System.out.println("FORMATO: La altura consta de caracteres numericos y se separan por una coma");
			System.out.println("Ej. 1,90");
			System.out.println("\nIntroduce la altura del paciente: ");
			altura = sc.nextDouble();
			
			// Mediante esta sentencia nos aseguramos que la altura tiene el formato correcto
			if (altura != 0) {
				System.out.println("Altura correcta");
				Menu.op = 2;
				Menu.menu();
			}else {
				System.err.println("Altura incorrecta, vuelve a introducirla");
				inAltura();
			}
		} catch (Exception e) {
			// Vuelve al menú si el programa falla
			System.err.println("ERROR: El programa ha fallado");
			Menu.menu();
		}
		
	}
	
	/**
	* Método para la introducción del dato "DNI" en las visitas, mediante este método nos aseguramos
	* que los datos introducidos son correctos
	 * @throws IOException 
	 * @throws FileNotFoundException 
	*/
	public static void inDNIvisita() throws FileNotFoundException, IOException {
		// Recolección del dato "DNI"
		System.out.println("FORMATO: El DNI contiene 8 caracteres numericos y uno alfabetico al final");
		System.out.println("Ej. 99999999y");
		System.out.print("\nIntroduce el DNI del paciente: ");
		Pacientes.DNI = sc.nextLine();
		
		// Mediante esta sentencia comprobamos que el "DNI" tiene el formato correcto
		if (Pacientes.DNI != null && Pacientes.DNI.matches("\\d{8}[A-Za-z]")) {
			System.out.println("DNI correcto");
			Menu.op = 2;
			Menu.menu();
		}else {
			System.out.print("DNI incorrecto, vuelve a introducirlo: ");
			inDNIvisita();
		}
	}
	
	/**
	 * Método por el cual se calcula el IMC
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void calcC() throws FileNotFoundException, IOException {
		// Mediante try/catch nos aseguramos que el programa no se detiene cuando haya un error
		try {
			Menu.op = 2;
			IMC = peso / (altura * altura); // Variable para almacenar el índice de masa corporal
			Menu.menu();
		} catch (Exception e) {
			// Vuelve al menú si el programa falla
			System.err.println("ERROR: El programa ha fallado");
			Menu.menu();
		}
	}
	/**
	 * Método para inicializar los datos
	 */
	public static void iniciaDatosVis() {
		Menu.op = 1;
		Pacientes.DNI = "";
		horaCons = "";
		fechaCons = "";
		peso = 0;
		altura = 0;
		IMC = 0;
		op = 0;
		Profesionales_Medicos.id_codigo = 0;
	}
	
}