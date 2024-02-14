package biblioteca;

import java.util.Scanner;

public class GestorLibros {

//	public static void main(String[] args) {
//		run(null);
//
//	}

	static void run(Scanner scan) {
				int opcion = 0;
				do {
					Menu m = new Menu();
					m.mostrarMenuLibros();
					opcion = Integer.parseInt(scan.nextLine());
					
					switch (opcion) {
					case Menu.INSERTAR_LIBRO:
						
						break;
					case Menu.ELIMINAR_LIBRO:
						
						break;
					case Menu.MODIFICAR_LIBRO:
						
						break;
					case Menu.VER_LIBROS:
						
						break;
					default:
						break;
					}
				} while (opcion!=Menu.SALIR);
		}
}

