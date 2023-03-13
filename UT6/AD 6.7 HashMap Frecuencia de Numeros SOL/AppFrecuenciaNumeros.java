/**
 * Clase añadida para probar FrecuenciaNumeros
 */
public class AppFrecuenciaNumeros {
    public static void main(String[] args) {
        FrecuenciaNumeros fn = new FrecuenciaNumeros();
        fn.cargarDeFichero();

        fn.listarNumeros();
        fn.listarFrecuencias();
    }
}
