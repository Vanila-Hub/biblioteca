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
        public static final int DEVOLVER_LIBRO = 2;
        public static final int CONSUL_PREST_NO_DEVUELTOS = 3;
        public static final int CONSUL_PRES_SOCIO = 4;
        public static final int CONSULTAR_DISPONIBILIDAD_LIBRO = 5;
        
        public static final int CONSULTAR_DISPONIBILIDAD_DE_UN_LIBRO_POR_ID = 1;
        public static final int CONSULTAR_LIBRO_POR_TITULO = 2;
        public static final int CONSULTAR_LIBRO_POR_AUTOR = 3;

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
            System.out.println(MODIFICAR_SOCIO + ". Modificar Socio");
            System.out.println(SALIR + ". Salir");
        }

        public void mostrarMenuPrestamos() {
        	System.out.println("Seleccione una opción:");
        	System.out.println(REALIZAR_PRESTAMO + ". Realizar préstamo");
        	System.out.println(DEVOLVER_LIBRO + ". Devolver libro");
        	System.out.println(CONSUL_PREST_NO_DEVUELTOS + ". Consultar préstamos no devueltos");
        	System.out.println(CONSUL_PRES_SOCIO + ". Consultar préstamos de un socio");
        	System.out.println(CONSULTAR_DISPONIBILIDAD_LIBRO + ". Consultar disponibilidad de un libro");
            System.out.println(SALIR + ". Salir");
        }
        
        public void mostrarMenuDisponibilidad() {
        	   System.out.println("Seleccione una opción:");
               System.out.println(CONSULTAR_DISPONIBILIDAD_DE_UN_LIBRO_POR_ID + " Consultar disponibilidad de un libro por ID");
               System.out.println(CONSULTAR_LIBRO_POR_TITULO + " Consultar disponibilidad de un libro por Titulo");
               System.out.println(SALIR + ". Salir");
        }

}
