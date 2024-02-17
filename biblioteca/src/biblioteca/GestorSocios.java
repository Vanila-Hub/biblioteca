package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSocios {
	private static ArrayList<Socio> socios = new ArrayList<Socio>();
	private static GestorBBDD BaseDeDatos = new GestorBBDD();

	public static void run(Scanner scan) {
		int opcion = 0;
		do {
			Menu m = new Menu();
			m.mostrarMenuSocios();
			
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.INSERTAR_SOCIO:
				insertarSocio(scan);
				break;
			case Menu.ELIMINAR_SOCIO:
				eliminarSocio(scan);
				break;
			case Menu.VER_SOCIO:
				verSocio(scan);
				break;
			case Menu.MODIFICAR_SOCIO:
				modificarSocio(scan);
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
	
	public static void verSocio(Scanner scan) {
		socios = BaseDeDatos.verSocios(socios);		
	}
	private static void modificarSocio(Scanner scan) {
		FormulariosdeDatos.modificardatosSocio(socios, scan);
	}
	private static void eliminarSocio(Scanner scan) {
		int id = FormulariosdeDatos.pedirIdSocio(scan);
		BaseDeDatos.eliminarSocio(id);
	}
	private static void insertarSocio(Scanner scan) {
		Socio socio = FormulariosdeDatos.pedirDtaosSocio(scan);
		BaseDeDatos.insertarSocio(socio);
	}

}

