import java.util.HashSet;

/**
 * Clase AppTesauro -  incluye el método main()
 * Arranca la aplicación
 */
public class AppTesauro {

    /**
     *
     */
    public static void main(String[] args) {
        Tesauro tesauro = new Tesauro();
        tesauro.añadirSinonimo("obeso gordo");
        tesauro.añadirSinonimo("magnífico colosal estupendo");
        tesauro.añadirSinonimo("delgado enjuto fino flaco");
        tesauro.añadirSinonimo("delegar encargar encomendar facultar");
        tesauro.añadirSinonimo("excelente estupendo maravillos genial");
        tesauro.escribirTesauro();

        HashSet<String> borradas = tesauro.borrarSinonimo("estupendo");
        System.out.println("Palabras con el sinónimo 'estupendo' que borramos:");
        System.out.println(borradas.toString());

        System.out.println("El tesauro tras el borrado queda ");
        tesauro.escribirTesauro();

    }
}
