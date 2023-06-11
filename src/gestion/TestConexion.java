package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * Clase encargada de gestionar las consultas a la base de datos
 * 
 * @author		Sergio Seva Rayos
 * @version		V0.5.
 * @since 		01/05/2023
 */
public class TestConexion {

	private static String selectTableSQL;													// Variable para seleccionar la tabla
	private static String insertTableSQL;													// Varible para insertar en la tabla
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Cierra la conexión, el statement y el resultSet, en ese orden.
	 * Realiza una impresión en la consola para confirmar que se ha cerrado la conexión con éxito.
	 * 
	 * @param cn objeto de tipo Connection que representa la conexión establecida
	 * @param stm objeto de tipo Statement utilizado para realizar consultas a la base de datos
	 * @param rs objeto de tipo ResultSet para almacenar los resultados obtenidos de la consulta 
	 */
	public static void cerrar_conexion3(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			System.out.println("");
			System.out.println("La conexion se ha cerrado con exito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}
	
	/**
	 * Crea una consulta para las visitas por DNI
	 */
	public static void consultaVisitasDni() {
	    Conexion conexion = new Conexion();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    
	    String pacienteDNI, cod_profesional;

	    selectTableSQL = "SELECT * FROM VISITAS WHERE id_dni = ? AND id_codigo = ?";

	    try {
	        // Abrimos la conexion con la base de datos
	        cn = conexion.conectar();
	        PreparedStatement ps = cn.prepareStatement(selectTableSQL);
	        System.out.println("Introduzca el DNI del paciente: ");
	        pacienteDNI = scanner.nextLine();
	        
	        System.out.println("Introduzca el codigo del profesional:");
	        cod_profesional = scanner.nextLine();
	        
	        ps.setString(1, pacienteDNI);
	        ps.setString(2, cod_profesional);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	System.out.println("");
	            System.out.println("Fecha: \t" + rs.getString(1));
	            System.out.println("Peso: \t" + rs.getString(2));
	            System.out.println("Altura: " + rs.getString(3));
	            System.out.println("IMC: \t" + rs.getString(4));
	            System.out.println("DNI: \t" + rs.getString(5));
	            System.out.println("Codigo: " + rs.getString(6));
	            System.out.println("");
	        }
	    } catch (SQLException e) {

	    } finally {
	        cerrar_conexion3(cn, stm, rs);
	    }
	    
	}
	
	/**
	 * Crea una consulta para las visitas por fecha
	 */
	public static void consultaVisitasFecha() {
	    
	    Conexion conexion = new Conexion();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    
	    String fecha, cod_profesional;

	    selectTableSQL = "SELECT * FROM VISITAS WHERE fecha = ? AND id_codigo = ?";

	    try {
	        // Abrimos la conexion con la base de datos
	        cn = conexion.conectar();
	        PreparedStatement ps = cn.prepareStatement(selectTableSQL);
	        System.out.println("El formato de la fecha es: aaaa-mm-dd");
	        System.out.println("Introduzca la fecha: ");
	        fecha = scanner.nextLine();
	        
	        System.out.println("Introduzca el codigo del profesional:");
	        cod_profesional = scanner.nextLine();
	        
	        ps.setString(1, fecha);
	        ps.setString(2, cod_profesional);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            System.out.println("\nFecha: " + rs.getString(1));
	            System.out.println("Peso: " + rs.getString(2));
	            System.out.println("Altura: " + rs.getString(3));
	            System.out.println("IMC: " + rs.getString(4));
	            System.out.println("DNI: " + rs.getString(5));
	            System.out.println("Codigo: " + rs.getString(6));
	        }
	    } catch (SQLException e) {

	    } finally {
	        cerrar_conexion3(cn, stm, rs);
	    }
	}

