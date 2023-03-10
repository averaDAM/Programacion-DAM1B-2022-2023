package ut6.multiplos.modelo;

import java.util.*;

/**
 * Multimap - Un objeto de esta clase guarda
 * en un map claves String que representan números
 * y múltiplos asociados a esas claves
 * <p>
 * Ejer. AD07
 */

public class SerieMultiplos {

    private HashMap<String, ArrayList<Integer>> mapMultiplos;

    /**
     * Constructor de la clase SeriePotencias
     */
    public SerieMultiplos() {
        mapMultiplos = new HashMap<>();
    }

    /**
     * @param num el nº que será la clave String
     */
    public void añadirEntrada(int num) {
        mapMultiplos.put(num + "", generarMultiplos(num));
    }

    /**
     * @param num el nº del que se generearán los múltiplos
     * @return una colección ArrayLIst con los múltiplos generados
     */
    private ArrayList<Integer> generarMultiplos(int num) {
        ArrayList<Integer> multiplos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            multiplos.add(num * i);
        }
        return multiplos;
    }

    /**
     * @param num el nº del que se obtendrán los múltiplos
     * @return la colección asociada en el map
     */
    public ArrayList<Integer> obtenerMultiplosDe(int num) {
        return mapMultiplos.get(num);
    }


    /**
     * Visualiza el map (claves y valores asociados)
     */
    public void escribirMap() {
        Set<String> setClaves = mapMultiplos.keySet();
        for (String clave : setClaves) {
            System.out.print(clave + ": ");
            escribirValor(mapMultiplos.get(clave));
            System.out.println();//Salto de línea
        }
    }


    /**
     * Método privado de ayuda que visualiz aun ArrayList
     */
    private void escribirValor(ArrayList<Integer> lista) {
        for (Integer num : lista) {
            System.out.printf("%4s", num);
        }
    }

    /**
     * borrar del map (de todas las entradas) el múltiplo indicado
     * y devuelve el total de múltiplos borrados
     * Con Map.Entry y un iterador
     */
    public int borrarMultiplo(int multi) {
        int contador = 0;
        Set<Map.Entry<String, ArrayList<Integer>>> setEntradas = mapMultiplos.entrySet();
        Iterator<Map.Entry<String, ArrayList<Integer>>> itSetEntradas = setEntradas.iterator();

        while (itSetEntradas.hasNext()) {
            Map.Entry<String, ArrayList<Integer>> entrada = itSetEntradas.next();
            boolean borrar = entrada.getValue().remove(Integer.valueOf(multi));
            if (borrar) {
                contador++;
            }
        }
        return contador;
    }


}
