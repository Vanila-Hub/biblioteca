package biblioteca;

import java.sql.Date;

public class Prestamo {
	private final int id_Libro = 0;
	private final int id_socio = 0;
	private final String fecha ="";
	private final boolean devuelto= false;
	
	public int getId_Libro() {
		return id_Libro;
	}
	public int getId_socio() {
		return id_socio;
	}
	public String getFecha() {
		return fecha;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	
	@Override
	public String toString() {
		return "Prestamo [id_Libro=" + id_Libro + ", id_socio=" + id_socio + ", fecha=" + fecha + ", devuelto="
				+ devuelto + "]";
	}
}
