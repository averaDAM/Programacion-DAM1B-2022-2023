/**
 * Un objeto de esta clase
 * guarda una lista de
 * números enteros
 * 
 * La clase incluye una serie de métodos de instancia
 * para hacer operaciones sobre la lista
 * e incluye dos  métodos estáticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author -
 */

import java.util.Arrays;
import java.util.Random;

public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    
    private int[] lista;
    private int pos; // nº real de elementos en la lista

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor al final de la lista 
     * siempre que no esté completa
     *
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (estaCompleta()) {
            return false;
        }
        lista[pos] = numero;
        pos++;
        return true;

    }

    /**
     * @return true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;

    }

    /**
     * @return true si la lista está vacía, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;

    }

    /**
     * @return el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        this.pos = 0;
    }

    /**
     * @return una cadena con representación textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        if (estaVacia()) {
            return "";
        }
        String str = obtenerLinea() + "\n";
        for (int i = 0; i < pos; i++) {
            str = str + Utilidades.centrarNumero(lista[i], ANCHO_FORMATO);
        }
        str += "\n" + obtenerLinea();
        return str;
    }

    /**
     * @return un String con una línea de cabecera 
     * 
     * El nº de caracteres en la cabecera dependerá 
     * del nº real de elementos en la lista
     * y del ancho del formato que ocupará cada nº
     */
    private String obtenerLinea() {
        String str = "";
        int n = pos * ANCHO_FORMATO;
        for (int i = 0; i < n; i++) {
            str = str + CAR_CABECERA;
        }
        return str;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor máximo en la lista
     * Cuando no haya un segundo máximo el método 
     * devolverá el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {       
        int maximo = Integer.MIN_VALUE;
        int segundoMax = Integer.MIN_VALUE;
        for (int i = 0; i < pos; i++) {
            if (lista[i] > maximo) {
                segundoMax = maximo;
                maximo = lista[i];
            } else if (lista[i] > segundoMax && lista[i] != maximo) {
                segundoMax = lista[i];
            }
        }

        return segundoMax;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        int segundo = segundoMaximo();
        if (segundo == Integer.MIN_VALUE) {
            return false;
        }
        int s = 0;  // nº de segundos máximos que vamos encontrando
        for (int i = 0; i < pos; i++) {
            if (lista[i] == segundo) {
                // for (int j = i - 1; j >= s; j--) {
                // lista[j + 1] = lista[j];
                // }
                System.arraycopy(lista, s, lista, s + 1, i - s); 
                lista[s] = segundo;
                s++;
            }
        }
        return true;

    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) {

        int[] copia = Arrays.copyOf(lista, pos);
        Arrays.sort(copia);
        int p = Arrays.binarySearch(copia, numero);
        if (p < 0) {
            return -1;
        }
        return p;

    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
        int[][] brillos = new int[DIMENSION][DIMENSION];
        for (int f = 0; f < brillos.length; f++) {
            for (int c = 0; c < brillos[f].length; c++) {
                brillos[f][c] = generador.nextInt(11);
            }

        }
        return brillos;

    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] brillos) {
        boolean[][] estrellas = new boolean[DIMENSION][DIMENSION];
        for (int f = 1; f < brillos.length - 1; f++) {
            for (int c = 1; c < brillos[f].length - 1; c++) {
                int sumaVecinos = brillos[f - 1][c] + brillos[f + 1][c] + 
                    brillos[f][c - 1] + brillos[f][c + 1];
                estrellas[f][c] = sumaVecinos > 30;

            }

        }
        return estrellas;
    }

}
