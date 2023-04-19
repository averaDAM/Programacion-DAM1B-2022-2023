package concesionario.modelo; /**
 * Clase Concesionario
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class Concesionario {

    private String nombre;
    private List<Coche> coches;

    /**
     * Constructor de la clase Concesionario
     */
    public Concesionario(String n) {
        coches = new ArrayList<>();
        nombre = n;
    }

    /**
     * acccsor para el nombre del concesionario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Añade un c
     */
    public void añadir(Coche c) {
        if (!coches.contains(c)) {
            coches.add(c);
        } else {
            System.out.println("Coche duplicado: \n" + c);
        }
    }

    /**
     *   obtiene un listado ordenado por nombre de conductor especificando adem�s el
     *   tipo de coche que posee. No se modifica la colección de coches
     */
    public void listarOrdenadoConductor() {
        List<Coche> copia = new ArrayList<>(coches);
        //En este caso, uso una clase anónima que implementa el interfaz Comparator
        copia.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                return o1.getConductor().compareTo(o2.getConductor());
            }
        });


        for (Coche c : copia) {
            System.out.println(c);
        }


    }

    /**
     * Leer del fichero de texto "concesionario.txt" los datos de cada coche
     * y añadirlos al concesionario
     *
     * Con ayuda del método privado parsearLinea()  extraeremos los datos de un coche
     *
     */
    public void leerConcesionarioDeFicheroTexto() {

        Scanner entrada = new Scanner(
                this.getClass().getResourceAsStream("/concesionario.txt"));
        while (entrada.hasNextLine()) {
            String linea = entrada.nextLine();
            Coche coche = parsearLinea(linea);
            añadir(coche);
        }
        entrada.close();

    }

    /**
     *  parsea una línea de texto extrayendo los datos y devolviendo un objeto Coche
     *  El formato de la línea en el fichero ser:
     * 		 tipocoche:conductor:modelo:color  para  tipocoche 'D' (deportivo)
     *       tipocoche:conductor:modelo:color:posx:posy  para  tipocoche 'E' (económico)
     *  	 tipocoche:conductor:modelo:color:posx:posy:plazas  para  tipocoche 'T' (taxi)
     *
     */
    private Coche parsearLinea(String linea) {
        String[] trozos = linea.split(":");


        String tipocoche = trozos[0].trim();
        String conductor = trozos[1].trim();
        String modelo = trozos[2].trim();
        String color = trozos[3].trim();

        if (tipocoche.equals("D")) {
            return new CocheDeportivo(conductor, modelo, color);
        }

        int x = Integer.parseInt(trozos[4].trim());
        int y = Integer.parseInt(trozos[5].trim());

        if (!tipocoche.equals("T")) {
            return new CocheEconomico(conductor, modelo, color, new Point(x, y));
        }

        int plazas = Integer.parseInt(trozos[6].trim());
        return new Taxi(conductor, modelo, color, new Point(x, y), plazas);
    }

    /**
     * Borrar del concesionario los coches del conductor indicado por el
     * parámetro quien
     */
    public void borrarDeConductor(String quien) {
        Iterator<Coche> itCoches = coches.iterator();
        while (itCoches.hasNext()) {
            Coche c = itCoches.next();
            if(c.getConductor().equalsIgnoreCase(quien)){
                itCoches.remove();
            }
        }
    }

    /**
     * listado del concesionario
     */
    public void listarCoches() {
        for (Coche c : coches) {
            System.out.println(c);
        }
    }

    /**
     *
     *  borrar del concesionario los taxis
     */
    public void borrarTaxis() {
        Iterator<Coche> itCoches = coches.iterator();
        while (itCoches.hasNext()) {
            Coche c = itCoches.next();
            if(c instanceof Taxi)
                itCoches.remove();
        }
    }

    /**
     * avanzar todos los coches
     */
    public void avanzarTodos() {
        for (Coche c : coches) {
            c.avanza();
        }
    }

}
