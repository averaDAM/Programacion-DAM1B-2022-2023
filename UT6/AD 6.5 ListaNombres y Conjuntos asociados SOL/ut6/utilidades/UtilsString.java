package ut6.utilidades;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 *  Clase de utilidades. Contiene solo métodos
 *  estáticos
 *  
 */
 

public class UtilsString
{
    /**
     *  Dada una cadena obtiene y devuelve su conjunto de caracteres
     *  Importa el orden en el conjunto
     *
     */
    public static TreeSet<Character> getConjuntoCaracteres(String cadena)
    {
        //Para ordenación automática, usamos estructuras de tipo Tree
        TreeSet<Character> setCar = new TreeSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            setCar.add(cadena.charAt(i));
        }
        return setCar;
    }

     /**
     *  Dada una cadena obtiene su conjunto de caracteres numéricos
     *  No importa el orden en el conjunto
     *  
     *  Usa algún método de la clase Character  para comprobar si un caracter es  
     *  numérico o no
     *
     */
    public static HashSet<Character> getConjuntoDigitos(String cadena)
    {
        //Si nos da igual el orden, usamos estructuras de tipo Hash.
        HashSet<Character> setCar = new HashSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            if(Character.isDigit(cadena.charAt(i)))
                setCar.add(cadena.charAt(i));
        }
        return setCar;
    }
    
     /**
     *  Dada una cadena obtiene su conjunto de letras mayúsculas
     *  en el orden en el que aparecen   en la cadena
     *   
     *
     */
    public static LinkedHashSet<Character> getConjuntoMayusculas(String cadena)
    {
        //Para respetar el orden de guardado usamos estructuras de tipo LinkedHash.
        LinkedHashSet<Character> setCar = new LinkedHashSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            if(Character.isUpperCase(cadena.charAt(i))){
                setCar.add(cadena.charAt(i));
            }
        }
        return setCar;
    }
        
        
}
