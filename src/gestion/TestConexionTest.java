package gestion;


import org.junit.jupiter.api.Test;

class TestConexionTest {

	// Método para testear la introducción de los datos para consulta por DNI y cod_medico
	@Test
	public void testConsultaVisitasDni() {
		TestConexion.consultaVisitasDni();
	}

	// Método para testear la introducción de los datos para consulta por fecha y cod_medico
	@Test
	public void testConsultaVisitasFecha() {
		TestConexion.consultaVisitasFecha();
	}

	// Método para testear la introducción de los datos de paciente
	@Test
	public void testInsertPaciente() {
		String DNI = "123456789";
		String nombre = "Juan";
		String edad = "30";
		String calle = "Calle Principal";
		String localidad = "Ciudad";
		String cod_postal = "12345"; 

		TestConexion.insert_paciente(DNI, nombre, edad, calle, localidad, cod_postal);
	}
	
	// Método para testear la introducción de los datos de profesional
	@Test
	public void testInsertProfesional() {
		// Código de prueba
		int codigo = 1;
		String telefono = "123456789";
		String especialidad = "Medicina General";
		String nombre = "Dr. Juan Pérez";
		String localidad = "Ciudad";
		String DNI = "123456789";
		String apellidos = "Pérez";

		TestConexion.insert_Profesional(codigo, telefono, especialidad, nombre, localidad, DNI, apellidos);

	}

	// Método para testear la introducción de los datos de una visita
	@Test
	public void testInsertVisita() {
		// Código de prueba
		String fecha = "2023-06-12";
		double peso = 70.5;
		double altura = 1.75;
		double IMC = 22.9;
		String id_dni = "123456789";
		int id_codigo = 1;

		TestConexion.insert_Visita(fecha, peso, altura, IMC, id_dni, id_codigo);
	}
}
