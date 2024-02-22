package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorIterador {
	public GestorIterador() {
		// TODO Auto-generated constructor stub
	}

	public void iterar(ArrayList<Libro> libros, String titLibro) {
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			
			if (libro.getTitulo().contains(titLibro)) {
				System.out.println(libro);
			}
			
		}
	}
}
