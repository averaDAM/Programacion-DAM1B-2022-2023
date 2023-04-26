import java.text.CollationElementIterator;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

/**
 * Clase ReproductorMP3 
 *
 */

public class ReproductorMP3 {

    private List<Fichero> ficheros;
    private int capacidad;  //en bytes
    private int tamActual;

    /**
     * Constructor de la clase ReproductorMP3
     */
    public ReproductorMP3(int bytes) {
        ficheros = new ArrayList<Fichero>();
        capacidad = bytes;

        //ficheros gratis
        ficheros.add(new FicheroMusica("Cancion 1", 3155, 166));
        ficheros.add(new FicheroMusica("Cancion 2", 2029, 187));
        tamActual = 3155 + 2029;
    }

    /**
     * A�adido al proyecto base
     * Devuelve el espacio libre actual
     */
    private int espacioRestante(){
        return capacidad-tamActual;
    }

    /**
     *  a�ade un fichero al MP3 actualizando el tama�o.
     *  Antes de a�adirlo se comprueba si hay espacio en el MP3 y no hay un
     *  fichero igual.
     */
    public void addFichero(Fichero f) {
        if(!ficheros.contains(f)){
            if(f.getTama�o()<=espacioRestante()){
                ficheros.add(f);
                tamActual+=f.getTama�o();
            }
            else{
                System.out.println("No hay espacio para el fichero: ");
                f.display();
            }
        }
        else{
            System.out.println("Ya est� dentro del mp3 el fichero: ");
            f.display();
        }
    }

    /**
     *  accesor para la capacidad del MP3
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     *  borra todos los ficheros y pone el tama�o actual a 0
     */
    public void reset() {
        ficheros.clear();
        tamActual=0;
    }

    /**
     *  muestra los t�tulos de los ficheros de m�sica
     *  que hay en el MP3. Al final se muestra el total de horas, minutos y
     *  segundos de m�sica que hay
     */
    public void mostrarCanciones() {
        //Vamos a ir sumando la duraci�n total para mostrarla al final
        int duracionTotal=0;
        //Recorremos todos los ficheros, pero solo mostramos los que sean ficheros de m�sica
        for (Fichero f : ficheros) {
            if(f instanceof FicheroMusica){
                System.out.println(f.getTitulo());
                FicheroMusica fMusica=(FicheroMusica) f;
                duracionTotal += fMusica.getDuracion();
            }
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        String duracion = LocalTime.ofSecondOfDay(duracionTotal).format(df);
        System.out.println("Duraci�n total: " + duracion);
    }

    /**
     * A�adido al proyecto base
     * Pasa la duraci�n en segundos recibida como par�metro al formato
     * HH:MM:SS
     * AL FINAL NO LO USAMOS, PERO VEIS UNA POSIBLE IMPLEMENTACION
     */
    private String duracionHMS(int duracion){
        //Calculamos las horas y el resto dividiendo entre 3600 (una hora tiene 3600 segundos)
        int horas = duracion/3600;
        int segundosRest = duracion % 3600;

        //Ahora calculamos los minutos a partir del resto de segundos
        int minutos = segundosRest / 60;
        int segundos = segundosRest % 60;

        return String.format("%02d",horas) + ":" +
                String.format("%02d",minutos) + ":" +
                String.format("%02d",segundos);
    }


    /**
     *  dado un t�tulo, borra los ficheros de imagen
     *  con este t�tulo.
     *  Devuelve true o false dependiendo de si se ha borrado alguno o no
     */
    public boolean borrarFicheroImagen(String titulo) {
        //Tenemos que devolver un booleano. Puede ser que se borre m�s de uno
        boolean borrado=false;
        Iterator<Fichero> itFicheros=ficheros.iterator();
        while (itFicheros.hasNext()) {
            Fichero f = itFicheros.next();
            if(f instanceof FicheroImagen){
                //No es necesario hacer un casting
                //porque el titulo pertenece a la clase Fichero
                if(f.getTitulo().equalsIgnoreCase(titulo)){
                    itFicheros.remove();
                    borrado=true;
                }
            }
        }
        return borrado;
    }

    /**
     *  ordena aleatoriamente la lista de ficheros
     */
    public void reordenar() {
        Collections.shuffle(ficheros);
    }

    /**
     *  ordena la lista de ficheros por tama�o
     */
    public void ordenarPorTama�o() {
        //Hemos implementado un ComparadorFicherosTam. Lo usamos
        Collections.sort(ficheros, new ComparadorFicherosTam());
    }

    /**
     *  ordena la lista de ficheros por t�tulo de fichero
     *
     */
    public void ordenarPorTitulo() {
        Collections.sort(ficheros);
    }

    /**
     * ordena la lista de ficheros por tama�o de fichero
     * REPETIDA. LA COMENTO
     */
    /*
    public void ordenarPorTama�o() {

    }
    */

    /**
     * ordena la lista de ficheros por t�tulo descendente
     * (orden inverso al orden  natural)
     *
     */
    public void ordenarPorTituloDescendente() {
        Collections.sort(ficheros,Collections.reverseOrder());

        //Alternativa 1: usar un Comparator.reverseOrder() como segundo argumento
        //Collections.sort(ficheros,Comparator.reverseOrder());

        //Alternativa 2, menos eficiente:
        //Tambi�n valdr�a ordenar con sort, y luego invertir
        //ordenarPorTitulo();
        //Collections.reverse(ficheros);
    }

    /**
     * ordena la lista de ficheros por tama�o descendente
     *
     */
    public void ordenarPorTama�oDescendente() {
        //Volvemos a usar nuestro ComparadorFicherosTam
        Collections.sort(ficheros,new ComparadorFicherosTam().reversed());
    }

    /**
     * Muestra todos los ficheros del MP3
     */
    public void mostrarReproductor() {
        System.out.println();//L�nea en blanco
        for (Fichero fichero : ficheros) {
            fichero.display();
            System.out.println();//L�nea en blanco
        }
    }
}
