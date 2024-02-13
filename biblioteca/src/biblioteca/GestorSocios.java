package biblioteca;

import java.sql.Connection;
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
				//System.out.println(Menu.INSERTAR_SOCIO);
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
			System.out.println(socio);
		}
		return socios;
	}
}

