package biblioteca;

import java.util.Scanner;

public class GestorLibros {
	public static void run(Scanner scan) {
		int opcion = 0;
		do {
			Menu m = new Menu();
			m.mostrarMenuLibros();
			switch (opcion) {
			case Menu.INSERTAR_LIBRO:
				
				break;
			case Menu.ELIMINAR_LIBRO:
				
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
}
