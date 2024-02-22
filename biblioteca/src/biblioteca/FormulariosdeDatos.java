package biblioteca;

import java.sql.Date;
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
	
	public static String pedirTituloLibro(Scanner scan) {
		System.out.println("Introduzca el titulo de Libro: ");
		String titulo =scan.nextLine();
		return titulo;
	}
	
	public static String pedirAutorLibro(Scanner scan) {
		System.out.println("Introduzca el Autor de Libro: ");
		String autor =scan.nextLine();
		return autor;
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
		Menu m = new Menu();
		m.mostrarOpcionesPrestamo();
		int opcion = Integer.parseInt(scan.nextLine());
		
		switch (opcion) {
		case Menu.PRESTAMO_POR_ID:
			int id_Libro = pedirIdLibro(scan);
			int id_Socio =  pedirIdSocio(scan);
			String fechaActual = String.valueOf(LocalDate.now());
			prestamo.setLibro(GestorBBDD.getLibroConId(id_Libro));
			prestamo.setSocio(GestorBBDD.getSocioId(id_Socio));
			prestamo.setFecha(fechaActual);
			prestamo.setDevuelto(false);
			break;
			
		case Menu.PRESTAMO_POR_TITULO_DNI:
			Socio socio = new Socio();
			Libro libro = new Libro();
			String dniSocio = pedirDNISocio(scan);
			String tituloLibro = pedirTituloLibro(scan);
			
			socio = GestorBBDD.getSocioDNI(dniSocio);
			libro = GestorBBDD.getLibroTitulo(tituloLibro);
			
			int idLibro = libro.getId();
			int idSocio =  socio.getId();
			
			String fecha_Actual = String.valueOf(LocalDate.now());
			prestamo.setLibro(GestorBBDD.getLibroConId(idLibro));
			prestamo.setSocio(GestorBBDD.getSocioId(idSocio));
			prestamo.setFecha(fecha_Actual);
			prestamo.setDevuelto(false);
			break;
		default:
			break;
		}
		return prestamo;
	}
	public static String pedirDNISocio(Scanner scan) {
		System.out.println("Introduzca el Dni del Socio: ");
		String socio =scan.nextLine();
		return socio;
	}
}

