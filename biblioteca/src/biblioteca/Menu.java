package biblioteca;

    public class Menu {

        public static final int GESTIONAR_LIBROS = 1;
        public static final int GESTIONAR_SOCIOS = 2;
        public static final int GESTIONAR_PRESTAMOS = 3;
        public static final int SALIR = 0;

        public static final int INSERTAR_LIBRO = 1;
        public static final int ELIMINAR_LIBRO = 2;
        public static final int MODIFICAR_LIBRO = 3;
        public static final int VER_LIBROS = 4;

        public static final int VER_SOCIO = 1;
        public static final int INSERTAR_SOCIO = 2;
        public static final int ELIMINAR_SOCIO = 3;
        public static final int MODIFICAR_SOCIO = 4;
        
        public static final int REALIZAR_PRESTAMO = 1;
        public Menu() {
			// TODO Auto-generated constructor stub
		}
        public void mostrarMenuPrincipal() {
            System.out.println("Seleccione una opción:");
            System.out.println(GESTIONAR_LIBROS + ". Gestionar Libros");
            System.out.println(GESTIONAR_SOCIOS + ". Gestionar Socios");
            System.out.println(GESTIONAR_PRESTAMOS + ". Gestionar Prestamos");
            System.out.println(SALIR + ". Salir");
        }

        public void mostrarMenuLibros() {
            System.out.println("Seleccione una opción:");
            System.out.println(INSERTAR_LIBRO + ". Insertar Libro");
            System.out.println(ELIMINAR_LIBRO + ". Eliminar Libro");
            System.out.println(MODIFICAR_LIBRO + ". Modificar Libro");
            System.out.println(VER_LIBROS + ". Ver Libros");
            System.out.println(SALIR + ". Salir");
        }

        public void mostrarMenuSocios() {
            System.out.println("Seleccione una opción:");
            System.out.println(VER_SOCIO + ". Ver Socio");
            System.out.println(INSERTAR_SOCIO + ". Insertar Socio");
            System.out.println(ELIMINAR_SOCIO + ". Eliminar Socio");
            System.out.println(SALIR + ". Salir");
        }

        public void mostrarMenuPrestamos() {
            System.out.println("Seleccione una opción:");
            System.out.println(REALIZAR_PRESTAMO+".Realizar Prestamo");
            System.out.println(SALIR + ". Salir");
        }
}
