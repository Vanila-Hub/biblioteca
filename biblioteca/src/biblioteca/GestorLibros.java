package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {
	static ArrayList<Libro> libros = new ArrayList<Libro>();
	static GestorBBDD BaseDeDatos = new GestorBBDD();
	
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
						libros =  BaseDeDatos.verLibros(libros);
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
		}

	private static void modificarLibro(Scanner scan) {
		System.out.println("Introduzca el ID de socio a Modifiar: ");
		int id = Integer.parseInt(scan.nextLine());
		BaseDeDatos.modificarLibro(id,libros,scan);
	}

	private static void eliminarLibro(Scanner scan) {
		System.out.println("Indoduzca el id del Libro a borrar: ");
		int id = Integer.parseInt(scan.nextLine());
		BaseDeDatos.eliminarLibro(id);
	}

	private static void insertarLibro(Scanner scan) {
			Libro libro = new Libro();
			System.out.println("Ingrese el Titlulo: ");
			libro.setTitulo(scan.nextLine());
			System.out.println("Ingrese el Autor: ");
			libro.setAutor(scan.nextLine());
			System.out.println("Ingrese el Num de paginas: ");
			libro.setNum_pag(Integer.parseInt(scan.nextLine()));
			BaseDeDatos.insertarLibro(libro);
	}
}

