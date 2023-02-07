import java.util.Arrays;
import java.util.Scanner;

/**
 * Un objeto de esta clase guarda en un array las diferentes
 * palabras que hay en un texto
 *
 * Cada palabra es un objeto Palabra que guarda la palabra (como String)
 * y su frecuencia de aparición en el texto
 *
 * El array guarda como máximo n palabras distintas
 *
 *
 */
public class Texto {

    private Palabra[] palabras;
    private int total;

    /**
     * Constructor
     * Crea el array al tamaño n
     * e inicializa adecuadamente el resto de atributos
     */
    public Texto(int n) {
        palabras = new Palabra[n];
        total = 0;
    }

    /**
     *
     * @return true si el texto está completo
     */
    public boolean textoCompleto() {
        return total == palabras.length;
    }

    /**
     *
     * @return el nº de palabras distintas aparecidas en
     * el texto y guardadas en el array
     */
    public int totalPalabras() {
        return total;
    }

    /**
     * Dada una línea de texto conteniendo diferentes palabras
     * el método extre las palabras y las inserta en el array
     *
     * Las palabras en la línea están separadas por uno o varios espacios
     * seguidos, o por el punto o por la coma
     * Puede haber espacios al comienzo y final de la línea
     *
     * Ej - "   a single      type.  " contiene tres palabras: a single type
     *      "y un mozo de campo y plaza  "  contiene 7 palabras
     *
     * Antes de insertar una palabra habrá que comprobar que no se
     * ha añadido previamente. 
     * Si ya se ha añadido solo hay que incrementar su frecuencia de
     * aparición 
     * Si no está la palabra y hay sitio en el array para una nueva
     * se inserta de forma que quede ordenada (!!no se ordena, se
     * inserta en orden!!)
     *  
     * Hay que usar como métodos de ayuda estaPalabra() e
     * insertarPalabraEnOrden()
     */
    public void addPalabras(String linea) {
        linea = linea.trim();
        String[] trozos = linea.split("[,\\.\\s]+");
        for (int i = 0; i < trozos.length; i++) {
            int posicion = estaPalabra(trozos[i]);
            if(posicion == -1){//Comprobamos que la palabra no está ya en la lista
                if(!textoCompleto()){//Comprobamos que aún haya espacio para la palabra
                    insertarPalabraEnOrden(trozos[i]);
                }

            }
            else{//Si la palabra ya estaba en la lista, incrementamos su frecuencia
                palabras[posicion].incrementar();
            }
        }

    }
    
     /**
     *  dada una palabra devuelve la posición en la que se
     *  encuentra en el array o -1 si no está
     *
     *  Indiferente mayúsculas y minúsculas
     */
    public int estaPalabra(String palabra) {
        //Hacemos una búsqueda lineal
        for (int i = 0; i < total; i++) {
            if(palabras[i].getPalabra().equalsIgnoreCase(palabra)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param palabra inserta la palabra en el lugar adecuado
     *                de forma que el array palabras quede ordenado
     *                alfabéticamente
     *  Solo hay que insertar en este método, se asume que la palabra
     *                no está y que es posible añadirla
     *
     */
    private void insertarPalabraEnOrden(String palabra) {
        //Inserción en orden: Diapositiva 98 presentación I UT5
        int i = total -1;
        //Vamos buscando la posición de inserción y desplazando hacia la derecha
        while(i>=0 && palabras[i].getPalabra().compareToIgnoreCase(palabra)>0){
            palabras[i+1] = palabras[i];
            i--;
        }
        //En este punto, la posición de inserción será i+1
        palabras[i+1] = new Palabra(palabra);
        total++;
    }

   

    /**
     * Representación textual del array de palabras
     * Cada palabra y su frecuencia de aparición
     * Se muestran en líneas de 5 en 5 palabras
     * (ver enunciado)
     *
     * De forma eficiente ya que habrá muchas concatenaciones
     *
     *
     */
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < total; i++) {
            retorno.append(palabras[i] + "\t");
            if((i+1) % 5 == 0){
                retorno.append("\n");
            }
        }
        return retorno.toString();

    }

    /**
     *  Devuelve la palabra de la posición p
     *  Si p es incorrecto se devuelve null
     *      
     */
    public Palabra getPalabra(int p) {
        if(p<0 || p>=total){
            return null;
        }
        else{
            return palabras[p];
        }
    }

    
    /**
     *
     * @return un array de cadenas con las palabras del texto
     * capitalizadas de forma alterna
     */
    public String[] capitalizarAlterna() {
        String[] capitalizadas = new String[totalPalabras()];
        for (int i = 0; i < total; i++) {
            capitalizadas[i] = Utilidades.capitalizarAlterna(palabras[i].getPalabra());
        }
        return capitalizadas;
    }

    /**
     *
     * @return un array de cadenas con las palabras que tienen letras
     * repetidas
     */
    public String[] palabrasConLetrasRepetidas() {
        String[] arrayRepetidas = new String[total];//Lo creamos al total de palabras, y luego lo devolveremos recortado
        int contRepetidas = 0; //Llevamos la cuenta de las palabras con letras repetidas
        for (int i = 0; i < total; i++) {
            String pal = palabras[i].getPalabra();
            if(Utilidades.tieneLetrasRepetidas(pal)) {
                arrayRepetidas[contRepetidas] = pal;
                contRepetidas++;
            }
        }
        //Devolvemos el array truncado a la cantidad finalmente encontrada de repetidas
        return Arrays.copyOf(arrayRepetidas,contRepetidas);
    }

     /**
     *
     * @return un array con la frecuencia de palabras de cada longitud
     * La palabra más larga consideraremos de longitud 15
     *
     */
    public int[] calcularFrecuenciaLongitud() {
        int[] frecuencias = new int[15];
        for (int i = 0; i < total; i++) {
            //Calculamos la longitud de cada palabra
            int longitud = palabras[i].getPalabra().length();
            //Incrementamos el contador de frecuencia correspondiente
            frecuencias[longitud-1]++;
        }
        return frecuencias;
    }
    
    /**
     *
     * @param frecuencia se borra del array palabras aquellas de frecuencia
     *                   menor a la proporcionada
     * @return el n de palabras borradas
     */
    public int borrarDeFrecuenciaMenor(int frecuencia) {
        int borradas = 0;
        //Es un borrado múltiple. Lo haré con un  for de derecha a izquierda
        for (int i = total-1; i >=0 ; i--) {
            if(palabras[i].getFrecuencia()<frecuencia){
                borrarPalabra(i);
                borradas++;
            }
        }
        return borradas;
    }

    /**
     * Añadido al proyecto de partida
     * Borra la palabra de la posición indicada
     */
    public void borrarPalabra(int posicion){
        System.arraycopy(palabras, posicion +1, palabras, posicion, total - posicion -1);
        total--;
    }

    /**
     *  Lee de un fichero un texto formado por una
     *  serie de líneas.
     *  Cada línea contiene varias palabras separadas
     *  por espacios o el . o la ,
     *
     */
    public void leerDeFichero(String nombre) {
        Scanner sc = new Scanner(
                this.getClass().getResourceAsStream(nombre));
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            this.addPalabras(linea);
        }
        sc.close();

    }
}
