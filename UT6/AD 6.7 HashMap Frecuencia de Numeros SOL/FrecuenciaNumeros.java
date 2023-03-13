
/**
 * La clase mantiene un map en el
 * que se registran las veces que 
 * aparece cada uno de los números
 * de un fichero de texto
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FrecuenciaNumeros
{

    private HashMap<String, Contador> frecuencias;
    /**
     * Constructor de la clase FrecuenciaNumeros
     */
    public FrecuenciaNumeros()
    {
        frecuencias = new HashMap<>();
    }

    /**
     * 
     *
     * @param  el nº a añadir    
     */
    public void añadirNumero(int numero)
    {
        Contador cont = frecuencias.get(numero + "");//Paso el num a String concatenando ""
        if(cont == null){//Si no estaba el número, es su primera aparición
            cont = new Contador();
            frecuencias.put(numero + "", cont);
        }
        else{
            cont.incrementar();
        }

    }


    /**
     * lee los números de un fichero de texto 
     * Este método no hay que modificarlo
     *      
     */
    public void cargarDeFichero() 
    {
        try
        {
            Scanner sc = new Scanner(new File("numeros.txt"));
            while (sc.hasNext() )
            {
                añadirNumero(sc.nextInt());
            }
            sc.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Listar cada número aparecido y su frecuencia
     * Se utiliza Map.Entry
     */
    public void listarFrecuencias()
    {
        System.out.println("\nLista de frecuencias: ");
        Set<Map.Entry<String, Contador>> setEntradas = frecuencias.entrySet();
        for (Map.Entry<String, Contador> entrada : setEntradas) {
            System.out.printf("%8s %15s\n","Nº " + entrada.getKey(), "Frecuencia " + entrada.getValue().getContador());
        }
    }
    /**
     * 
     * Muestra cuántos números diferentes han aparecido
     * y la relación de todos ellos
     * 
     * Se utiliza la "vista" sobre las claves
     * y un for each
     */
    public void listarNumeros()
    {
        Set<String> claves = frecuencias.keySet();
        System.out.println("\n\nHay " + frecuencias.size() + " números distintos: ");
        for (String clave : claves) {
            System.out.print(clave  + " ");
        }
        System.out.println();
    }
        
}
