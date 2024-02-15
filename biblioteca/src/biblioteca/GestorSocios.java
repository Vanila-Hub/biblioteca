package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSocios {
	static ArrayList<Socio> socios = new ArrayList<Socio>();
	static GestorBBDD BaseDeDatos = new GestorBBDD();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		run(scan);
	}
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
				socios = BaseDeDatos.verSocios(socios);
				break;
			case Menu.MODIFICAR_SOCIO:
				modificarSocio(scan);
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
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

