import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Modela un diccionario en el que cada palabra
 * tiene asociados una serie de sinónimos
 *
 */



public class Tesauro
{
    // a cada clave se le asocia un conjunto de sinónimos
    //los sinónimos no se repiten
    private HashMap<String, HashSet<String>> tesauro;

    /**
     * Constructor de la clase Tesauro
     */
    public Tesauro()
    {
        tesauro =new HashMap<>();
    }

    /**
     *
     * @param  palabra la palabra a añadir
     *         sinonimo el sinónimo de la palabra
     */
    public void añadirSinonimo(String palabra, String sinonimo)
    {
        HashSet<String> setSinonimos = tesauro.get(palabra);
        if(setSinonimos==null){
            setSinonimos = new HashSet<>();
            tesauro.put(palabra, setSinonimos);
        }
        setSinonimos.add(sinonimo);
    }

    /**
     * añade una palabra junto con todos sus sinónimos
     * @param linea contiene la palabra y sus sinónimos
     *         el separador entre palabras es el blanco
     *         la primera palabra es la clave, el resto sinónimos
     */
    public void añadirSinonimo(String linea)
    {
        String[] trozos = linea.split(" ");
        String clave = trozos[0].trim();//El primer trozo es la clave (la palabra)
        for (int i = 1; i < trozos.length; i++) {//Los trozos desde 1 hasta el final son los sinonimos
            añadirSinonimo(clave, trozos[i].trim());//Aprovechamos la función anterior
        }
    }
    /**
     *
     * @param  sin el sinónimo a borrar de cada conjunto
     *              de sinónimos
     * @return   el conjunto de claves en las que estaba
     *            el sinónimo borrado. Si no se borró
     *            ninguno devuelve el conjunto vacío
     */
    public HashSet<String> borrarSinonimo(String sin)
    {
        HashSet<String> conBorrados = new HashSet<>();
        Set<String> setPalabras = tesauro.keySet();

        for (String palabra : setPalabras) {
            HashSet<String> setSinonimos = tesauro.get(palabra);
            boolean borrado = setSinonimos.remove(sin);
            if(borrado == true){
                conBorrados.add(palabra);
            }
        }

        return conBorrados;
    }

    /**
     *
     * @param  representación textual del map
     * @return
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (String palabra : tesauro.keySet()) {
            sb.append(palabra + ": " + tesauro.get(palabra) + "\n");
        }
        return sb.toString();
    }

    /**
     *
     * Visualiza el tesauro
     */
    public void escribirTesauro()
    {

        System.out.println(toString());
    }




}
