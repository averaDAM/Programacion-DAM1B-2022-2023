
/**
 * Modela una clase Libreria 
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Libreria
{

    private String nombre;
    private ArrayList<Libro> libros;

    /**
     * Constructor de la clase Libreria
     */
    public Libreria(String nombre)
    {
        this.nombre = nombre;
        libros = new ArrayList<>();
    }

    /**
     * Accesor para el nombre
     *
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return la cantidad de libros en la librería
     *
     */
    public int  numeroLibros()
    {
        return libros.size();
    }

    /**
     * Añade un nuevo libro
     * @param l el libro a añadir
     */
    public void addLibro(Libro l)
    {
        libros.add(l);
    }

    /**
     * Localizar un libro dado su título
     * @return el libro buscado o null si no
     * se encuentra
     */
    public Libro localizarLibro(String titulo)
    {
        Iterator<Libro> itLibros = libros.iterator();
        while (itLibros.hasNext()) {
            Libro l = itLibros.next();
            if(l.getTitulo().equals(titulo)){
                return l;
            }
        }
        //Llegado a este punto, significa que el título recibido no está en la lista
        return null;
    }

    /**
     * @param autor el autor a buscar
     * @return true si hay en la librería libros
     * del autor dado
     */
    public boolean hayLibrosDe(String autor)
    {
        int i = 0;
        while(i < numeroLibros()){
            if(libros.get(i).getAutor().equals(autor)){
                return true; //Terminamos en cuanto encontramos el primer libro del autor. No seguimos recorriendo
            }
            i++;
        }
        //Llegado a este punto, significa que no hay libros del autor en la lista
        return false;
    }

    /**
     * Borrar los libros de un determinado autor
     * @param autor el autor cuyos libros se borrarán
     */
    public void borrarLibrosDe(String autor)
    {
        if(!hayLibrosDe(autor)){
            System.out.println("No existen libros de " + autor);
        }
        else{
            //Se pide hacerlo con índices. Tenemos que tener en cuenta
            //que es un BORRADO MÚLTIPLE: puede haber varios libros del autor, y pueden estar consecutivos

            //Yo lo hago con un while de derecha a izquierda
            int i = numeroLibros() - 1;
            while(i>=0){
                if(libros.get(i).getAutor().equals(autor)){
                    libros.remove(i);
                }
                i--;//Al ser de derecha a izquierda NO tenemos que condicionar el avance en la lista
            }
        }
    }

    /**
     * Mostar libros prestados
     *
     */
    public void listarPrestados()
    {
        for (Libro l : libros) {
            if(l.estaPrestado()){
                System.out.println(l.getTitulo() + "\n");
            }
        }
    }

    /**
     * Prestar un libro de un determinado título
     */
    public void prestarTitulo(String titulo)
    {
        Libro l = localizarLibro(titulo);
        if(l == null) {//Si el título NO está en la biblioteca
            System.out.println("No hay ningún libro de título \"" + titulo + "\" en la biblioteca");
        }
        else{
            if (l.estaPrestado()){
                System.out.println("El libro NO está disponible");
            }
            else{
                l.prestar();
            }
        }
    }

    /**
     * Representación textual de la librería
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("********* Librería " + nombre + " *********\n");
        sb.append("Lista de libros: \n");
        for (Libro l : libros) {
            sb.append(l + "\n"); // valdría, pero no es necesario l.toString()
        }
        return sb.toString();
    }

}
