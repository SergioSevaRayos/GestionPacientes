package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexi�n con la base de datos
 * 
 * @author		Sergio Seva Rayos
 * @version		V0.5.
 * @since 		01/05/2023
 */
public class Conexion {

	private static final String NOMBRE_BD = "BDed"; 					// Variable que almacena el nombre de la base de datos
	private static final String UBICACION = "localhost"; 				// Variable que almacena el host
	private static final String PUERTO = "3307"; 						// Variable que almacena el puerto 
	private static final String USUARIO = "sergio_root"; 				// Variable que almacena el nombre de usuario
	private static final String CLAVE = "9400Jet_"; 					// Variable que almacena la contrase�a del usuario
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver"; 	// Variable que almacena el controlador
	
	
	/**
	 * Este m�todo genera una URL de conexi�n con la base de datos MySQL.
	 * 
	 * La URL se compone a partir de una ubicaci�n, un puerto y un nombre de base de datos,
	 * adem�s se utiliza Unicode y el encoding UTF-8 en la conexi�n.
	 * 
	 * Se carga el controlador de MySQL para poder establecer la conexi�n.
	 * 
	 * @return una cadena con la URL de conexi�n a la base de datos.
	 */
	private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
			+ "?useUnicode=true&characterEncoding=utf-8";
	static {
		try {
			// Cargamos el controlador
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			// Error al cargar el controlador 
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	/**
	* Este m�todo establece una conexi�n con la base de datos utilizando el driver de JDBC.
	*
	* @return una instancia de la clase Connection que representa la conexi�n establecida
	*/
	public Connection conectar() {
		Connection conexion = null;
		try {
			// Establecemos la conexi�n 
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("");
			System.out.println("Conexion correctamente establecida con la base de datos " + NOMBRE_BD);
		} catch (SQLException e) {
			// Error al establecer la conexi�n
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
}


