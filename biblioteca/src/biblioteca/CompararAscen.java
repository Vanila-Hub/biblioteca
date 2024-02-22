package biblioteca;

import java.util.Comparator;

public class CompararAscen implements Comparator<Prestamo>{

	@Override
	public int compare(Prestamo o1, Prestamo o2) {
		return o1.getLibro().getTitulo().compareTo(o2.getLibro().getTitulo());
	}
}