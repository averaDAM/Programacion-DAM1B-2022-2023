
/**
 *  La clase guarda una frase como conjunto de palabras
 */
import java.util.HashSet;
public class Frase
{
     
    private HashSet<String> conjuntoPalabras;

    /**
     * Constructor  
     * @param frase la frase desde la que extraeremos las palabras
     * Cada palabra está separada por exactamente un blanco
     */
    public Frase(String frase)
    {
        conjuntoPalabras = new HashSet<>();
        String[] trozos = frase.split(" ");
        for (String t : trozos) {
            conjuntoPalabras.add(t);
        }
    }

    /**
     *  
     *  
     * 
     */
    public void mostrarFrase()
    {
        for (String pal : conjuntoPalabras) {
            System.out.println(pal);
        }
    }
    
      
    /**
     *  
     */
    public static void main(String[] args)
    {
       Frase frase = new Frase("esto es un ejemplo de un conjunto Set esto");
       frase.mostrarFrase();
    }
}
