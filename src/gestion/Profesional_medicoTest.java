package gestion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Profesional_medicoTest {

	// Método para testear la creación de un objeto profesional 
	@Test
	void test() { 
		Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
				assertEquals(1, Profesionales_Medicos.id_codigo);
				assertEquals("123456789", Profesionales_Medicos.telefono);
				assertEquals("Cardiología", Profesionales_Medicos.especialidad);
				assertEquals("Sergio", Profesionales_Medicos.nombre);
				assertEquals("Seva Rayos", Profesionales_Medicos.apellidos);
				assertEquals("12345678A", Profesionales_Medicos.DNI);
				assertEquals("Valencia", Profesionales_Medicos.localidad);
	}
	
	// Método para testear la modificación de la variable id_codigo
	@Test
	public void testId_Codigo() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.id_codigo = 2;
	assertEquals(2, Profesionales_Medicos.id_codigo);
	}
	
	// Método para testear la modificación de la variable telefono
	@Test
	public void testTelefono() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.telefono = "987654321";
	assertEquals("987654321", Profesionales_Medicos.telefono);
	}

	// Método para testear la modificación de la variable especialidad
	@Test
	public void testEspecialidad() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.especialidad = "Traumatología";
	assertEquals("Traumatología", Profesionales_Medicos.especialidad);
	}

	// Método para testear la modificación de la variable nombre
	@Test 
	public void testNombre() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.nombre = "Andrea";
	assertEquals("Andrea", Profesionales_Medicos.nombre);
	}

	// Método para testear la modificación de la variable apellidos
	@Test
	public void testApellidos() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.apellidos = "García Martínez";
	assertEquals("García Martínez", Profesionales_Medicos.apellidos);
	}

	// Método para testear la modificación de la variable DNI
	@Test
	public void testDNI() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.DNI = "87654321B";
	assertEquals("87654321B", Profesionales_Medicos.DNI);
	}

	// Método para testear la modificación de la variable localidad
	@Test
	public void testLocalidad() {
	Profesionales_Medicos.Profesional(1, "123456789", "Cardiología", "Sergio", "Seva Rayos", "12345678A", "Valencia");
	Profesionales_Medicos.localidad = "Madrid";
	assertEquals("Madrid", Profesionales_Medicos.localidad);
	}
}
