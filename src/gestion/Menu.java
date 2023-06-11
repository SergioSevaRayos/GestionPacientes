package gestion;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Date;
import java.util.Scanner;

/**
 * Clase para gestionar el men�, desde el se gestiona toda la aplicaci�n
 * 
 * @author		Sergio Seva Rayos.
 * @version		V0.4.
 * @since 		01/03/2023.
 */
public class Menu {
	static int op = 0; 																		// Variable para la selecci�n de las diferentes opciones
	static Scanner sc = new Scanner(System.in); 											// Variable crear el scanner

	/**
	 * M�todo para mostrar los datos que se van agregando
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
	 * M�todo para mostrar los datos que se van agregando
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
		System.out.println("Nombre profesional: " + Profesionales_Medicos.nombre);
		System.out.println("Codigo: " + Profesionales_Medicos.id_codigo);
		System.out.println("Especialidad--> " + Profesionales_Medicos.especialidad);
		System.out.println("_______________________________________________________");
	}	



	/**
	 * M�todo a trav�s del cual gestionamos el men�
	 * @throws IOException si ocurre un error.
	 * @throws FileNotFoundException si no se encuentra el archivo en la ubicaci�n especificada.
	 */
	public static void menu()  throws FileNotFoundException, IOException  {
		while (op <= 0 || op >4) {
			System.out.println("\t\t\t  MENU");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("1. Agregar paciente");
			if (Profesionales_Medicos.id_codigo != 0) {
				System.out.println("2. Nueva visita");
			}
			System.out.println("3. Selecciona profesional medico");
			System.out.println("4. Visitas realizadas");
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
			if (op < 0 || op > 4) {
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

				// Aquí se establecen las diferentes opciones para la recolección de datos
				switch (op) {
				case 0:
					// Llama al m�todo men�
					menu();
					break;
				case 1:
					// Llama al m�todo para insertar el DNI
					Pacientes.inDNI();
					break;
				case 2:
					// Llama al m�todo para insertar el nombre
					Pacientes.inNombre();
					break;
				case 3:
					// Llama al m�todo para insertar la edad
					Pacientes.inEdad();
					break;
				case 4:
					// Llama al m�todo para insertar la calle
					Pacientes.inCalle();
					break;
				case 5:
					// Llama al m�todo para insertar la localidad
					Pacientes.inLocalidad();
					break;
				case 6:
					// Llama al m�todo para insertar el c�digo postal
					Pacientes.inCodPostal();
					break;
				case 7:
					// Hace que aparezca la opci�n de guardado cuando se cumplen las condiciones
					if (Pacientes.DNI != "" && Pacientes.nombre != "" && Pacientes.edad != "" && Pacientes.calle != "" && Pacientes.localidad != "" && Pacientes.cod_postal != "") {
						System.out.println("Guardando.....");
						TestConexion.insert_paciente(Pacientes.DNI,Pacientes.nombre,Pacientes.edad,Pacientes.calle,Pacientes.localidad,Pacientes.cod_postal);
						// Llama al m�todo "iniciaDatosPac" para inicializar las variables a NULL
						Pacientes.iniciaDatosPac();
						menu();
					}else {
						System.err.println("ERROR");
						menu();
					}
					break;
				case 8:
					// Llama al m�todo "iniciaDatosVis" para borrar el contenido de las variables
					Pacientes.iniciaDatosPac();
					System.out.println("Borrando datos....");
					break;
				}
			}

		case 2:
			if (Profesionales_Medicos.id_codigo != 0) {
				op = 0;
				while (op <= 0 || op >6 ) {
					Menu.muestraDatosVis();
					System.out.println("\t\t    AGREGAR VISITA");
					System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
					System.out.println("1. DNI");
					System.out.println("2. Peso");
					System.out.println("3. Altura");
					System.out.println("4. Calcular IMC");
					// Hace que aparezca la opci�n de guardado cuando se cumplen las condiciones
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

					// Aquí se establecen las diferentes opciones de la recolección de datos
					switch (op) {
					case 0:
						// Llama al m�todo para regresar al men�
						menu();
						break;
					case 1:
						// Llama al m�todo para insertar el DNI
						Visitas.inDNIvisita();
						break;
					case 2:
						// Llama al m�todo para insertar el peso
						Visitas.inPeso();
						break;
					case 3:
						// Llama al m�todo para insertar la altura
						Visitas.inAltura();
						break;
					case 4:
						// Llama al m�todo calcular el IMC
						Visitas.calcC();
						menu();
						break;
					case 5:
						// Hace que aparezca la opci�n de guardado cuando se cumplen las condiciones
						if (Visitas.IMC != 0) {
							System.out.println("Guardando.....");
							TestConexion.insert_Visita( Visitas.f, Visitas.peso, Visitas.altura, Visitas.IMC, Pacientes.DNI,Profesionales_Medicos.id_codigo);
							// Llama al m�todo "iniciaDatosVis" para borrar el contenido de las variables
							Visitas.iniciaDatosVis();
							Profesionales_Medicos.id_codigo = 0;
							op = 0;
							menu();
						}else {
							System.err.println("ERROR");
							menu();
						}
						break;
					case 6:
						// Llama al m�todo "iniciaDatosVis" para borrar el contenido de las variables
						Visitas.iniciaDatosVis();
						System.out.println("Borrando datos....");
						break;
					}	
				}
			}else{
				op = 0;
				System.err.println("ERROR");
				menu();
			}
			break;
		case 3:
			System.out.println("\t\t    AGREGAR MEDICO");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("1. Cirujia: Pepe");
			System.out.println("2. Cardiologia: Maria");
			System.out.println("3. Ginicologia: Jose");
			System.out.println("4. General: Vicente");
			System.out.println("5. Podologia: Andres");
			System.out.println("6. Salir");
			if(sc.hasNextInt()) { 
				op = sc.nextInt(); 
			} else {
				sc.next(); 
				System.err.println("\nError");
				System.err.println("Error: Vuelve a elegir la opcion");
			}
			// Switch para gestionar la elecci�n del profesional 
			switch (op) {
			case 1:
				System.out.println("");
				System.out.print("Especialidad -->...");
				System.out.println( "Cirujia: Pepe");
				Profesionales_Medicos.id_codigo = 1;
				Profesionales_Medicos.nombre = "Pepe";
				Profesionales_Medicos.especialidad = "Cirujia";
				op = 0;
				menu();
				break;
			case 2:
				System.out.println("");
				System.out.print("Especialidad -->...");
				System.out.println( "Cardiologia: Maria");
				Profesionales_Medicos.id_codigo = 2;
				Profesionales_Medicos.nombre = "Maria";
				Profesionales_Medicos.especialidad = "Cardiologia";
				op = 0;
				menu();
				break;
			case 3:
				System.out.println("");
				System.out.print("Especialidad -->...");
				System.out.println( "Ginicologia: Jose");
				Profesionales_Medicos.id_codigo = 3;
				Profesionales_Medicos.nombre = "Jose";
				Profesionales_Medicos.especialidad = "Ginicologia";
				op = 0;
				menu();
				break;
			case 4:
				System.out.println("");
				System.out.print("Especialidad -->...");
				System.out.println( "General: Vicente");
				Profesionales_Medicos.id_codigo = 4;
				Profesionales_Medicos.nombre = "Vicente";
				Profesionales_Medicos.especialidad = "General";
				op = 0;
				menu();
				break;
			case 5:
				System.out.println("");
				System.out.print("Especialidad -->...");
				System.out.println( "Podologia: Andres");
				Profesionales_Medicos.id_codigo = 5;
				Profesionales_Medicos.nombre = "Andres";
				Profesionales_Medicos.especialidad = "Podologia";
				op = 0;
				menu();
				break;
			case 6:
				menu();
				break;
			}
			break;
		case 4:
			op = 0;
			System.out.println("\t    Selecciona metodo de busqueda");
			System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("######### CODIGO MEDICO ##########");
			System.out.println("|| " + "Cirujia\t\tCod. 1" + "\t||");
			System.out.println("|| " + "Cardiologia\t\tCod. 2" + "\t||");
			System.out.println("|| " + "Ginicologia\t\tCod. 3" + "\t||");
			System.out.println("|| " + "General\t\tCod. 4" + "\t||");
			System.out.println("|| " + "Podologia\t\tCod. 5" + "\t||");
			System.out.println("##################################");
			System.out.println("");
			System.out.println("1. DNI paciente y codigo de medico");
			System.out.println("2. Fecha y codigo de medico");
			System.out.println("");
			System.out.println("0. Salir");
			if(sc.hasNextInt()) { 
				op = sc.nextInt(); 
			} else {
				sc.next(); 
				System.err.println("\nError");
				System.err.println("Error: Vuelve a elegir la opcion");
			}
			switch (op) {
			case 1:
				System.out.println("DNI paciente y codigo de medico");
				TestConexion.consultaVisitasDni();
				op = 0;
				menu();
				break;
			case 2:
				System.out.println("Fecha y codigo de medico");
				TestConexion.consultaVisitasFecha();
				op = 0;
				menu();
				break;
			case 0:
				System.out.println("Saliendo....");
				op = 0;
				menu();
				break;
			}
			break;

		}
	}

}