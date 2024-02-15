package biblioteca;

import java.sql.Date;
import java.time.LocalDate;

public class Prestamo {
	private int id_Libro = 0;
	private int id_socio = 0;
	private String fecha;
	private boolean devuelto= false;
	
	 public void setId_Libro(int id_Libro) {
	        this.id_Libro = id_Libro;
	    }
	    
	    public void setId_socio(int id_socio) {
	        this.id_socio = id_socio;
	    }
	    
	    public void setFecha(String fechaActual) {
	        this.fecha = fechaActual;
	    }
	    
	    public void setDevuelto(boolean devuelto) {
	        this.devuelto = devuelto;
	    }
	    
	    // Getters
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
