import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * La clase Secuencia almacena un serie de
 * números enteros ordenados.
 */


public class Secuencia {
    private final ArrayList<Integer> lista;

    /**
     * Construye una lista a partir de la colección
     * recibida como parámetro
     */
    public Secuencia(ArrayList<Integer> otra) {
        if (otra == null) {
            throw new IllegalArgumentException("el parámetro otra está sin inicializar");
        }

        lista = new ArrayList<>(otra);
        Collections.sort(lista);

    }

    /**
     * accesor para la secuencia ArrayList almacenada
     * devuelve  una copia, no el propio original. Para ello
     * crea una nueva colección de enteros y vuelve a utilizar addAll()
     */

    public ArrayList<Integer> getSecuencia() {
        ArrayList<Integer> copia = new ArrayList<>();
        copia.addAll(lista);
        return copia;
    }

    /**
     * Obtiene la fusión (la unión) de dos listas
     * de números ordenadas, la represetnada por el atributo lista y
     * la representada por el parámetro otra
     */
    public ArrayList<Integer> fusionarCon(ArrayList<Integer> otra) {
        if (otra == null) {
            throw new IllegalArgumentException("el parámetro otra está sin inicializar");
        }

        ArrayList<Integer> union = getSecuencia();
        union.addAll(otra);
        //En este caso uso el método sort() de la clase ArrayList
        union.sort(null);
        return union;

    }


    /**
     * Obtiene la intersección de lista y el parámetro otra. La  intersección
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public ArrayList<Integer> interseccionCon(ArrayList<Integer> otra) {
        if (otra == null) {
            throw new IllegalArgumentException("el parámetro otra está sin inicializar");
        }
        //Inicializamos la intersección con los elementos de lista, esta vez sin usar getSecuencia() (aunque valdría usarlo).
        ArrayList<Integer> interseccion = new ArrayList<>(lista);
        interseccion.retainAll(otra);
        //Para eliminar repetidos uso la función eliminarDuplicados()
        return eliminarDuplicados(interseccion);


    }

    /**
     * Elimina los duplicados de una lista
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista) {
        //OJO: El parámetro se llama lista, igual que el atributo
        //No quiero tocar para nada this.lista. Trabajaré siempre con la lista parámetro. No usaré this

        //Eliminamos los duplicados usando un objeto hashSet
        HashSet<Integer> conjunto = new HashSet<>();
        conjunto.addAll(lista);
        //Ahora borramos el contenido de lista
        lista.clear();
        //Volvemos a pasar los elementos del conjunto a la lista, ya sin duplicados
        lista.addAll(conjunto);
        return lista;
    }


    /**
     * Representación textual de la secuencia guardada
     * por el objeto actual
     */
    public String toString() {
        return lista.toString();
    }

}
