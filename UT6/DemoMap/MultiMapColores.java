import java.util.*;

/**
 *  
 * Clase que incluye un map que asocia nombre de personas con el conjunto de sus colores favoritos
 * Ejemplo de uso de un multimap, un map en el que cada clave tiene
 * asociado una colección de valores
 */
 

public class MultiMapColores
{

    //No nos indican que las claves o el conjunto de valores deban estar ordenados, así que usamos
    //HashMap y HashSet respectivamente.
    private HashMap<String, HashSet<String>> mapPersonas;

    /**
     * Constructor  
     */
    public MultiMapColores()
    {
        mapPersonas =   new HashMap<>();
    }

    /**
     *   Añade una nueva persona al map con su color favorito
     *   Si la persona (clave) no existe se crea una nueva entrada con
     *   un conjunto vacío y se añade el color al conjunto
     *   Si la persona  (clave) existe se añade el color
     * 
     */
    public void addPersona(String nombre, String color)
    {
        //En este caso usaré la función containsKey()

        //El objetivo del if-else, es simplemente tener una referencia al HashSet valor
        //No hago AÚN el guardado del nuevo color en dicho HashSet

        //Declaro la variable que apuntará al HashSet
        HashSet<String> setColores;
        if(mapPersonas.containsKey(nombre)){
            //Si la clave ya está en el map, apuntamos con la variable a su conjunto
            setColores = mapPersonas.get(nombre);
            //No es necesario hacer un put. YA ESTÁ DENTRO!
        }
        else{
            //Si no está en el map, apuntamos con la variable a un nuevo un conjunto vacío
            // y lo ponemos (put) en el Map con su clave
            setColores = new HashSet<>();
            mapPersonas.put(nombre, setColores);
        }

        //En este punto, ya tenemos una referencia al conjunto (vacío o no) de colores del nombre recibido
        //Sólo nos falta añadir el color al conjunto
        setColores.add(color);
    }

    /**
     *   Añade una nueva persona al map con su color favorito
     *   Si la persona (clave) no exite se crea una nueva entrada con
     *   un conjunto vacío y se añade el color al conjunto
     *   Si la persona  (clave) existe se añade el color
     * 
     */
    public void addPersonaV2(String nombre, String color)
    {
        //En este caso lo resuelvo sin usar la función containsKey()
        //La función get() me devuelve el valor (si la clave existe) o null (si no existe)
        HashSet<String> setColores = mapPersonas.get(nombre);
        if(setColores == null){
            setColores = new HashSet<>();
            mapPersonas.put(nombre, setColores);
        }

        //Guardamos el nuevo color
        setColores.add(color);

    }


    /**
     * Muestra el nombre de cada persona y sus colores favoritos
     * Con el conjunto de claves y un for mejorado
     */
    public  void escribirPersonasColores()
    {
        //Recuperamos un conjunto vista de las claves y lo recorremos
        //Cambios en el map (ej.: borrar una clave) se verán reflejados en el conjunto y viceversa
        Set<String> setPersonas = mapPersonas.keySet();
        for (String persona : setPersonas) {
            System.out.println(persona  + ": " + mapPersonas.get(persona).toString());
        }
    }

    /**
     * devuelve el nº de personas a las que les gusta el color pasado como parámetro
     * Con el conjunto de entradas y un iterador
     */
    public int personasLesGustaColor(String color)
    {
        int contador = 0;
        //Declaramos y recuperamos un conjunto vista de las entradas. Ojo a la sintaxis de declaración
        Set<Map.Entry<String, HashSet<String>>> setEntradas = mapPersonas.entrySet();
        //Declaramos e inicializamos un iterador sobre el set de entradas
        Iterator<Map.Entry<String, HashSet<String>>> itEntradas = setEntradas.iterator();
        while (itEntradas.hasNext()) {
            Map.Entry<String, HashSet<String>> entrada = itEntradas.next();
            //Apuntamos con una variable al conjunto de personas
            HashSet<String> coloresPersona = entrada.getValue();
            if(coloresPersona.contains(color)){
                contador++;
            }
        }

        return contador;
    }

    /**
     * devuelve un conjunto ordenado con los nombres de las personas a las que les gusta 
     * el color pasado como parámetro
     * Con el conjunto de claves y un for
     */
    public TreeSet<String> conjuntoPersonasLesGustaColor(String color)
    {
        //Planteamiento: Recorremos el mapPersonas comprobando para cada persona si tiene el color recibido
        //entre sus favoritos. Si es así, añadimos la persona al TreeSet retorno

        //En este caso, el retorno es un TreeSet. Los valores estarán ordenados
        TreeSet<String> setPersonasColor = new TreeSet<>();


        //Recuperamos el conjunto de claves del mapPersonas y lo recorremos
        Set<String> setPersonas = mapPersonas.keySet();
        for (String persona : setPersonas) {
            //En este caso no almaceno el HashSet de cada persona en una variable. Hago la búsqueda en una sóla línea
            if(mapPersonas.get(persona).contains(color)){
                setPersonasColor.add(persona);
            }
        }

        return setPersonasColor;
    }

    /**
     *  Borrar el color que le gusta a la persona indicada
     *
     */
    public void borrarColor(String persona, String color)
    {
        //No podemos hacer un remove directamente en el map, ya que eso borra toda la entrada
        //El remove se tiene que hacer sobre el HashSet de colores correspondiente a la persona

        HashSet<String> coloresPersona = mapPersonas.get(persona);
        if(coloresPersona != null){
            coloresPersona.remove(color); //Si el color no está, devolverá false
        }

    }

    /**
     * Añadido al proyecto de partida
     * @param persona1
     * @param persona2
     * @return un HashSet con los nombres de los colores en común de ambas personas. Vacío si no hay coincidencias
     */
    public HashSet<String> coloresComunes(String persona1, String persona2) {
        HashSet<String> coloresP1 = mapPersonas.get(persona1);
        HashSet<String> coloresP2 = mapPersonas.get(persona2);

        //OJO: No podemos actuar sobre coloresP1 o sobre coloresP2 porque apuntan a los conjuntos reales (no son copias)
        //Crearemos un nuevo HashSet
        HashSet<String> interseccion = new HashSet<>(coloresP1);
        interseccion.retainAll(coloresP2);
        return interseccion;
    }
}

