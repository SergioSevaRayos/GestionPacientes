package gestion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
* En este método contemplamos otra opción de captura de 
excepciones con la llamada en la definición
* de un procedimmiento definido como estático con la palabra 
reservada Throws seguida
* de las excepciones a capturar
* 
*/
public class LeerFichero {
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	public static void main(String[] args) throws IOException {
		String rutaPac = "C:/Users/sergi/git/GestionPacientes/ficheros/Pacientes.txt";
		String rutaVis = "C:/Users/sergi/git/GestionPacientes/ficheros/Visitas.txt";
		System.out.println("--------------------------------------------------");
		System.out.println("		Datos de los pacientes");
		System.out.println("__________________________________________________");
		muestraContenido(rutaPac);
		System.out.println("###################################################");
		System.out.println("--------------------------------------------------");
		System.out.println("		Datos de las visitas");
		System.out.println("__________________________________________________");
		muestraContenido(rutaVis);
	}
}