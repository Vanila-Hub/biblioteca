package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
 final static String URL = "biblioteca";
 final static String USR = "root";
 final static String PASSWD = "";
 final static String HOST = "localhost";
 static Connection con=null;
 
 public static void conectar() {
	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" +URL,USR,PASSWD);
		} catch (Exception e) {
			System.out.println(e);
	}
 }
 
 public  void CERRAR() {
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
 
 
