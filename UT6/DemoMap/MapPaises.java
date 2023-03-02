import java.util.*;

/**
 *   Una colección HashMap que asocia países con sus capitales
 */

public class MapPaises
{

    private HashMap<String,String> mapPaises;

    /**
     * Constructor  
     */
    public MapPaises()
    {
        mapPaises = new HashMap<>();
    }

    /**
     * Añadir una nueva entrada al map, la clave es el país, el
     * valor asociado la capital
     * 
     */
    public void addPais(String pais, String capital)
    {
        mapPaises.put(pais, capital);
    }

    /**
     * Dado un país obtener su capital
     */
    public  String capitalDe(String pais)
    {
        return mapPaises.get(pais);
    }

    /**
     * detecta si existe o no una clave en el map
     */
    public  boolean estaPais(String pais)
    {
         return mapPaises.containsKey(pais);
    }

    /**
     *  Dado un país elimina la entrada correspondiente a esa clave
     *
     */
    public void borrarPais(String pais)
    {
         mapPaises.remove(pais); //Devolverá false si el pais no está entre las claves
    }

    /**
     * detecta si existe o no un valor en el map
     */
    public  boolean estaCapital(String capital)
    {
         return mapPaises.containsValue(capital);
    }


    /**
     * nº de elementos del map
     */
    public  int totalPaises()
    {
        return mapPaises.size(); //Devuelve la cantidad de entradas
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de claves (keySet)
     * Con for mejorado
     */
    public void mostrarPaisesV1()
    {
        Set<String> setPaises = mapPaises.keySet();
        for (String pais : setPaises) {
            String capital = mapPaises.get(pais);
            System.out.println(pais + ": " + capital);
        }
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de claves (keySet)
     * Con iterador
     */
    public void mostrarPaisesV2()
    {
        Set<String> setPaises = mapPaises.keySet();
        Iterator<String> itSetPaises =setPaises.iterator();
        while (itSetPaises.hasNext()) {
            String pais = itSetPaises.next();
            System.out.println(pais + ": " + mapPaises.get(pais));
        }
        
        
        
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de entradas (entrySet)
     * Con for mejorado
     */
    public void mostrarPaisesV3()
    {
        Set<Map.Entry<String,String>> setEntradas = mapPaises.entrySet();
        for (Map.Entry entrada : setEntradas) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de entradas (entrySet) y recorriéndolas
     * con un iterador
     */
    public void mostrarPaisesV4()
    {
        Set<Map.Entry<String,String>> setEntradas = mapPaises.entrySet();
        Iterator<Map.Entry<String,String>> itSetEntradas = setEntradas.iterator();
        while (itSetEntradas.hasNext()) {
            Map.Entry<String, String> entrada = itSetEntradas.next();
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

    /**
     *  Devuelve la colección de capitales presentes en el map
     *
     */
    public Collection<String> grupoCapitales()
    {
        return mapPaises.values();
    }
}
