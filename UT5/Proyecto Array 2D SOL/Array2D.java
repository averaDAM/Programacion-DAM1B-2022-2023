import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *  Clase que guarda un array bidimensional
 *  y permite hacer ciertas operaciones sobre él
 */
public class Array2D
{
    public static char LLAVE_APERTURA = '{';
    public static char LLAVE_CIERRE = '}';
    private int[][] matriz;

    /**
     * Constructor  
     */
    public Array2D()
    {
        matriz = new int[][]{  {1, 2, 3, 4},
            {14, 5, 26, 7},
            {17, 8, 19, 10},
            {10, 11, 12, 13} } ;
    }

    /**
     * Constructor  - crea  un array de 2 dimensiones con las filas y columnas
     * indicadas
     * @param filas  nº de filas del array 
     *  @param columnas nº de columnas del array
     */
    public Array2D(int filas, int columnas)
    {
        matriz = new int[filas][columnas];

    }

    /**
     *  Inicializa la matriz con valores aleatorios entre 3 y 30 inclusive
     * Usa el mutador setValor
     */
    public void inicializar()
    {
        Random generador = new Random();
        for (int i = 0; i <matriz.length; i++) {
            //Uso matriz[i].length como límite de columnas, pero podría ser matriz[0].length
            //porque todas las filas tienen las mismas columnas
            for (int j = 0; j < matriz[i].length; j++) {
                setValor(i,j,generador.nextInt(28)+3);
            }
        }
    }
    /**
     * @return el nº total de filas de la matriz 
     */
    public int getFilas()
    {
        return matriz.length;
    }

    /**
     * @return el nº total de columnas de la matriz 
     */
    public int getColumnas()
    {
        return matriz[0].length;
    }

    /**
     *  deja un valor en la fila y columna indicadas como parámetro
     *  asumimos f y c correctos
     *
     */
    public void setValor(int f, int c, int valor)
    {
        matriz[f][c] = valor;
    }

