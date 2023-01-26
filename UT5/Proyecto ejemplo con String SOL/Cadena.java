import jdk.swing.interop.SwingInterOpUtils;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.text.StyledEditorKit;
import java.util.Scanner;


/**
 * clase Cadena  
 * Modela una cadena de caracteres y sus
 * operaciones asociadas
 */
public class Cadena
{
    public static final String SEPARADOR = ":";
    private String cadena; 

    /**
     * Constructor  
     */
    public Cadena(String cadena)
    {
        this.cadena = cadena;
    }

    /**
     * Constructor  
     */
    public Cadena(Cadena cadena)
    {
        this.cadena = new String(cadena.getCadena());
    }

    /**
     * Constructor  
     */
    public Cadena()
    {
        cadena = "Ejemplo:de:cadena:de:caracteres";
    }

    /**
     * accesor para la cadena 
     */
    public String getCadena()
    {
        return this.cadena;
    }

    /**
     * mutador para la cadena 
     */
    public void setCadena(String cadena)
    {
        this.cadena = cadena;
    }

    /**
     *  Longitud en caracteres de la cadena
     * 
     */
    public int longitud()
    { 
         return cadena.length();
    }

    /**
     *  devolver el primer caracter
     * 
     */
    public char primerCaracter()
    { 
         return cadena.charAt(0);
    }

    /**
     *  devolver el último caracter
     * 
     */
    public char ultimoCaracter()
    { 
          return cadena.charAt(cadena.length()-1);
    }

    /**
     *  devolver el  caracter de posición p
     *  Lanzamos una excepción StringIndexOutOfBoundsException si p es incorrecta
     * 
     */
    public char caracterDePosicion(int p)
    { 
          return cadena.charAt(p);
    }

    /**
     * concatena la cadena actual con la recibida como parámetro y devuelve un
     * nuevo objeto Cadena que la encapsula
     */
    public  Cadena concatenarCon(Cadena otra)
    {
        String concatenada = this.getCadena().concat(otra.getCadena());
         return new Cadena(concatenada);
    }

    /**
     *  paso a mayúsculas
     * 
     */
    public void aMayusculas()
    {
        System.out.println(cadena.toUpperCase());

    }

    /**
     *  paso a minúsculas
     * 
     */
    public void aMinusculas()
    {
        System.out.println(cadena.toLowerCase());

    }

    /**
     *  devuelve true si las dos cadenas son iguales
     * 
     */
    public boolean igualQue(String cadena)
    {
        //Obvio diferencias de mayúsculas y minúsculas
        return cadena.equalsIgnoreCase(this.cadena);
    }

    /**
     * devuelve true si la cadena del objeto es mayor que
     * la cadena recibidad como parámetro
     * 
     */
    public boolean mayorQue(String cadena)
    {
        //Que sea mayor en el compareTo de String significa que va después alfabéticamente
        return this.cadena.compareToIgnoreCase(cadena) > 0;
    }

    /**
     * devuelve true si la cadena del objeto empieza por
     * la recibida como parámetro - da lo mismo mayúsculas que minúsculas
     * 
     * 
     */
    public boolean empiezaPor(String str)
    { 
        return cadena.startsWith(str);

    }


    /**
     * devuelve true si la cadena del objeto contiene a la recibida como parámetro
     * da lo mismo mayúsculas que minúsculas
     */
    public boolean contiene(String str)
    { 
        
        return cadena.contains(str);
    }

    /**
     *   localiza la última aparición de str en cadena y extrae , a partir de ahí, 
     *   la subcadena existente hasta el final
     *   Si no existe str devuelve null
     */
    public String cadenaApartirDe(String str)
    {
        int ultPos = cadena.lastIndexOf(str);
        if(ultPos!=-1){
            return cadena.substring(ultPos);
        }

        return null;
    }

    /**
     * Cuenta el nº de 'A'
     */
    public  int cuantasA()
    {
        int cont = 0;
        //Hacemos una búsqueda líneas de ocurrencias de 'A' en la cadena
        for (int i = 0; i < cadena.length(); i++) {
            if(cadena.charAt(i)=='A'){ //Para comparar con un char (primitivo) no necesito equals
                cont++;
            }
        }
        return cont;
    }

    /**
     * Devuelve un objeto Cadena con la cadena actual invertida
     */
    public  Cadena invertir()
    {
        String cadInv = "";
        //Recorro la cadena de derecha a izquierda
        for (int i = cadena.length()-1; i >= 0 ; i--) {
            cadInv += cadena.charAt(i);
        }
        return new Cadena(cadInv);
    }

    /**
     * Devuelve true si la cadena es un palíndromo
     * Versión iterativa
     */
    public  boolean esPalindromaIterativa()
    {
        int contDerecha = cadena.length()-1;
        //Llegamos hasta la mitad en el bucle
        for (int i = 0; i < cadena.length()/2; i++) {
            if(cadena.charAt(i)!=cadena.charAt(contDerecha)){
                return false;
            }
            contDerecha --;//Vamos decrementando el otro contador
        }
        return true;
    }

    /**
     * Devuelve true si la cadena es un palíndromo
     * Versión recursiva
     */
    public  boolean esPalindromaRecursiva()
    {
        return esPalindromaRecursiva(this.cadena);
    }

    /**
     *  
     *
     */
    private boolean esPalindromaRecursiva(String cadena)
    {
        if (cadena.length() == 0) {
            return true;
        }
        if (cadena.length() == 1) {
            return true;
        }
        return cadena.charAt(0) == cadena.charAt(cadena.length() - 1) &&
                esPalindromaRecursiva(cadena.substring(1, cadena.length() - 1));
    }


