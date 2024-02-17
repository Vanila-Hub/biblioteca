package biblioteca;

import java.util.Scanner;

public class GestorBiblioteca {

	public static void main(String[] args) {
	run();

	}

	private static void run() {

				int opcion;
				Scanner scan = new Scanner(System.in);
				do {
					Menu m = new Menu();
					m.mostrarMenuPrincipal();
					opcion = Integer.parseInt(scan.nextLine());
					switch (opcion) {
					case Menu.GESTIONAR_LIBROS:
						GestorLibros.run(scan);;
						break;
					case Menu.GESTIONAR_SOCIOS:
						GestorSocios.run(scan);
						break;
					case Menu.GESTIONAR_PRESTAMOS:
						GestorPrestamo.run(scan);
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
	}

}
