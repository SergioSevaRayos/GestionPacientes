package gestion;

public class Profesionales_Medicos {
	// Variables generales
	static int id_codigo;
	static String telefono;
	static String especialidad;
	static String nombre;
	static String apellidos;
	static String DNI;
	static String localidad;
	
	public static void Profesional(int cod, String tel, String esp, String nom, String apll, String dni, String loc) {
		id_codigo = cod;
		telefono = tel;
		especialidad = esp;
		nombre = nom;
		apellidos = apll;
		DNI = dni;
		localidad = loc;
	}
	public static void insert_medicos() {
		TestConexion.insert_Profesional(1, "111111111","Cirujia","Pepe","Elda","33333333o","Serna");
		TestConexion.insert_Profesional(2, "222222222","Cardiologia","Maria","Alicante","44444444p","Gonzalez");
		TestConexion.insert_Profesional(3, "333333333","Ginicologia","Jose","Ceuta","55555555p","Pinto");
		TestConexion.insert_Profesional(4, "444444444","General","Vicente","Alicante","66666666o","Jimenez");
		TestConexion.insert_Profesional(5, "555555555","Podologia","Andres","Cadiz","99999999y","Armario");
	}
	
}
