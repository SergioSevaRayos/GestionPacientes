package gestion;

import java.util.Scanner;

public class Menu {
	
	// Variables generales
		static int op = 0; // Variable para la selección de las diferentes opciones
		static Scanner sc = new Scanner(System.in); // Variable para escanear las diferentes opciones
		
		/**
		 * Método para mostrar los datos que se van agregando
		 */
		static void muestraDatosPac() {
			System.out.println("_______________________________________________________");
			System.out.println("\t\t\tRESUMEN");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("DNI: " + Pacientes.DNI);
			System.out.println("Nombre: "+ Pacientes.nombre);
			System.out.println("Edad: "+ Pacientes.edad);
			System.out.println("Calle: " + Pacientes.calle);
			System.out.println("Localidad: "+ Pacientes.localidad);
			System.out.println("Codigo postal: " + Pacientes.cod_postal);
			System.out.println("_______________________________________________________");
		}
		
		/**
		 * Método para mostrar los datos que se van agregando
		 */
		static void muestraDatosVis() {
			System.out.println("_______________________________________________________");
			System.out.println("\t\t\tRESUMEN");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("DNI: " + Pacientes.DNI);
			System.out.println("Peso: "+ Visitas.peso + Visitas.kg);
			System.out.println("Altura: "+ Visitas.altura + Visitas.m);
			System.out.println("IMC: " + ((double)Math.round(Visitas.IMC * 100d) / 100d));
			System.out.println("Hora Consulta: " + Visitas.h);
			System.out.println("Fecha consulta: "+ Visitas.f);
			System.out.println("_______________________________________________________");
		}	
		
		
		
	/**
	 * Método a través del cual gestionamos el menú
	 */
	public static void menu() {
		while (op <= 0 || op >2) {
			System.out.println("\t\t\t  MENU");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("1. Agregar paciente");
			System.out.println("2. Nueva visita");
			System.out.println("");
			System.out.println("0. Salir");
			System.out.println("");

			// Mediante esta sentencia comprobamos que se introduce la opción de forma correcta, y si no, que vuelva introducirla
			if(sc.hasNextInt()) { 
			    op = sc.nextInt(); 
			} else {
			    sc.next(); 
			    System.err.println("\nError");
			    System.err.println("Error: Vuelve a elegir la opcion");
			}
			
			// Mediante esta sentencia informamos que la opción elegida no esta dentro del rango
			if (op < 0 || op > 2) {
			    System.err.println("\nError");
			    System.err.println("Error: Vuelve a elegir la opcion");
			}
		}
	
		// Aquí se establecen las diferentes opciones del menú
		switch (op) {
		case 1:
			op = 0;
			while (op <= 0 || op >8 ) {
				Menu.muestraDatosPac();
				System.out.println("\t\t    AGREGAR PACIENTE");
				System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("1. DNI");
				System.out.println("2. Nombre");
				System.out.println("3. Edad");
				System.out.println("4. Calle");
				System.out.println("5. Localidad");
				System.out.println("6. Codigo postal");
				if (Pacientes.DNI != null && Pacientes.nombre != null && Pacientes.edad != null && Pacientes.calle != null && Pacientes.localidad != null && Pacientes.cod_postal != null) {
					System.out.println("7. Guardar");
				}
				System.out.println("8. Borrar datos");
				System.out.println("");
				System.out.println("0. Salir");
				System.out.println("");
				
				// Mediante esta sentencia comprobamos que se introduce la opción de forma correcta, y si no, que vuelva introducirla
				if(sc.hasNextInt()) { 
				    op = sc.nextInt(); 
				} else {
				    sc.next(); 
				    System.err.println("\nError");
				    System.err.println("Error: Vuelve a elegir la opcion");
				}
				if (op < 0 || op > 8) {
					System.err.println("\nError");
					System.err.println("Error: Vuelve a elegir la opcion");
				}
				
				// Aquí se establecen las diferentes opciones de la recolección de datos
				switch (op) {
				case 0:
					menu();
					break;
				case 1:
					Pacientes.inDNI();
					break;
				case 2:
					Pacientes.inNombre();
					break;
				case 3:
					Pacientes.inEdad();
					break;
				case 4:
					Pacientes.inCalle();
					break;
				case 5:
					Pacientes.inLocalidad();
					break;
				case 6:
					Pacientes.inCodPostal();
					break;
				case 7:
					if (Pacientes.DNI != "" && Pacientes.nombre != "" && Pacientes.edad != "" && Pacientes.calle != "" && Pacientes.localidad != "" && Pacientes.cod_postal != "") {
						System.out.println("Guardando.....");
						TratamientoFichero.tryCatchPaci();
						Pacientes.iniciaDatosPac();
						menu();
					}else {
						System.err.println("ERROR");
						menu();
					}
					break;
				case 8:
					Pacientes.iniciaDatosPac();
					System.out.println("Borrando datos....");
					break;
				}
			}
			
		case 2:
			op = 0;
			while (op <= 0 || op >6 ) {
				Menu.muestraDatosVis();
				System.out.println("\t\t    AGREGAR VISITA");
				System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("1. DNI");
				System.out.println("2. Peso");
				System.out.println("3. Altura");
				System.out.println("4. Calcular IMC");
				if (Visitas.IMC != 0) {
					System.out.println("5. Guardar");
				}
				System.out.println("6. Borrar datos");
				System.out.println("");
				System.out.println("0. Salir");
				System.out.println("");
				
				// Mediante esta sentencia comprobamos que se introduce la opción de forma correcta, y si no, que vuelva introducirla
				if(sc.hasNextInt()) { 
				    op = sc.nextInt(); 
				} else {
				    sc.next(); 
				    System.err.println("\nError");
				    System.err.println("Error: Vuelve a elegir la opcion");
				}
				if (op < 0 || op > 6) {
					System.err.println("\nError");
					System.err.println("Error: Vuelve a elegir la opcion");
				}
				
				// Aquí se establecen las diferentes opciones de la recolección de datos
				switch (op) {
				case 0:
					menu();
					break;
				case 1:
					Visitas.inDNIvisita();
					break;
				case 2:
					Visitas.inPeso();
					break;
				case 3:
					Visitas.inAltura();
					break;
				case 4:
					Visitas.calcC();
					menu();
					break;
				case 5:
					if (Visitas.IMC != 0) {
						System.out.println("Guardando.....");
						TratamientoFichero.tryCatchVisi();
						Visitas.iniciaDatosVis();
						menu();
					}else {
						System.err.println("ERROR");
						menu();
					}
					break;
				case 6:
					Visitas.iniciaDatosVis();
					System.out.println("Borrando datos....");
					break;
				}
			}
			break;
		}
	}
	
}