    /**
     * Devuelve los tres últimos caracteres de la cadena
     */
    public String tresUltimosCaracteres()
    {
        int pos = cadena.length() -3;
        return cadena.substring(pos);
    }

    /**
     * Si la cadena es "ejemplo" 
     * hay que escribir
     * e
     * ej
     * eje
     * ejem
     * ejemp
     * ejempl
     * ejemplo
     * 
     *  
     */
    public  void visualizarEnTrozos()
    {
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println(cadena.substring(0,i+1));
        }
    }

    /**
     *  
     * Si la cadena es "ejemplo" 
     * hay que mostrar
     * e
     *  j
     *   e
     *    m
     *     p
     *      l
     *       o
     * 
     */
    public  void visualizarEnDiagonal()
    {
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < i; j++) { //For para poner i espacios antes de cada línea
                System.out.print(" ");
            }
            System.out.println(cadena.substring(i,i+1));
        }
    }


    public  void visualizarEnDiagonalV2()
    {
        final String BLANCO = " ";
        String blancos = "";
        int lon = longitud();
        for (int i = 0; i < lon; i++){
            System.out.println(blancos + cadena.charAt(i));
            blancos = blancos.concat(BLANCO);
        }
    }
    /**
     * @param otra la cadena con la que comparar
     * @return true si la cadena actual empieza y termina por el mismo 
     * caracter que otra
     */
    public  boolean  empiezaYterminaIgualQue(Cadena otra)
    {
        String otraCad = otra.getCadena();
        return cadena.startsWith(otraCad) && cadena.endsWith(otraCad);
    }

    /**
     * @param objetivo el caracter a buscar en la cadena actual
     *  @param nuevo  el caracter por el que se reemplazará
     *  
     */
    public  void reemplazarPor(char objetivo, char nuevo)
    {
        System.out.println(cadena.replace(objetivo, nuevo));
    }

    /**
     *  Contar las palabras de cadena, el separador entre palabras es
     *  el carácter SEPARADOR
     *
     */
    public int numeroPalabras()
    {
        String[] arrPalabras = cadena.split(SEPARADOR);
        return arrPalabras.length;
    }

    /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  Usar indexOf() y substring()
     */
    public int aparicionesDe(String str)
    {
        int cont = 0;
        String cad = cadena.toLowerCase();
        boolean seguir = true;
        while(cad.length()> 0 && seguir){
            int pos = cad.indexOf(str.toLowerCase());
            if(pos!=-1){
                cad = cad.substring(pos + 1);
                cont++;
            }
            else{
                seguir = false;
            }
        }
        
         return cont;
        
    }
    
      /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  Usar solo indexOf()  
     */
    public int aparicionesDeV2(String str)
    {
        int veces = 0;
        String aux = cadena.toLowerCase();
        str = str.toLowerCase();
        int pos = aux.indexOf(str);
        while (pos != -1)  {
            veces++;
            pos = aux.indexOf(str, pos + str.length());
        }

        return veces;
    }
    
     /**
     *   Cuenta las vocales
     *   Hace uso del método privado esVocal()
     *
     */
    public int contarVocales()
    {
         
        int cont = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if(esVocal(cadena.charAt(i))){
                cont++;
            }
        }
        return cont;
    }

    /**
     *  
     *
     */
    private boolean esVocal(char car)
    {
        return "aeiouAEIOUáéíóúÁÉÍÓÚ".indexOf(car) != -1;
    }

    /**
     *   Suponiendo cadena = "examen" el array obtenido sería
     *   
     *   [e, e, e, e, e, e]
     *   [x, x, x, x, x, x]
     *   [a, a, a, a, a, a]
     *   [m, m, m, m, m, m]
     *   [e, e, e, e, e, e]
     *   [n, n, n, n, n, n]

     */
    public char[][]  cadenaToArray2D()
    {
        //Declaramos el array que devolveremos
        char[][] matriz = new char[cadena.length()][cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < cadena.length(); j++) {
                matriz[i][j] = cadena.charAt(i);
            }
        }
        return matriz;
    } 

    

    /**
     *  Eliminar los espacios - usando StringBuilder
     *
     */
    public void eliminarEspacios()
    {
        StringBuilder sb = new StringBuilder(this.cadena);
        final char ESPACIO = ' ';
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)==ESPACIO){
                sb.deleteCharAt(i);
            }
        }
        System.out.println("Sin espacios: " + sb.toString());
    }

    /**
     * Sustituye en cadena el caracter que coincida con objetivo por *
     */
    public  void sustituirPorAsterisco(char objetivo)
    {
        StringBuilder sb = new StringBuilder(this.cadena);
        final char ASTERISCO = '*';
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == objetivo){
                sb.setCharAt(i,ASTERISCO);
            }
        }
        System.out.println("Sustituido "  + objetivo + " por asteriscos: " + sb.toString());
    }
 
    /**
     *  escribe las palabras de cadena, el separador entre palabras es
     *  el carácter SEPARADOR - con Scanner
     *
     */
    public void printPalabrasV2()
    {
        Scanner sc = new Scanner(this.cadena);    
        sc.useDelimiter("de");
        System.out.println("Separando con el separador \"de\" con scanner: ");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
    }

    /**
     * suma los enteros de la cadena
     *
     */
    public int sumarEnteros()
    {
        int suma = 0;
        Scanner sc = new Scanner(this.cadena);    
        while (sc.hasNextInt()){
            suma += sc.nextInt();
        }
        return suma;
    }

     

}
