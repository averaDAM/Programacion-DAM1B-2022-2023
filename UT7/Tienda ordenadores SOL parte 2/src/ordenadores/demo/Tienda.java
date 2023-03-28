package ordenadores.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author
 */
public class Tienda {

    private String nombre;
    private ArrayList<Ordenador> ordenadores;

    /**
     * Constructor
     */
    public Tienda(String nombre) {
        this.nombre = nombre;
        ordenadores = new ArrayList<>();
    }

    /**
     * Añade un ordenador a la tienda
     */
    public void addOrdenador(Ordenador ordenador) {
        ordenadores.add(ordenador);
    }

    /**
     * Cuenta la cantidad de portátiles
     */
    public int cuantosPortatiles() {
        int numPortatiles = 0;
        for (Ordenador ord : ordenadores) {
            if(ord instanceof Portatil)
                numPortatiles++;
        }
        return numPortatiles;
    }

    /**
     * Devuelve el conjunto de códigos de ordenador más baratos Haz un solo bucle
     * para calcular esto
     */
    public HashSet<String> masBaratos() {
        //Creamos el set de retorno
        HashSet<String> setMasBaratos = new HashSet<>();
        //Inicializamos el precio mínimo al del primer ordenador
        //Valdría también inicializarlo a Double.MAX_VALUE (el valor más alto que cabe en un double)
        double precioMin = ordenadores.get(0).getPrecio();

        /*
           Recorremos la lista de ordenadores. Y por cada uno
           Si su precio es menor que el precioMin, limpiamos el set de retorno y añadimos el código del ordenador
           Si su precio es igual al mínimo, sólo lo añadimos, sin limpiar el set
         */
        for (Ordenador ord : ordenadores) {
            if(ord.getPrecio()<precioMin){
                precioMin = ord.getPrecio();
                setMasBaratos.clear();
                setMasBaratos.add(ord.getCodigo());
            }
            else if(ord.getPrecio() == precioMin){
                setMasBaratos.add(ord.getCodigo());
            }
        }

        return setMasBaratos;
    }

    /**
     * Borra de la tienda los ordenadores más baratos
     */
    public void borrarMasBaratos() {
        HashSet<String> setMasBaratos = masBaratos();

        /*
        Vamos recorriendo la lista de ordenadores, y para cada uno, comprobamos si su
        código está dentro del setMasBaratos. Si es así lo borramos
         */

        //Como vamos a borrar, no puedo usar un for mejorado. Uso un iterador
        Iterator<Ordenador> itOrdenadores = ordenadores.iterator();
        while (itOrdenadores.hasNext()) {
            Ordenador ord = itOrdenadores.next();
            if(setMasBaratos.contains(ord.getCodigo())){
                itOrdenadores.remove();
            }
        }

    }

    /**
     * Representación textual de la tienda
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Tienda: " + nombre + "\n\n");
        for (Ordenador ord : ordenadores) {
            sb.append(ord.toString() + "\n");
            //El toString anterior es polimórfico:
            //Se ejecutará el toString de Portatil o el de Sobremesa dependiendo del tipo de ordenador que corresponda
        }
        return sb.toString();
    }

}
