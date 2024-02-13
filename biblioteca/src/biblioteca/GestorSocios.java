package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSocios {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		run(scan);
	}
	public static void run(Scanner scan) {
		int opcion = 0;
		do {
			Menu m = new Menu();
			m.mostrarMenuSocios();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.INSERTAR_SOCIO:
				insertarSocio(scan);
				break;
			case Menu.ELIMINAR_SOCIO:
				//System.out.println(Menu.ELIMINAR_SOCIO);
				break;
			case Menu.VER_SOCIO:
				verSocios();
				break;
			case Menu.MODIFICAR_SOCIO:
				//System.out.println(Menu.MODIFICAR_SOCIO);
				break;
			default:
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
	
	private static void insertarSocio(Scanner scan) {
		
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
		
		try {
			Connection cn = Conector.conectar();
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
			Conector.CERRAR();
			
			System.out.println("Socio Añadido \n !Bienvenido! " + socio.getNombre());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	private static ArrayList<Socio> verSocios() {
		ArrayList<Socio> socios = new ArrayList<Socio>();
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
		for (Socio socio : socios) {
			System.out.println(socio.toString());
		}
		return socios;
	}
}

