/**
 * descripción la clase DemoSecuencia  
 * 
 * @author  
 * @version  
 */
import java.util.ArrayList;
import java.util.Arrays;
public class DemoSecuencia
{
    private Secuencia secuencia;
 

    /**
     * Constructor de la clase DemoSecuencia
     */
    public DemoSecuencia()
    {

    }

    /**
     *        
     */
    public void demoFusion(   )
    {
        Integer[] numeros1 = {3,    4,    4,     5,    7,    8,    9,    9,    14};
        ArrayList<Integer> lista = new ArrayList<Integer>(Arrays.asList(numeros1));         
        secuencia  = new Secuencia(lista);

        Integer[] numeros2 = {1,    3,    3,    4,   12};
        ArrayList<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(numeros2));

        ArrayList<Integer> fusion = secuencia.fusionarCon(lista2);

        System.out.println(fusion.toString());

    }
    
      /**
     *  
     *       
     */
    public void demoInterseccion(   )
    {
       
        Integer[] numeros1 = {3,    4,    4,     5,    7,    8,    9,    9,    14};
        ArrayList<Integer> lista = new ArrayList<Integer>(Arrays.asList(numeros1));         
        secuencia  = new Secuencia(lista);

        Integer[] numeros2 = {1,    3,    3,    4,   12};
        ArrayList<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(numeros2));

        ArrayList<Integer> interseccion = secuencia.interseccionCon(lista2);

        System.out.println(interseccion.toString());

    }

    public static void main(String[] args) {
        DemoSecuencia demo = new DemoSecuencia();
        demo.demoFusion();
        demo.demoInterseccion();
    }
}
