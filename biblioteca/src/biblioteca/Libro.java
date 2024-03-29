package biblioteca;

public class Libro {
	private int id = 0;
	private String titulo;
	private String autor;
	private int num_pag = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNum_pag() {
		return num_pag;
	}
	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", num_pag=" + num_pag + "]";
	}
	
}