    /**
     *  Representación textual de la matriz
     *
     */
    public String toString()
    {
        String texto = "";
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                texto += String.format("%4d",matriz[i][j]);
            }
            texto+= "\n";
        }
        return texto;
    }

    /**
     *  
     * Escribir la matriz bidimensional en pantalla
     */
    public void escribir()
    {
        System.out.println(this.toString());
    }

    /**
     * @param f la fila cuyos valores hay que sumar
     *          suponemos f correcto
     */
    public   int sumarFila(int f)
    {
        int suma = 0;
        //El límite de nuestro bucle for es el número de columnas de la fila recibida como parámetro
        //Valdría getColumnas(), porque sabemos que todas las filas tienen las mismas columnas
        for (int i = 0; i < matriz[f].length; i++) {
            suma+=matriz[f][i];
        }
        return suma;
    }

    /**
     * @param c la columna cuyos valores hay que sumar
     *          suponemos c correcto
     */
    public   int sumarColumna(int c)
    {
        int suma = 0;
        //En este caso el límite del for es el número de filas.
        //Para una columna dada c, recorremos todas las filas
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][c];
        }
        return suma;
    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las filas de matriz
     */
    public  int[] sumarFilas()
    {
        int[] arraySumaFilas = new int[getFilas()];
        for (int i = 0; i < getFilas(); i++) {
            arraySumaFilas[i] = sumarFila(i);//Aprovechamos las funciones anteriores
        }
        return arraySumaFilas;

    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las columnas de matriz
     */
    public  int[] sumarColumnas()
    {
        int[] arraySumaColumnas = new int[getColumnas()];
        for (int i = 0; i < getColumnas(); i++) {
            arraySumaColumnas[i]=sumarColumna(i);
        }
        return arraySumaColumnas;

    }
    /**
     * @return calcula y devuelve la suma de la diagonal principal (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalPrincipal()
    {
        int suma = 0;
        //La diagonal principal se corresponde con los elementos de posiciones [0][0], [1][1], [2][2], etc...
        for (int i = 0; i < getFilas(); i++) {//Uso getFilas, pero como es cuadrada valdría también getColumnas()
            suma += matriz[i][i];
        }
        return suma;
    }

    /**
     * @return calcula y devuelve la suma de la diagonal secundaria (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalSecundaria()
    {
        int suma = 0;
        int col = getColumnas();
        //La diagonal secundaria se corresponde con las posiciones (imaginando una matriz de 3x3)
        //[0,2],[1,1],[2,0]- Es decir, empezando en la fila 0 y en la última columna
        //vamos incrementando la fila y decrementando la columna
        col --; //Empezamos con la columna getColumnas -1 (la última columna)
        for (int i = 0; i < getFilas(); i++) {
            suma += matriz[i][col];
            col--; //El i++ lo hace el for
        }
        return suma;
    }

    /**
     * En esta versión mostramos el uso de un for con varias variables, condiciones, y/o incrementos/decrementos
     */
    public   int sumarDiagonalSecundariaV2()
    {
        int suma = 0;
        //For con dos variables
        // No añado condición para col,porque la matriz es cuadrada y no es necesario
        for (int fila = 0, col = getColumnas()-1; fila < getFilas(); fila++, col--) {
            suma += matriz[fila][col];
        }
        return suma;
    }
    /**
     *   1  22  3   44
     *   3  7   5   11
     *   4  5   6   9
     *   La traspuesta es
     *   1   3   4
     *   22  7   5
     *   3   5   6
     *   44  11   9
     */
    public  int[][] traspuesta()
    {
        int[][] traspuesta = new int[getColumnas()][getFilas()];

        //Recorremos la matriz original invirtiendo los for de filas y columnas, para copiarlos a la traspuesta
        for (int col = 0; col < getColumnas(); col++) {
            for (int fila = 0; fila < getFilas(); fila++) {
                /**
                 * Estamos haciendo esto:
                 * Original-->Traspuesta
                 * [0][0] --> [0][0]
                 * [1][0] --> [0][1]
                 * [2][0] --> [0][2]
                 * etc
                 */
                traspuesta[col][fila] = matriz[fila][col];
            }
        }
        return traspuesta;
    }

    /**
     * Calcula y devuelve la posición de la columna con suma máxima
     * Puedes ayudarte del método sumarColumna()
     */
    public  int columnaSumaMaxima()
    {
        int sumaMax = Integer.MIN_VALUE;
        int colMax = -1;
        for (int col = 0; col < getColumnas(); col++) {
            int sumaCol = sumarColumna(col);
            if(sumaCol > sumaMax){
                sumaMax = sumaCol;
                colMax = col;
            }
        }
        //OJO: No devolvemos la suma Máxima, sino la columna a la que corresponde dicha suma
        return colMax;
    }
    /**
     * Intercambia la columna de suma máxima con la primera columna
     * Si son la misma no hace falta el intercambio
     */
    public  void intercambiar()
    {
        int colMax = columnaSumaMaxima();
        if(colMax != 0){ //Compruebo que no sea ya la primera columna
            for (int fila = 0; fila < getFilas(); fila++) {//Recorremos la columna, fila por fila
                //Iremos intercambiando elemento a elemento, usando una variable auxiliar, como de costumbre
                int aux = matriz[fila][0];
                matriz[fila][0] = matriz[fila][colMax];
                matriz[fila][colMax] = aux;
            }
        }
    }

    /**
     *  Devuelve un ragged array donde la 1ª fila
     *  contiene el primer elemento de la 1ª fila de matriz,
     *  la 2ª fila los 2 primeros elementos de la 2ª fila de matriz, 
     *  la 3ª fila los 3 primeros elementos de la 3ª fila de matriz, ...
     *  1   2   3   4   
     *  14  5   26  7   
     *  17  8   19  10  
     *  10  11  12  13  
     *  Resultado
     *  [1]
     *  [14, 5]
     *  [17, 8, 19]
     *  [10, 11, 12, 13]
     *  
     */
    public int[][] arrayRagged()
    {
        int[][] ragged = new int[getFilas()][]; //No indicamos la segunda dimensión, porque será variable
        for (int i = 0; i < getFilas(); i++) {
            ragged[i] = new int[i+1];//Para cada fila del ragged, vamos reservando el espacio que corresponde
            for (int j = 0; j < i + 1; j++) {
                ragged[i][j] = matriz[i][j];
            }
        }

        return ragged;
    }

    //Versión con Arrays.copyOf para ahorrarnos el bucle interno y la inicialización
    public int[][] arrayRaggedV2()
    {
        int[][] ragged = new int[getFilas()][];
        for (int i = 0; i < getFilas(); i++) {
            ragged[i] = Arrays.copyOf(matriz[i], i+1);
        }
        return ragged;
    }

    /**
     *  Muestra el array pero de la forma indicada. Cada nº formateado a 5 posiciones.
     *  Usa las constantes definidas en la clase
     *  
     *  {   {    1,     2,     3,     4    }
     *      {   14,     5,    26,     7    }
     *      {   17,     8,    19,    10    }
     *      {   10,    11,    12,    13    }    }

     */
    public void escribirConLlaves()
    {
        String texto = String.format("%5s",LLAVE_APERTURA);
        for (int i = 0; i < getFilas(); i++) {
            int espaciosPrevio = 5;
            if(i != 0){
                espaciosPrevio = 10;
            }
            texto += String.format("%"+espaciosPrevio+"s",LLAVE_APERTURA);
            for (int j = 0; j < getColumnas(); j++) {
                texto += String.format("%5d",matriz[i][j]);
                if(j<getColumnas()-1){
                    texto += ", ";
                }
            }
            texto += String.format("%5s",LLAVE_CIERRE);
            if(i<getFilas()-1){
                texto += "\n";
            }
        }


        texto += String.format("%5s\n",LLAVE_CIERRE);
        System.out.println(texto);
    }

    /**
     *  Calcula y devuelve el total de impares en el array
     *  Hay que hacer uso del método contarImpares(int[], int n)
     *
     */
    public int contarImpares()
    {

        int totalImpares = 0;
        for (int i = 0; i < getFilas(); i++) {
            totalImpares += contarImpares(matriz[i]);
        }
        return totalImpares;
    }

    /**
     *  Cuenta los impares en el array unidimensional recibido
     *   
     *
     */
    private int contarImpares(int[] array)
    {
        int numImpares = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0)
                numImpares++;
        }
        return numImpares;
    }

    /**
     *  Devuelve el subarray obtenido a partir de matriz entre las filas fila1 y fila2
     *  y columnas col1 y col2 (ambas inclusive)
     *  Asumimos todos los valores correctos
     *  13  20  30  25  16  
     *  12  27  24  17  27  
     *  3   12  11  28  29  
     *  21  11  20  25  8   

     *  Subarray desde filas  1 a  3 y columnas 2 a 3
     *  [24, 17]
     *  [11, 28]
     *  [20, 25]
     *  
     *
     */
    public  int [][] obtenerSubArray(int fila1, int fila2, int col1, int col2)
    {
        int numFilas = fila2 - fila1 +1;
        int numColumnas = col2 - col1 + 1;
        int[][] subArray = new int[numFilas][numColumnas];

        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numColumnas; c++) {
                subArray[f][c] = matriz[f+fila1][c+col1];
            }
        }
        return subArray;

    } 

}
