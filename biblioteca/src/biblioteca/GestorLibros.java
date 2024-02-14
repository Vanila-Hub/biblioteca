package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {

//	public static void main(String[] args) {
//		run(null);
//
//	}

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
						
						break;
					case Menu.MODIFICAR_LIBRO:
						
						break;
					case Menu.VER_LIBROS:
						libros =  BaseDeDatos.verLibros(libros);
						
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
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

