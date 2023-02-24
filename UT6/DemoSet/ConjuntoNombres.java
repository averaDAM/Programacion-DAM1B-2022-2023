
/**
 *  La clase representa a un conjunto de nombres
 *  
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
public class ConjuntoNombres
{
     
    private HashSet<String> nombres;
     
    /**
     * Constructor  
     */
    public ConjuntoNombres()
    {
        nombres = new HashSet<>();
    }
    
    /**
     * Añade un nombre al conjunto
     */
    public  void addNombre(String nombre)
    {
        nombres.add(nombre);
    }

     /**
     * Borrar un nombre al conjunto
     */
    public  void borrarNombre(String nombre)
    {
        nombres.remove(nombre);
    }
    
    /**
     *  Devuelve true si el conjunto contiene a nombre
     *
     */
    public boolean estaNombre(String nombre)
    {
        
        return nombres.contains(nombre);
    }


    /**
     *  
     * Nº de nombres (elementos del conjunto)
     */
    public int totalNombres()
    {
          return nombres.size();
    }
    
    
   /**
     *  Obtiene un nuevo conjunto de nombres, la unión
     *  del atributo nombres y del parámetro otro
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> union(HashSet<String> otro)
    {
       HashSet<String> union = new HashSet<>();
       union.addAll(otro);
       union.addAll(nombres);
       return union;
    }

    /**
     *  Obtiene un nuevo conjunto de nombres, la intersección (los nombres comunes)
     *  del atributo nombres y del parámetro otro
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> interseccion(HashSet<String> otro)
    {
        HashSet<String> interseccion = new HashSet<>(otro);
        interseccion.retainAll(nombres);
        return interseccion;
    }

    /**
     *  Obtiene un nuevo conjunto de nombres, la diferencia  
     *  del conjunto nombres y del conjunto  otro 
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> diferencia(HashSet<String> otro)
    {
       HashSet<String> diferencia = new HashSet<>(nombres);
       diferencia.removeAll(otro);
       return diferencia;
    }


    /**
     * Mostrar todos los nombres con iterador
     */
    public  void escribirConjunto()
    {
        Iterator<String> itNombres = nombres.iterator();
        while (itNombres.hasNext()) {
            System.out.println(itNombres.next());
        }
    }
    
     /**
     * Mostrar todos los nombres con for mejorado
     */
    public  void escribirConjuntoConFor()
    {
        for (String n : nombres) {
            System.out.println(n);
        }
    }
    
     /**
     *  
     */
   public static void main(String[] args)
    {
        ConjuntoNombres conjunto = new ConjuntoNombres();
        String[] nombres = {"luis", "ana", "pedro", "alberto", "pepa", "luis", "ana"};        
        for (String nombre: nombres)   {
            conjunto.addNombre(nombre);
        }
        conjunto.escribirConjunto();
        System.out.println("-------------------------");

        String nombre = "julio";
        System.out.println("Esta el nombre " + nombre + "? " + conjunto.estaNombre(nombre));
        System.out.println("-------------------------");

         //HashSet<String> otro = new HashSet<String>(Arrays.asList("pedro", "ana"));
         HashSet<String> otro = new HashSet<String>();
         otro.addAll(Arrays.asList("pedro", "ana"));
        System.out.println("*********** EMPEZAMOS CON EL CONJUNTO 2  ***********");
         conjunto.escribirConjunto();
         System.out.println(otro.toString() + "\n");
         HashSet<String> union = conjunto.union(otro);
         System.out.println("Unión: " + union.toString());

         System.out.println("-------------------------");
         conjunto.escribirConjunto();
         System.out.println(otro.toString() + "\n");
         HashSet<String> inter = conjunto.interseccion(otro);
         System.out.println("Intersección: " + inter.toString());

         System.out.println("-------------------------");
         conjunto.escribirConjunto();
         System.out.println(otro.toString() + "\n");
         HashSet<String> difer = conjunto.diferencia(otro);
         System.out.println("Diferencia: " + difer.toString());
    }

}
