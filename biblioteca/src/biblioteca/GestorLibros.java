package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static GestorBBDD baseDeDatos = new GestorBBDD();
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
					case Menu.BUSCARLIBRO:
						buscarLibro(scan);
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
		}

	private static void buscarLibro(Scanner scan) {
		String titLibro = FormulariosdeDatos.pedirTituloLibro(scan);
		String consulta = "SELECT * FROM libros";
		libros =  baseDeDatos.verLibros(libros,consulta);
		GestorIterador it = new GestorIterador();
		it.iterar(libros,titLibro);
		
	}

	public static void verLibros(Scanner scan) {
		String consulta = "SELECT * FROM libros";
		libros =  baseDeDatos.verLibros(libros,consulta);
		Visor.mostrarLibros(libros);
	}

	private static void modificarLibro(Scanner scan) {
		FormulariosdeDatos.modificardatosLibro(libros, scan);
	}

	private static void eliminarLibro(Scanner scan) {
		int id = FormulariosdeDatos.pedirIdLibro(scan);
		baseDeDatos.eliminarLibro(id);
	}
	
	private static void insertarLibro(Scanner scan) {
			Libro libro = FormulariosdeDatos.pedirDtaosLibro(scan);
			baseDeDatos.insertarLibro(libro);
	}
	
}

