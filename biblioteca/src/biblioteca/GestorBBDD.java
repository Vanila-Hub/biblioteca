package biblioteca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public Libro getLibro(int id) {
		String consul = "SELECT * FROM libros WHERE id = ?";
		
		return null;
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
		Visor.mostrarLibros(libros);
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
				st.setInt(1,prestamo.getId_Libro());
				st.setInt(2,prestamo.getId_socio());
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

		public static void eliminarPrestamo(int id) {
			try {
				String consul = "DELETE FROM prestamos WHERE id_libro = ?";
				Connection cn = conectar();
				PreparedStatement st = cn.prepareStatement(consul);
				st.setInt(1, id);
				st.executeUpdate();
				st.close();
				System.out.println("Prestamo con Libro de ID " + id + " Devuelto!");
				Conector.CERRAR();
			} catch (Exception e) {
				System.err.println(e);
			}
		 }
		
		public void PresNoDevueltos(Scanner scan, ArrayList<Prestamo> prestamos) {
			try {
				String consulta = "SELECT * FROM prestamos WHERE devuelto=0";
				Connection cn = Conector.conectar();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(consulta);
				while (rs.next()) {
					Prestamo prestamo = new Prestamo();
					prestamo.setDevuelto(rs.getBoolean("devuelto"));
					prestamo.setFecha(String.valueOf(rs.getDate("fecha")));
					prestamo.setId_Libro(rs.getInt("id_libro"));
					prestamo.setId_socio(rs.getInt("id_socio"));
					prestamos.add(prestamo);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			Visor.mostrarPrestamosNoDevueltos(prestamos);
		 }

		public void PresDeSocio(Scanner scan, ArrayList<Prestamo> prestamos) {
			try {
				int id = FormulariosdeDatos.pedirIdSocio(scan);
				String consulta = "SELECT * FROM prestamos WHERE id_socio="+id;
				Connection cn = Conector.conectar();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(consulta);
				while (rs.next()) {
					Prestamo prestamo = new Prestamo();
					prestamo.setDevuelto(rs.getBoolean("devuelto"));
					prestamo.setFecha(String.valueOf(rs.getDate("fecha")));
					prestamo.setId_Libro(rs.getInt("id_libro"));
					prestamo.setId_socio(rs.getInt("id_socio"));
					prestamos.add(prestamo);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			Visor.mostrarPrestamosSocio(prestamos);
		 }
		public void ConsulDispoLibro(Scanner scan) {
			ArrayList<Libro> libros= new ArrayList<Libro>();
			String consul = "SELECT * FROM libros A WHERE NOT EXISTS(SELECT * FROM prestamos B WHERE A.id = B.id_libro)";
			System.out.println("Estos Son los libros que no han sido prestados ningun socio");
			verLibros(libros, consul);
		}
	}
