package biblioteca;

import java.sql.Date;
import java.time.LocalDate;

public class Prestamo{
	private Libro libro;
	private Socio socio;
	private String fecha;
	private boolean devuelto= false;
	
	
	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Socio getSocio() {
		return socio;
	}


	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public boolean isDevuelto() {
		return devuelto;
	}


	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}


	@Override
	public String toString() {
		return "Prestamo [libro=" + libro.getTitulo() + ", socio=" + socio.getDni() + ", fecha=" + fecha + ", devuelto=" + devuelto + "]";
	}
	

}
