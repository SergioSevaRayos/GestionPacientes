package gestion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Profesional_medicoTest {

	// M�todo para testear la creaci�n de un objeto profesional 
	@Test
	void test() { 
		Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
				assertEquals(1, Profesionales_Medicos.id_codigo);
				assertEquals("123456789", Profesionales_Medicos.telefono);
				assertEquals("Cardiolog�a", Profesionales_Medicos.especialidad);
				assertEquals("Sergio", Profesionales_Medicos.nombre);
				assertEquals("Seva Rayos", Profesionales_Medicos.apellidos);
				assertEquals("12345678A", Profesionales_Medicos.DNI);
				assertEquals("Valencia", Profesionales_Medicos.localidad);
	}
	
	// M�todo para testear la modificaci�n de la variable id_codigo
	@Test
	public void testId_Codigo() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.id_codigo = 2;
	assertEquals(2, Profesionales_Medicos.id_codigo);
	}
	
	// M�todo para testear la modificaci�n de la variable telefono
	@Test
	public void testTelefono() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.telefono = "987654321";
	assertEquals("987654321", Profesionales_Medicos.telefono);
	}

	// M�todo para testear la modificaci�n de la variable especialidad
	@Test
	public void testEspecialidad() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.especialidad = "Traumatolog�a";
	assertEquals("Traumatolog�a", Profesionales_Medicos.especialidad);
	}

	// M�todo para testear la modificaci�n de la variable nombre
	@Test 
	public void testNombre() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.nombre = "Andrea";
	assertEquals("Andrea", Profesionales_Medicos.nombre);
	}

	// M�todo para testear la modificaci�n de la variable apellidos
	@Test
	public void testApellidos() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.apellidos = "Garc�a Mart�nez";
	assertEquals("Garc�a Mart�nez", Profesionales_Medicos.apellidos);
	}

	// M�todo para testear la modificaci�n de la variable DNI
	@Test
	public void testDNI() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.DNI = "87654321B";
	assertEquals("87654321B", Profesionales_Medicos.DNI);
	}

	// M�todo para testear la modificaci�n de la variable localidad
	@Test
	public void testLocalidad() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiolog�a", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.localidad = "Madrid";
	assertEquals("Madrid", Profesionales_Medicos.localidad);
	}
}
