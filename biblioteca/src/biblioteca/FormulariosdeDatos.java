package biblioteca;

import java.time.LocalDate;
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
	
	public static Socio  pedirDtaosSocio(Scanner scan) {
		Socio socio = new Socio();
		System.out.println("Ingrese el Nombre: ");
		socio.setNombre(scan.nextLine());
		System.out.println("Ingrese el Apellido: ");
		socio.setApellido(scan.nextLine());
		System.out.println("Ingrese el Direccion: ");
		socio.setDireccion(scan.nextLine());
		System.out.println("Ingrese el Dni: ");
		socio.setDni(scan.nextLine());
		System.out.println("Ingrese el Poblacion: ");
		socio.setPoblacion(scan.nextLine());
		System.out.println("Ingrese el Provincia: ");
		socio.setProvincia(scan.nextLine());
		return socio;
	}
	
	public static void  modificardatosSocio(ArrayList<Socio> socios,Scanner scan) {
		int id = pedirIdSocio(scan);
		for (Socio socio : socios) {
			if (socio.getId()==id) {
				Visor.mostrarSocio(socio);
			}
		}
		BaseDeDatos.modificarSocio(id,socios,scan);
	}
	
	public static int pedirIdSocio(Scanner scan) {
		System.out.println("Introduzca el ID de Socio: ");
		int id = Integer.parseInt(scan.nextLine());
		return id;
	}
	
	public static Prestamo pedirDatosPrestamo(Scanner scan) {
		Prestamo prestamo = new Prestamo();
		int id_Libro = pedirIdLibro(scan);
		int id_Socio =  pedirIdSocio(scan);
		LocalDate fechaActual = LocalDate.now();
		prestamo.setId_Libro(id_Libro);
		prestamo.setId_socio(id_Socio);
		prestamo.setFecha(fechaActual);
		prestamo.setDevuelto(false);
		return prestamo;
	}
}

