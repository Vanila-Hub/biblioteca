package biblioteca;

import java.util.Comparator;

public class CompararAscen implements Comparator<Libro>{


	@Override
	public int compare(Libro o1, Libro o2) {
		return o2.getTitulo().compareTo(o1.getAutor());
	}

}