	/**
	 * Permite insertar un paciente en la base de datos, siempre y cuando el DNI no exista previamente en la tabla
	 * 
	 * @param DNI el DNI del paciente a insertar
	 * @param nombre el nombre del paciente a insertar
	 * @param edad la edad del paciente a insertar
	 * @param calle la calle del paciente a insertar
	 * @param localidad la localidad del paciente a insertar
	 * @param cod_postal el codigo postal del paciente a insertar
	 */
	@SuppressWarnings("resource")
	public static void insert_paciente(String DNI, String nombre, String edad, String calle, String localidad, String cod_postal) {
	
	Conexion conexion = new Conexion();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Crear sentencia SQL para buscar si el DNI ya existe en la tabla
	String selectTableSQL = "SELECT * FROM paciente WHERE DNI = ?";

	// Crear sentencia SQL para insertar en la base de datos
	String insertTableSQL = "INSERT INTO paciente (DNI,nombre,edad,calle,localidad,cod_postal) VALUES (?,?,?,?,?,?)";

	try {

		cn = conexion.conectar();
		
		// Preparar la sentencia SQL para buscar si el DNI ya existe en la tabla
		ps = cn.prepareStatement(selectTableSQL);
		ps.setString(1, DNI);
		rs = ps.executeQuery();
		
		// Si ya existe un registro con el mismo DNI, mostrar un mensaje y no insertar nada
		if(rs.next()) {
			System.out.println("Ya existe un paciente con el DNI " + DNI);
			return;
		}
		// Preparar la sentencia SQL para insertar en la base de datos
		ps = cn.prepareStatement(insertTableSQL);
		ps.setString(1, DNI);
		ps.setString(2, nombre);
		ps.setInt(3, Integer.parseInt(edad));
		ps.setString(4, calle);
		ps.setString(5, localidad);
		ps.setString(6, cod_postal);
		ps.executeUpdate();
		System.out.println("El paciente ha sido insertado con exito en la base de datos");
	} catch (SQLException e) {
		e.printStackTrace();
	} finally { // Liberar recursos revisar el orden en el que se cierran
		try {
			if (rs != null) {
				rs.close();
			}
		
			if (ps != null) {
				ps.close();
			}
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
} 
	/**
	 * Este método se encarga de insertar un nuevo registro en la tabla "profesional_medico"
	 * 
	 * @param codigo El código del profesional médico a insertar en la tabla
	 * @param telefono El número de teléfono del profesional médico a insertar en la tabla
	 * @param especialidad La especialidad del profesional médico a insertar en la tabla
	 * @param nombre El nombre del profesional médico a insertar en la tabla
	 * @param localidad La localidad del profesional médico a insertar en la tabla
	 * @param DNI El DNI del profesional médico a insertar en la tabla
	 * @param apellidos Los apellidos del profesional médico a insertar en la tabla
	 */
	public static void insert_Profesional(int codigo, String telefono, String especialidad, String nombre, String localidad, String DNI, String apellidos) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO profesional_medico (codigo,telefono,especialidad,nombre,DNI,localidad,apellidos) VALUES (?,?,?,?,?,?,?)";
		try {
			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);
			ps.setInt(1, codigo);
			ps.setString(2, telefono);
			ps.setString(3, especialidad);
			ps.setString(4,nombre);
			ps.setString(5, DNI);
			ps.setString(6, localidad);
			ps.setString(7, apellidos);
			ps.executeUpdate();
			System.out.println("El registro ha sido insertado con exito en la base de datos");
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Inserta una nueva visita en la base de datos.
	 * 
	 * @param fecha La fecha de la visita.
	 * @param peso El peso registrado en la visita.
	 * @param altura La altura registrada en la visita.
	 * @param IMC El índice de masa corporal calculado en base al peso y altura registrados en la visita.
	 * @param id_dni El DNI del paciente asociado a la visita.
	 * @param id_codigo El código del médico que realizó la visita.
	 */
	public static void insert_Visita(String fecha, double peso, double altura, double IMC, String id_dni, int id_codigo) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO visitas (fecha,peso,altura,IMC,id_dni,id_codigo) VALUES (?,?,?,?,?,?)";
		try {
			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);
			ps.setString(1, fecha.toString());
			ps.setDouble(2, peso);
			ps.setDouble(3, altura);
			ps.setDouble(4, IMC);
			ps.setString(5, id_dni);
			ps.setDouble(6, id_codigo);
			ps.executeUpdate();
			System.out.println("El registro ha sido insertado con exito en la base de datos");
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		insert_Visita(Visitas.numero_visita, Visitas.fecha, Visitas.peso, Visitas.altura, Visitas.IMC, Profesionales_Medicos.codigo);
//		consultaVisitas();
//		Profesionales_Medicos.insert_medicos();
//		consulta_insert("Pepe", "456", 2);
//		consulta_update(7, "alvaro", "123");

	}
}
