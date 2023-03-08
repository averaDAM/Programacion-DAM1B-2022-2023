package ut6.lnombres.test;

import ut6.lnombres.modelo.ListaNombres;

/**
 * Añadida al proyecto de partida para probar la clase ListaNombres
 */
public class AppListaNombres {
    public static void main(String[] args) {
        ListaNombres lista = new ListaNombres();

        lista.añadirNombre("LUis");
        lista.añadirNombre("Luisa");
        lista.añadirNombre("PRUEba3");
        lista.añadirNombre("ana");
        lista.añadirNombre("eJEMPLO_14");
        lista.añadirNombre("ejemplo1");
        lista.añadirNombre("pepe");
        lista.añadirNombre("prueba2.2");

        lista.printLista();
    }
}
