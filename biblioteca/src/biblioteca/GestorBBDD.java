package biblioteca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorBBDD extends Conector{
	
	public static void insertarLibro(Libro libro) {
		try {
			Connection cn = conectar();
			String consul = "INSERT INTO libros (titulo, autor,num_pag) VALUES (?, ?, ?)";
			PreparedStatement st = cn.prepareStatement(consul);
			st.setString(1,libro.getTitulo());
			st.setString(2,libro.getAutor());
			st.setInt(3,libro.getNum_pag());
			st.executeUpdate();
			st.close();
			System.out.println("Libro Añadido \n de Titulo " + libro.getTitulo());
			CERRAR();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void eliminarLibro(int id) {
		try {
			String consul = "DELETE FROM libros WHERE Id = ?";
			Connection cn = conectar();
			PreparedStatement st = cn.prepareStatement(consul);
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
			System.out.println("Libro con ID :" + id + " Eliminado!");
			CERRAR();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void modificarLibro(int id,ArrayList<Libro> libros,Scanner scan) {
		for (Libro libro : libros) {
			if(libro.getId()==id) {
				
				System.out.println("Ingrese Nuevo el Titulo para " + libro.getTitulo() + ": ");
				libro.setTitulo(scan.nextLine());
				System.out.println("Ingrese Nuevo el Autor: ");
				libro.setAutor(scan.nextLine());
				System.out.println("Ingrese el Nuevo Numero de paginas: ");
				libro.setNum_pag(Integer.parseInt(scan.nextLine()));
				
				try {
					Connection cn = conectar();
					String consul = "UPDATE libros SET titulo=?, autor=?,num_pag=? WHERE libros.id = ?";
					PreparedStatement st = cn.prepareStatement(consul);
					st.setString(1, libro.getTitulo());
					st.setString(2, libro.getAutor());
					st.setInt(3, libro.getNum_pag());
					st.setInt(4, libro.getId());
					st.executeUpdate();
					st.close();
					System.out.println("Libro Actualizado");
					Conector.CERRAR();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
	}

	public ArrayList<Libro> verLibros(ArrayList<Libro> libros,String consulta){
		libros = new ArrayList<Libro>();
		try {
			Connection cn = conectar();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setAutor(rs.getString("autor"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setId(rs.getInt("id"));
				libro.setNum_pag(rs.getInt("num_pag"));
				libros.add(libro);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return libros;
	}
	
	public static ArrayList<Socio> verSocios(ArrayList<Socio> socios) {
		socios = new ArrayList<Socio>();
		try {
			String consulta = "SELECT * FROM socios";
			Connection cn = Conector.conectar();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Socio socio = new Socio();
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setDni(rs.getString("dni"));
				socio.setId(rs.getInt("id"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				socios.add(socio);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		Visor.mostrarSocios(socios);
		return socios;
	}
	public void insertarSocio(Socio socio) {
		try {
			Connection cn = conectar();
			String consul = "INSERT INTO socios (nombre, apellido,direccion, poblacion,provincia, dni) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st = cn.prepareStatement(consul);
			st.setString(1,socio.getNombre());
			st.setString(2,socio.getApellido());
			st.setString(3,socio.getDireccion());
			st.setString(4,socio.getPoblacion());
			st.setString(5,socio.getProvincia());
			st.setString(6,socio.getDni());
			st.executeUpdate();
			st.close();
			System.out.println("Socio Añadido \n !Bienvenido! " + socio.getNombre());
			Conector.CERRAR();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void eliminarSocio(int id) {
		try {
			String consul = "DELETE FROM Socios WHERE Id = ?";
			Connection cn = conectar();
			PreparedStatement st = cn.prepareStatement(consul);
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
			System.out.println("Socio con ID :" + id + " Eliminado!");
			Conector.CERRAR();
		} catch (Exception e) {
			System.err.println(e);
		}
	 }
	
	public void modificarSocio(int id, ArrayList<Socio> socios, Scanner scan) {
		for (Socio socio : socios) {
			if(socio.getId()==id) {
				System.out.println("Ingrese Nuevo el Nombre para " + socio.getNombre() + ": ");
				socio.setNombre(scan.nextLine());
				System.out.println("Ingrese Nuevo el Apellido: ");
				socio.setApellido(scan.nextLine());
				System.out.println("Ingrese Nuevo el Direccion: ");
				socio.setDireccion(scan.nextLine());
				System.out.println("Ingrese Nuevo el Dni: ");
				socio.setDni(scan.nextLine());
				System.out.println("Ingrese Nuevo el Poblacion: ");
				socio.setPoblacion(scan.nextLine());
				System.out.println("Ingrese Nuevo el Provincia: ");
				socio.setProvincia(scan.nextLine());
				try {
					Connection cn = conectar();
					String consul = "UPDATE socios SET nombre = ?,apellido = ?, direccion = ?,poblacion = ?, provincia = ?, dni = ? WHERE socios.id = ?";
					PreparedStatement st = cn.prepareStatement(consul);
					st.setString(1, socio.getNombre());
					st.setString(2, socio.getApellido());
					st.setString(3, socio.getDireccion());
					st.setString(4, socio.getPoblacion());
					st.setString(5, socio.getProvincia());
					st.setString(6, socio.getDni());
					st.setInt(7, socio.getId());
					st.executeUpdate();
					st.close();
					System.out.println("Socio Actualizado");
					Conector.CERRAR();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
	}

	 public void realizarPrestamo(Prestamo prestamo) {
			try {
				Connection cn = conectar();
				String consul = "INSERT INTO prestamos (id_libro, id_socio, fecha, devuelto) VALUES (?, ?, ?, ?);";
				PreparedStatement st = cn.prepareStatement(consul);
				st.setInt(1,prestamo.getLibro().getId());
				st.setInt(2,prestamo.getSocio().getId());
				st.setDate(3,Date.valueOf(prestamo.getFecha()));
				st.setBoolean(4,prestamo.isDevuelto());
				st.executeUpdate();
				st.close();
				System.out.println("Prestamo Añadido");
				CERRAR();
				
			} catch (Exception e) {
				System.err.println(e);
			}
	 }

		public static void eliminarPrestamo(Scanner scan) {
			Libro libro = new Libro();
			String tituloLibro = FormulariosdeDatos.pedirTituloLibro(scan);
			libro = getLibroTitulo(tituloLibro);
			
			try {
				String consul = "UPDATE prestamos A SET A.devuelto = ? WHERE A.id_libro = ?";
				Connection cn = conectar();
				PreparedStatement st = cn.prepareStatement(consul);
				st.setInt(1, 1);
				st.setInt(2, libro.getId());
				st.executeUpdate();
				st.close();
				System.out.println("Prestamo del Libro " + libro.getTitulo() + " Devuelto!");
				Conector.CERRAR();
			} catch (Exception e) {
				System.err.println(e);
			}
		 }
		
		public void PresNoDevueltos(Scanner scan) {
			ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
			try {
				String consulta = "SELECT * FROM prestamos WHERE devuelto=0";
				Connection cn = Conector.conectar();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(consulta);
				while (rs.next()) {
					Prestamo prestamo = new Prestamo();
					prestamo.setDevuelto(rs.getBoolean("devuelto"));
					prestamo.setFecha(String.valueOf(rs.getDate("fecha")));
					prestamo.setSocio(getSocioId(rs.getInt("id_socio")));
					prestamo.setLibro(getLibroConId(rs.getInt("id_libro")));
					prestamos.add(prestamo);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			Visor.mostrarPrestamosNoDevueltos(prestamos);
		 }

		public void PresDeSocio(Scanner scan) {
			ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
			try {
				String dniSocio = FormulariosdeDatos.pedirDNISocio(scan);
				Prestamo prestamo = new Prestamo();
				prestamo.setSocio(GestorBBDD.getSocioDNI(dniSocio));
				String consulta = "SELECT * FROM prestamos WHERE id_socio=? ";
				Connection cn = Conector.conectar();
				PreparedStatement st = cn.prepareStatement(consulta);
				st.setInt(1, prestamo.getSocio().getId());
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					prestamo = new Prestamo();
					prestamo.setDevuelto(rs.getBoolean("devuelto"));
					prestamo.setFecha(String.valueOf(rs.getDate("fecha")));
					prestamo.setSocio(getSocioId(rs.getInt("id_socio")));
					prestamo.setLibro(getLibroConId(rs.getInt("id_libro")));
					prestamos.add(prestamo);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			prestamos.sort(new CompararAscen());
			Visor.mostrarPrestamosSocio(prestamos);
		 }
		public void ConsulDispoLibro(Scanner scan) {
			ArrayList<Libro> libros= new ArrayList<Libro>();
			String consul = "SELECT * FROM libros A WHERE NOT EXISTS(SELECT * FROM prestamos B WHERE A.id = B.id_libro)";
			System.out.println("Libros no prestados a ningun socio:");
			System.out.print("\t");
			verLibros(libros, consul);
		}

		public static Socio getSocioDNI(String dniSocio) {
			String sql = "SELECT * FROM socios WHERE dni = ?";
			Socio socio = new Socio();
			Connection cn = Conector.conectar();
			try {
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, dniSocio);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					socio.setNombre(rs.getString("nombre"));
					socio.setApellido(rs.getString("apellido"));
					socio.setDireccion(rs.getString("direccion"));
					socio.setDni(rs.getString("dni"));
					socio.setId(rs.getInt("id"));
					socio.setPoblacion(rs.getString("poblacion"));
					socio.setProvincia(rs.getString("provincia"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return socio;
		}

		public static Libro getLibroTitulo(String tituloLibro) {
			String sql = "SELECT * FROM libros WHERE titulo = ?";
			Libro libro = new Libro();
			Connection cn = Conector.conectar();
			try {
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, tituloLibro);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					libro.setAutor(rs.getString("autor"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setId(rs.getInt("id"));
					libro.setNum_pag(rs.getInt("num_pag"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libro;
		}
		
		public static ArrayList<Libro> getLibroId(int id, ArrayList<Libro> libros) {
			String sql = "SELECT * FROM libros WHERE id = ?";
			Connection cn = Conector.conectar();
			try {
				PreparedStatement st = cn.prepareStatement(sql);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Libro libro = new Libro();
					libro.setAutor(rs.getString("autor"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setId(rs.getInt("id"));
					libro.setNum_pag(rs.getInt("num_pag"));
					libros.add(libro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libros;
		}
		
		public static Socio getSocioId(int id) {
			String sql = "SELECT * FROM socios WHERE id = ?";
			Connection cn = Conector.conectar();
			Socio socio = new Socio();
			try {
				PreparedStatement st = cn.prepareStatement(sql);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					socio.setNombre(rs.getString("nombre"));
					socio.setApellido(rs.getString("apellido"));
					socio.setDireccion(rs.getString("direccion"));
					socio.setDni(rs.getString("dni"));
					socio.setId(rs.getInt("id"));
					socio.setPoblacion(rs.getString("poblacion"));
					socio.setProvincia(rs.getString("provincia"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return socio;
		}
		
		public static Libro getLibroConId(int id) {
			String sql = "SELECT * FROM libros WHERE id = ?";
			Connection cn = Conector.conectar();
			Libro libro = new Libro();
			try {
				PreparedStatement st = cn.prepareStatement(sql);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					libro.setAutor(rs.getString("autor"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setId(rs.getInt("id"));
					libro.setNum_pag(rs.getInt("num_pag"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libro;
		}
	}
