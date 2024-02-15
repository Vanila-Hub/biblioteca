package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPrestamo {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static ArrayList<Socio> socios = new ArrayList<Socio>();
	private Socio socio = new Socio();
	private Libro libro = new Libro();
	private static GestorBBDD baseDeDatos = new GestorBBDD();
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		run(scan);
	}

	private static void run(Scanner scan) {
		int opcion = 0;
		do {
			Menu m = new Menu();
			m.mostrarMenuPrestamos();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.REALIZAR_PRESTAMO:
				realizarPrestamos(scan);
				break;
			case Menu.DEVOLVER_LIBRO:
				
				break;
			case Menu.CONSUL_PREST_NO_DEVUELTOS:
				
				break;
			case Menu.CONSUL_PRES_SOCIO:
				
				break;
			case Menu.CONSULTAR_DISPONIBILIDAD_LIBRO:
				
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}

	private static void realizarPrestamos(Scanner scan) {
		Prestamo prestamo = FormulariosdeDatos.pedirDatosPrestamo(scan);
		baseDeDatos.realizarPrestamo(prestamo);
	}

}
