package biblioteca;

import java.util.ArrayList;

public class Visor {
	public static void mostrarLibros(ArrayList<Libro> Libros) {
		for (Libro libro : Libros) {
			System.out.println(libro.toString());
		}
	}
	public static void mostrarLibro(Libro Libro) {
		System.out.println(Libro.toString());
	}
	public static void mostrarMensjae(String msg) {
		
	}
	public static void mostrarSocios(ArrayList<Socio> socios) {
		for (Socio socio : socios) {
			System.out.println(socio.toString());
		}
	}
	public static void mostrarSocio(Socio socio) {
		System.out.println(socio.toString());
	}
	
	public static void mostrarPrestamosNoDevueltos(ArrayList<Prestamo> prestamos) {
		for (Prestamo prestamo : prestamos) {
			System.out.println(prestamo.toString());
		}
	}
	public static void mostrarPrestamosSocio(ArrayList<Prestamo> prestamos) {
			for (Prestamo prestamo : prestamos) {
				System.out.println(prestamo.toString());
			}
	}
}