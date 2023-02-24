/**
 * Clase para probar la aplicación
 */
public class AppLibreria {
    /**
     *
     * @param args se espera el nombre de la librería
     */
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Error de sintaxis:\n" +
                    "java AppLibreria <nombre-libreria>");
        }
        else{
            Libreria miLibreria = new Libreria(args[0]);

            //Añadimos algunos libros de prueba
            //Guardando el libro creado en una variable y luego añadiéndolo a la librería
            Libro l = new Libro("La historia interminable","Michael Ende",312);
            miLibreria.addLibro(l);
            //Creando el libro al vuelo en la llamada a añadir
            miLibreria.addLibro(new Libro("Fundación","Isaac Asimov", 250));
            miLibreria.addLibro(new Libro("El fin de la eternidad","Isaac Asimov", 290));
            miLibreria.addLibro(new Libro("O lapis do carpinteiro","Manuel Rivas", 270));
            miLibreria.addLibro(new Libro("El árbol de la ciencia","Pío Baroja", 410));
            miLibreria.addLibro(new Libro("Cánticos de la lejana tierra","Arthur C. Clark", 366));

            System.out.println(miLibreria);

            separador();
            System.out.println("Prestamos el libro Fundación: ");
            miLibreria.prestarTitulo("Fundación");
            System.out.println(miLibreria);

            separador();
            System.out.println("Intentamos prestarlo de nuevo: ");
            miLibreria.prestarTitulo("Fundación");

            separador();
            System.out.println("Intentamos prestar un libro no existente: ");
            miLibreria.prestarTitulo("Trafalgar");

            separador();
            System.out.println("Borramos los libros de Belén Esteban");
            miLibreria.borrarLibrosDe("Belén Esteban");
            System.out.println("Menos mal...");

            separador();
            System.out.println("Borramos los libros de Isaac Asimov");
            miLibreria.borrarLibrosDe("Isaac Asimov");
            System.out.println(miLibreria.toString());
        }
    }

    private static void separador(){
        System.out.println(" ----------------------------------------- \n");
    }
}
