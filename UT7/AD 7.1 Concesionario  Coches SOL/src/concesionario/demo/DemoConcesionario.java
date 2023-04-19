package concesionario.demo;

import concesionario.modelo.Concesionario;

/**
 * Clase DemoConcesionario 
 *
 */

public class DemoConcesionario {

    private Concesionario con;

    /**
     * Constructor de la clase DemoConcesionario
     */
    public DemoConcesionario(String nombre) {
        con = new Concesionario(nombre);
        con.leerConcesionarioDeFicheroTexto();

    }

    /**
     *
     */
    public void demoListarCoches() {
        con.listarCoches();

    }

    /**
     *
     */
    public void demoAvanzar() {
        con.avanzarTodos();

    }

    /**
     *
     */
    public void demoBorrarDeConductor(String conductor) {
        con.borrarDeConductor(conductor);
    }

    /**
     *
     */
    public void demoBorrarTaxis() {

        con.borrarTaxis();

    }

    /**
     *
     */
    public void demoListarOrdenadoConductor() {

        con.listarOrdenadoConductor();

    }

    /**
     * Aceptar como argumento el nombre del concesionario y -
     * listar el concesionario -
     * avanzar todos los coches y volver a listar -
     * borrar los del conductor "Jesus" -
     * listar el concesionario -
     * borrar los taxis -
     * listar el concesionario
     * mostrar el listado ordenado por conductor -
     */
    public static void main(String[] args) {
        //Comprobamos que se recibe un argumento
        if(args.length!=1){
            System.out.println("Error en nº argumentos\n" +
                    "Sintaxis: java DemoConcesionario <nombre-\n" +
                    "concesionario>");
            System.exit(-1);
        }

        String nombre = args[0];
        DemoConcesionario dc = new DemoConcesionario(nombre);
        dc.demoListarCoches();

        //Avanzamos y volvemos a listar
        System.out.println("AVANZAMOS TODOS: ");
        dc.demoAvanzar();
        dc.demoListarCoches();

        //Borramos los de Jesús
        System.out.println("Borramos los vehículos del conductor Jesús");
        dc.demoBorrarDeConductor("Jesus");
        dc.demoListarCoches();

        //Borramos los taxis
        System.out.println("Borramos los Taxis");
        dc.demoBorrarTaxis();
        dc.demoListarCoches();

        //Mostrar ordenados por conductor
        System.out.println("ORDENADOS POR CONDUCTOR");
        dc.demoListarOrdenadoConductor();

    }
}
