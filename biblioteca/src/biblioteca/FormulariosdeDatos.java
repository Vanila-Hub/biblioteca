package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class FormulariosdeDatos {
	static GestorBBDD BaseDeDatos = new GestorBBDD();
	public static Libro  pedirDtaosLibro(Scanner scan) {
		Libro libro = new Libro();
		System.out.println("Ingrese el Titlulo: ");
		libro.setTitulo(scan.nextLine());
		System.out.println("Ingrese el Autor: ");
		libro.setAutor(scan.nextLine());
		System.out.println("Ingrese el Num de paginas: ");
		libro.setNum_pag(Integer.parseInt(scan.nextLine()));
		return libro;
	}
	public static void  modificardatosLibro(ArrayList<Libro> libros,Scanner scan) {
		int id = pedirIdLibro(scan);
		for (Libro libro : libros) {
			if (libro.getId()==id) {
				Visor.mostrarLibro(libro);
			}
		}
		BaseDeDatos.modificarLibro(id,libros,scan);
	}
	public static int pedirIdLibro(Scanner scan) {
		System.out.println("Introduzca el ID de Libro: ");
		int id = Integer.parseInt(scan.nextLine());
		return id;
	}
}

