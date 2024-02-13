package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Conector {
	
	private final static String URL = "biblioteca";
	private final static String USR = "root";
	private final static String PASSWD = "";
	private final static String HOST = "localhost";
	private static Connection con=null;
 
 public static Connection conectar() {
	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" +URL,USR,PASSWD);
		} catch (Exception e) {
			System.out.println(e);
	}
		return con;
 }
 
 
 public static void CERRAR() {
	    try {
	        if (con != null && !con.isClosed()) {
	            con.close();
	            System.out.println("Conexión cerrada");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al cerrar la conexión: " + e.getMessage());
	    }
 	}
 }
 
 
