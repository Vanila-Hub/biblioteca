package biblioteca;

import java.util.ArrayList;

public class Visor {
	public static void mostrarLibros(ArrayList<Libro> Libros) {
		System.out.println("\n Libros:");
		System.out.print("\t");
		for (Libro libro : Libros) {
			System.out.println("|_ _ _ " + libro.toString());
			System.out.print("\t");
		}
		System.out.print("\n");
	}
	public static void mostrarLibro(Libro Libro) {
		System.out.println("|_ _ _ " + Libro.toString());
	}
	public static void mostrarMensjae(String msg) {
		
	}
	public static void mostrarSocios(ArrayList<Socio> socios) {
		System.out.println("\n Socios:");
		System.out.print("\t");
		for (Socio socio : socios) {
			System.out.println("|_ _ _ " + socio.toString());
			System.out.print("\t");
		}
	}
	public static void mostrarSocio(Socio socio) {
		System.out.println("|_ _ _ " + socio.toString());
		System.out.println("\t");
	}
	
	public static void mostrarPrestamosNoDevueltos(ArrayList<Prestamo> prestamos) {
		System.out.println("\n Prestamos No Devueltos:");
		System.out.print("\t");
		for (Prestamo prestamo : prestamos) {
			System.out.println("|_ _ _ " + prestamo.toString());
			System.out.print("\t");
		}
		System.out.print("\n");
	}
	public static void mostrarPrestamosSocio(ArrayList<Prestamo> prestamos) {
			for (Prestamo prestamo : prestamos) {
				System.out.println("|_ _ _ " + prestamo.toString());
				System.out.print("\t");
			}
			System.out.print("\n");
	}
}