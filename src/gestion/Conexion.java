package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String NOMBRE_BD = "BDed";
	private static final String UBICACION = "localhost";
	private static final String PUERTO = "3307";
	private static final String USUARIO = "sergio_root";
	private static final String CLAVE = "9400Jet_";
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	

		private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
				+ "?useUnicode=true&characterEncoding=utf-8";
		static {

			try {
				Class.forName(CONTROLADOR);
			} catch (ClassNotFoundException e) {
				// * TODO Auto-generated catch block
				System.out.println("Error al cargar el controlador");
				e.printStackTrace();
			}
		}

		public Connection conectar() {
			Connection conexion = null;

			try {

				// Establecemos la conexión para eso java nos prporciona conexion =
				conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

				System.out.println("");
				System.out.println("Conexion correctamente establecida con la base de datos " + NOMBRE_BD);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en la conexion");
				e.printStackTrace();
			}

			return conexion;
		}
	}


