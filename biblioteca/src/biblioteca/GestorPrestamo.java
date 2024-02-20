package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPrestamo {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static ArrayList<Socio> socios = new ArrayList<Socio>();
	private static ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private Socio socio = new Socio();
	private Libro libro = new Libro();
	private static GestorBBDD baseDeDatos = new GestorBBDD();

	public static void run(Scanner scan) {
		int opcion=3;
		do {
			Menu m = new Menu();
			m.mostrarMenuPrestamos();
			
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.REALIZAR_PRESTAMO:
				realizarPrestamos(scan);
				break;
			case Menu.DEVOLVER_LIBRO:
				devolverLibro(scan);
				break;
			case Menu.CONSUL_PREST_NO_DEVUELTOS:
				noDevueltos(scan);
				break;
			case Menu.CONSUL_PRES_SOCIO:
				presSocios(scan);
				break;
			case Menu.CONSULTAR_DISPONIBILIDAD_LIBRO:
				consultarDisponiLibro(scan);
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
	
	private static void consultarDisponiLibro(Scanner scan) {
		baseDeDatos.ConsulDispoLibro(scan);
	}

	private static void presSocios(Scanner scan) {
		baseDeDatos.PresDeSocio(scan);
	}

	private static void noDevueltos(Scanner scan) {
		baseDeDatos.PresNoDevueltos(scan);
	}

	private static void devolverLibro(Scanner scan) {
		baseDeDatos.eliminarPrestamo(scan);
	}

	private static void realizarPrestamos(Scanner scan) {
		Prestamo prestamo = FormulariosdeDatos.pedirDatosPrestamo(scan);
		baseDeDatos.realizarPrestamo(prestamo);
	}

}
