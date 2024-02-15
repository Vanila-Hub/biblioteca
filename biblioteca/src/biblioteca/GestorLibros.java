package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static GestorBBDD BaseDeDatos = new GestorBBDD();
	static void run(Scanner scan) {
				int opcion = 0;
				do {
					Menu m = new Menu();
					m.mostrarMenuLibros();
					opcion = Integer.parseInt(scan.nextLine());
					
					switch (opcion) {
					case Menu.INSERTAR_LIBRO:
						insertarLibro(scan);
						break;
					case Menu.ELIMINAR_LIBRO:
						eliminarLibro(scan);
						break;
					case Menu.MODIFICAR_LIBRO:
						modificarLibro(scan);
						break;
					case Menu.VER_LIBROS:
						verLibros(scan);
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
		}

	public static void verLibros(Scanner scan) {
		libros =  BaseDeDatos.verLibros(libros);		
	}

	private static void modificarLibro(Scanner scan) {
		FormulariosdeDatos.modificardatosLibro(libros, scan);
	}

	private static void eliminarLibro(Scanner scan) {
		int id = FormulariosdeDatos.pedirIdLibro(scan);
		BaseDeDatos.eliminarLibro(id);
	}
	
	private static void insertarLibro(Scanner scan) {
			Libro libro = FormulariosdeDatos.pedirDtaosLibro(scan);
			BaseDeDatos.insertarLibro(libro);
	}
}

