import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase guarda en una colección ArrayList una
 * lista de números enteros
 */
public class ListaNumeros {
    // define la colección
    private List<Integer> lista;

    /**
     * Constructor  - instancia la colección
     */
    public ListaNumeros() {
        lista = new ArrayList<>();
    }

    /**
     * añade un número a la colección
     */
    public void add(int numero) {
        lista.add(numero);
    }

    /**
     * detectar si la lista está vacía
     */
    public boolean estaVacia() {
        return lista.size() == 0;
    }

    /**
     * borrar todos los elementos de la lista, dejadla vacía
     */
    public void borrarLista() {
        lista.clear();
    }

    /**
     * Crea un fichero de texto  cuyo nombre se
     * pasa como argumento
     * Para crear el fichero recorreremos la colección y
     * guardaremos cada nº de la lista en el fichero, un nº por línea
     *
     * Capturamos las excepciones que se puedan producir
     */
    public void salvarEnFicheroDeTexto(String nombre) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)));
            for (Integer n : lista) {
                salida.println(n);
            }
        } catch (IOException e) {
            System.out.println("Error al inicializar el Fichero: " + e.getMessage());
        }
        finally {
            salida.close();//Muy importante!. Podemos ahorrárnoslo con un try-with-resources
        }

    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando BufferedReader
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTexto(String nombre) {

        File f = new File(nombre);
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null) {
                add(Integer.parseInt(linea.trim()));
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al inicializar el flujo de lectura: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer una  nueva línea: " + e.getMessage());
        } finally {
            try {
                entrada.close(); //la función close(), en el flujo FileReader, también puede generar una IOException
            } catch (IOException e) {
                System.out.println("Error al cerrar el flujo de entrada: " + e.getMessage());
            }
        }

    }


    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando Scanner
     *
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTextoConScanner(String nombre) {
        File f = new File(nombre);
        //Lo hago con un try-with-resources, que me permite no tener que incluir un finally
        try (Scanner entrada = new Scanner(f)){

            while(entrada.hasNextInt()){
                add(entrada.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado con Scanner: " + e.getMessage());
        }



    }

    /**
     * Representación textual de la colecció<n>	</n>
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de números\n");
        for (Integer n : lista) {
            sb.append(n + " ");
        }
        return sb.toString();
    }

    /**
     * Muestra la lista en pantalla
     */
    public void mostrarLista() {
        System.out.println(this.toString());
    }


}
