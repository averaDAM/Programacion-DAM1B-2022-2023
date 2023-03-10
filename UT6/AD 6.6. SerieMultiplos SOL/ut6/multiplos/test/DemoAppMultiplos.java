package ut6.multiplos.test;

import ut6.multiplos.modelo.SerieMultiplos;

public class DemoAppMultiplos {

    public static void main(String[] args) {
        SerieMultiplos serie = new SerieMultiplos();
        serie.añadirEntrada(2);
        serie.añadirEntrada(7);
        serie.añadirEntrada(4);
        serie.añadirEntrada(5);

        serie.escribirMap();

        int borrados = serie.borrarMultiplo(20);
        System.out.println("\nAl borrar el 20 de los múltiplos, se borran  " + borrados);
        serie.escribirMap();
    }
}
