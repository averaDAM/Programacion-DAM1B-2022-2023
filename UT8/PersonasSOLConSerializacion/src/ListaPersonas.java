/**
 * La clase modela una lista de personas
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListaPersonas {
    private static final String NOMBRE_FICHERO = "personas.txt";
    private static final String PATH_CASADAS = "datos_casadas";
    private static final String EXT_SER = ".ser";
    private static final String LISTA_SERIALIZADA_FILE = "lista_serializada.ser";
    private List<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<>();

    }

    /**
     * añade una persona a la lista
     */
    public void add(Persona p) {

        personas.add(p);

    }

    /**
     * vacía la lista
     */
    public void clear() {
        personas.clear();
    }

    /**
     * guarda en un fichero de texto los datos de cada persona
     * Recorreremos la lista y guardaremos por cada persona sus 
     * datos en el fichero. Escribirimeos una línea
     * de texto por cada persona con formato nombre:edad:estado
     *
     *
     * Usa las clases PrintWriter, BufferedWriter, FileWriter  
     *
     * Hay que propagar las excepciones, no capturarlas
     */
    public void guardarEnFicheroDeTexto() throws IOException {
        File f = new File(NOMBRE_FICHERO);
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        for (Persona p : personas) {
            salida.println(p.getNombre() + ":" + p.getEdad() + ":" + p.getEstadoCivil());
        }
        salida.close();
    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que 
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y 
     * se crea un objeto Persona que añadiremos a la lista (usad la función parsearLinea)
     * Usa las clases  BuffererReader, FileReader  
     *
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTexto() {
        File f = new File(NOMBRE_FICHERO);
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(f));//FileReader() puede lanzar FileNotFoundException
            String linea = entrada.readLine();//readLine() puede lanzar IOException
            while(linea != null){
                personas.add(parsearLinea(linea));
                //MUY IMPORTANTE: Leer la siguiente línea. Si no, bucle infinito
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura " + e.getMessage());
        }finally {
            try {
                entrada.close();//Para flujos de entrada, puede lanzar una IOException
            } catch (IOException e) {
                System.out.println("Error al cerrar el flujo de entrada: " + e.getMessage());
            } catch (NullPointerException e){
                //Esta excepción es NO verificada.
                // Podríamos no capturarla.
                // También la podemos evitar comprobando entrada != null antes del close
                System.out.println("Flujo sin inicializar: " + e.getMessage());
            }
        }

    }

    /**
     * Lo mismo que la función anterior pero con un
     * try-with-resources
     */
    public void leerDeFicheroComoRecurso() {
        File f = new File(NOMBRE_FICHERO);

        //Al usar un try-with-resources, tenemos que capturar adicionalmente
        // la IOException que se puede disparar con el close()
        try (BufferedReader entrada = new BufferedReader(new FileReader(f))){
            String linea = entrada.readLine();
            while(linea != null){
                personas.add(parsearLinea(linea));
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que 
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y 
     * se crea un objeto Persona que añadiremos a la lista
     * Usa la clase  Scanner
     *
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTextoConScanner() {
        File f = new File(NOMBRE_FICHERO);
        try (Scanner entrada = new Scanner(f);){
            while(entrada.hasNextLine()){
                String linea = entrada.nextLine();
                personas.add(parsearLinea(linea));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado con Scanner: " + e.getMessage());
        }
    }

    /**
     *  Parsea la línea, es decir, extrae de la línea la información
     *  de una persona
     *  Si algún dato puede generar una excepción, se propaga
     */
    private Persona parsearLinea(String linea) throws NumberFormatException, ArrayIndexOutOfBoundsException, IndexOutOfBoundsException {

        //MUY IMPORTANTE: Al propagarlas, también se tiene que seguir el orden de jerarquía de más a menos específico
        //si propagamos excepciones que son ascendentes/descendentes. En este caso: ArrayIndexOutOfBounds debería estar antes
        //que la IndexOutOfBounds si queremos que la primera llegue a propagarse con su subtipo específico en caso de darse.
        // (esto, sólo si nos interesa tratar de forma distinta ArrayIndexOut de IndexOut a secas)

        String[] datos = linea.split(":");
        //La lectura de elementos de arrays puede dar una ArrayIndexOutOfBoundsException
        String nombre = datos[0].trim();
        int edad = Integer.parseInt(datos[1].trim());//Puede disparar una NumberFormatException
        char estadoCivil = datos[2].trim().charAt(0);//charAt() puede dar una IndexOutOfBoundsException

        return new Persona(nombre, edad, estadoCivil);
    }

    /**
     *  Guarda en el fichero "estadis.txt" la relación de personas solteras
     *  y el nº total de ellas
     *
     *  Se propagan (se avisa)  las excepciones que puedan ocurrir
     */
    public void guardarEstadisticas() throws IOException {
        File f = new File("estadis.txt");
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));

        int solteras = 0;
        for (Persona p : personas) {
            if(p.estaSoltera()){
                salida.println(p);
                solteras ++;
            }
        }
        salida.printf("Total solteras: %4d", solteras);

        //Si no desata la IOException, debemos cerrar el flujo aquí
        salida.close();
    }

    /**
     * representación textual de la lista de personas
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de personas\n");
        for (Persona p : personas) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Mostrar la lista
     */
    public void mostrar() {
        System.out.println(this.toString());
    }

    /**
     * Añadidos para practicar Serialización/Deserialización
     */

    /**
     * Escribe las personas casadas usando serialización
     * cada persona en un fichero propio: /datos_casadas/<nombre>.ser
     * Captura las excepciones verificadas
     */
    public void serializarCasadasIndividual(){
        //Creamos el objeto Path con la ruta del directorio
        //Le paso la ruta por partes. También se puede pasar completa, pero escapando las \
        Path directorio = Path.of(".", PATH_CASADAS);
        try {
            //Files.createDirectories crea todos los directorios que no existan, dada una ruta
            Files.createDirectories(directorio);
        } catch (IOException e) {
            System.out.println("Error al crear el directorio");
        }

        for (Persona p : personas) {
            if(!p.estaSoltera()){
                String archivo = p.getNombre() + EXT_SER;
                //File() puede recibir la ruta del fichero o directorio por partes
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(
                        new File(directorio.toFile(), archivo)));){
                    salida.writeObject(p);
                } catch (IOException e) {
                    System.out.println("Error al serializar: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Lee uno a uno los ficheros del directorio donde están los casados serializados
     * individualmente, cada uno en un archivo
     * Capturamos las excepciones verificadas
     */
    public void deserializarCasadasIndividual(){
        //File también sirve para apuntar a un directorio
        File directorio = new File(PATH_CASADAS);
        //listFiles, si file es un directorio, nos devuelve un array de elementos File con sus archivos
        if(directorio.isDirectory()){
            File[] archivos = directorio.listFiles();
            for (File archivo : archivos) {
                try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))){
                    Object leido = entrada.readObject();//ReadObject lee y avanza el puntero
                    if(leido instanceof Persona){//No está de más esta comprobación. O podemos capturar las ClassCastException
                        personas.add((Persona)leido);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Fichero no encontrado al deserializar: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Error de lectura de fichero al deserializar: " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("No existe la clase deserializada: " + e.getMessage());
                }
            }
        }
    }

    /**
     * En este caso, serializa el objeto List completo
     */
    public void serializarLista(){
        try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(new File(LISTA_SERIALIZADA_FILE)));) {
            if(!personas.isEmpty()){
                salida.writeObject(personas);
            }

        } catch (IOException e) {
            System.out.println("Error al inicializar el fichero para serialización de la lista: " + e.getMessage());
        }
    }

    /**
     * Deserializa la lista completa y apunta nuestra lista hacia la lista recuperada de fichero
     */
    public void deserializarLista(){
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(new File(LISTA_SERIALIZADA_FILE)));) {
            Object objeto = entrada.readObject();
            personas = (ArrayList<Persona>)objeto;
        } catch (IOException e) {
            System.out.println("Error al inicializar el fichero para serialización de la lista: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase deserializada: " + e.getMessage());
        } catch(ClassCastException e){//No necesaria, pero creo que interesante en este caso
            System.out.println("Error al hacer el casting deseerializando la lista: " + e.getMessage());
        }
    }
}
