import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Describe un libro de la biblioteca
 *
 */
 
public class Libro 
{
    private String titulo;
    private String autor;
    private int paginas;  
    private  Estado  estado;

    //Añadido al proyecto de partida. Recogerá la fecha de préstamo en formato dd MMM yyyy
    private String fechaPrestamo;
   
    /**
     * Constructor de la clase Libro
     * La fecha de prestamo inicialmente es vacía
     * y el estado del libro es no prestado
     * 
     */
    public Libro(String titulo, String autor, int paginas)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        estado = Estado.NOPRESTADO;
        
    }

    /**
     * 
     * @return accesor para el titulo
     *       
     */
    public String getTitulo() 
    {       
        return titulo;
    }
    
     /**
     * 
     * @return devuelve el autor
     */
    public String getAutor() 
    {        
        return autor;
    }
        
    /**
     * 
     * @return devuelve el nº de páginas 
     */
    public int getPaginas() 
    {        
        return paginas;
    }
    
    /**
     * @return devuelve el estado del libro
     */
    public  Estado         getEstado()
    {        
        return estado;
    }
       
     /**
     * Indica si está prestado
     */
    public boolean  estaPrestado()
    {        
         return estado == Estado.PRESTADO;
    }
    
    /**
     * Mutador para prestar el libro
     * Sólo se puede prestar un libro 
     * no prestado anteriormente. Utiliza el método privado
     * obtenerFechaPrestamo()n para obtener la fecha de hory
     * 
     * Al prestar un libro cambia su estado
     * y la fecha en la que se prestó
     */
    public void prestar()
    {        
        if(!estaPrestado()){ //Verificamos que el libro NO está prestado
            estado = Estado.PRESTADO; //Pasamos a estado prestado
            fechaPrestamo = obtenerFechaPrestamo();
        }
        else{
            System.out.println("El libro NO está disponible");
        }
    }
   
    /**
     * Mutador para devolver un libro
     * Sólo se puede devolver un libro 
     * prestado anteriormente
     * Al prestar un libro cambia su estado
     * y la fecha en la que se prestó vuelve 
     * a ser ""
     */
    public void devolver()
    {        
       
        
        
    }
    
    /**
     * @return la fecha de préstamo que es la fecha actual
     *          en formato String
     */
    private String obtenerFechaPrestamo()
    {
        //Declaramos un localDate con la fecha de hoy (now).
        // Fijaros que no se usa new, sino una función estática de LocalDate
        LocalDate hoy = LocalDate.now();
        //Creamos el formateador para pasarlo a String en el formato deseado
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd MMM yyyy");
        //Aplicamos el formateador al objeto LocalDate con la función format()
        String hoyFormateado = hoy.format(formateador);
        return hoyFormateado;
    }
    
    /**
     * 
     * @return representación textual del libro
     */
     public String toString()
     {
        String str = "";
        str = str + "Titulo: " + getTitulo() +
                    "\nAutor: " + getAutor() +
                    "\nNº pagina: " + getPaginas() + 
                    "\nEstado " + estado.toString() + "\n";
        
        return str;
    }

    
    
    
}
