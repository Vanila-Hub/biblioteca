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
		System.out.println("Introduzca el ID de socio a Modifiar: ");
		
		int id = Integer.parseInt(scan.nextLine());
		BaseDeDatos.modificarSocio(id,socios,scan);
		
		
	}
	private static void eliminarSocio(Scanner scan) {
		System.out.println("Indoduzca el id del Socio a borrar: ");
		int id = Integer.parseInt(scan.nextLine());
		BaseDeDatos.eliminarSocio(id);
	}
	private static void insertarSocio(Scanner scan) {
		
		Socio socio = new Socio();
		System.out.println("Ingrese el Nombre: ");
		socio.setNombre(scan.nextLine());
		System.out.println("Ingrese el Apellido: ");
		socio.setApellido(scan.nextLine());
		System.out.println("Ingrese el Direccion: ");
		socio.setDireccion(scan.nextLine());
		System.out.println("Ingrese el Dni: ");
		socio.setDni(scan.nextLine());
		System.out.println("Ingrese el Poblacion: ");
		socio.setPoblacion(scan.nextLine());
		System.out.println("Ingrese el Provincia: ");
		socio.setProvincia(scan.nextLine());
		
		BaseDeDatos.insertarSocio(socio);
		
	}

}

