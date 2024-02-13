package biblioteca;

import java.util.Scanner;

public class GestorSocios {
	public static void run(Scanner scan) {
		int opcion = 0;
		do {
			Menu m = new Menu();
			m.mostrarMenuSocios();
			switch (opcion) {
			case Menu.INSERTAR_SOCIO:
				System.out.println(Menu.INSERTAR_SOCIO);
				break;
			case Menu.ELIMINAR_SOCIO:
				System.out.println(Menu.ELIMINAR_SOCIO);
				break;
			case Menu.VER_SOCIO:
				System.out.println(Menu.INSERTAR_SOCIO);
				break;
			case Menu.MODIFICAR_SOCIO:
				System.out.println(Menu.VER_SOCIO);
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
}
