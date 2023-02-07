import java.util.Arrays;
import java.util.Random;

/**
 *  
 * Representa a un CD 
 */
public class CD
{
    private String titulo;
    private String artista;       
    
    private Cancion[] canciones;
    private int pos; // total canciones en el CD

    /**
     * Constructor  
     */
    public CD(int n, String titulo, String artista)
    {
        canciones = new Cancion[n];
        pos = 0;
        this.titulo = titulo;
        this.artista = artista;
    }

    /**
     *  añade una canción al CD  solo si no está completo
     * 
     * @param  c la canción a añadir 
     * 
     */
    public void addCancion(Cancion c)
    {
         canciones[pos] = c;
         pos++;
    }

    /**
     *  añade una canción al CD  solo si no está completo
     * 
     * @param  titulo el título de  la canción a añadir 
     * @param  duracion la duración de  la canción a añadir 
     * 
     */
    public void addCancion(String titulo, double duracion)
    {
        if(!estaCompleto()){
            Cancion temazo = new Cancion(titulo, duracion);
            addCancion(temazo);
        }
    }

    /**
     * devuelve true si el cd está lleno
     */
    public  boolean estaCompleto()
    {
        return canciones.length == pos;
    }

    /**
     * devuelve el total de canciones en el CD
     */
    public  int totalCanciones()
    {
        return pos;
    }


    /**
     * Duración total del CD
     */
    public  double duracionTotal()
    {
        double total = 0;
        for (int i = 0; i < pos; i++) {
            total += canciones[i].getDuracion();
        }
        return total;
    }

    /**
     * Devuelve una canción aleatoria del CD
     */
    public  Cancion getAleatoria()
    {
        //generamos un número aleatorio dentro del rango de posiciones con canciones
        // dentro del cd (de 0 a pos-1),
        // y devolvemos la Cancion de la posición aleatoria generada
         Random generador = new Random();
         int posicionAleatoria = generador.nextInt(pos);
         return canciones[posicionAleatoria];
    }

    /**
     * Devuelve un  array con los títulos de las canciones en mayúsculas
     */
    public  String[] getTitulos()
    {
        String[] titulos =  new String[pos];
        for (int i = 0; i < pos; i++) {
            titulos[i] = canciones[i].getTitulo().toUpperCase();
        }
        return titulos;
    }

    /**
     * Devuelve cuántas canciones contienen en el título una cadena
     */
    public  int cancionesQueContienen(String str)
    {
        int cont = 0;
        //Para comparar con funciones que no tienen variante "ignoreCase"
        //lo que hacemos es pasar ambos String a mayúsculas, o ambos a
        //minúsculas
        str = str.toLowerCase();
        for (int i = 0; i < pos; i++) {
           if(canciones[i].getTitulo().toLowerCase().contains(str)){
               cont++;
           }
        }
        return cont;
    }

    /**
     * Borra las canciones que empiezan por una cadena devolviendo los títulos
     * que se han borrado. Si no hay ninguna se devuelve null
     */
    public  String[] borrarCancionesQueEmpiezan(String str)
    {

        str = str.toLowerCase();
        //Reservamos un array de pos String, y luego lo devolveremos truncado
        String[] borrados = new String[pos];
        int contBorrados = 0;//Con esta variable llevaremos la cuenta de cuántas se van borrando
        for (int i = 0; i < pos; i++) {
            if(canciones[i].getTitulo().toLowerCase().startsWith(str)){
                borrados[contBorrados] = canciones[i].getTitulo();
                contBorrados++;
                borrarCancion(i);
                i--;//Es un borrado múltiple. Así que si borramos, no avanzamos la i
            }
        }
        //Devolvemos sólo la parte ocupada del array
        return Arrays.copyOf(borrados, contBorrados);
    }
    /**
     * Borra una canción, la que está en la posición p
     */
    private  void borrarCancion(int p)
    {
        System.arraycopy(canciones, p+1, canciones, p, pos - p - 1);
        pos--;
    }

    /**
     * Obtener un array con las canciones ordenadas por título
     * Método de selección directa
     */
    public  Cancion[] cancionesOrdenadasPorTitulo()
    {
        //Cancion[] copia = Arrays.copyOf(canciones, pos);
        Cancion[] copia = new Cancion[pos];
        System.arraycopy(canciones, 0, copia, 0, pos);

        for (int i = 0; i < pos - 1; i++) {
            //Buscar el i-mínimo
            int posMin = i;
            for (int j = i+1; j < pos; j++) {
                String cancion_j = copia[j].getTitulo();
                String cancionMin = copia[posMin].getTitulo();
                if(cancion_j.compareToIgnoreCase(cancionMin)<0){
                    posMin = j;
                }
            }
            //Intercambiamos
            Cancion aux = copia[posMin];
            copia[posMin] = copia[i];
            copia[i] = aux;
        }

        return copia;

    }
	
	 /**
     *  Crea  y devuelve un nuevo CD con las canciones ordenadas por título
     *
     */
    public CD crearNuevoCD()
    {
        CD copia = new CD(pos, titulo, artista);
        Cancion[] ordenadas = cancionesOrdenadasPorTitulo();
        for (int i = 0; i < ordenadas.length; i++) {//Valdría ir hasta pos
            copia.addCancion(ordenadas[i]);
        }
        return copia;
    }
      
    /**
     * Representación textual del CD
     * De forma eficiente usando StringBuilder
     */
    public  String toString()
    {
        StringBuilder sb = new StringBuilder("Título del CD: " + titulo + "\n");
        sb.append("Artista: " + artista).append("\n");
        for (int i = 0; i < pos; i++) {
            sb.append(canciones[i].toString());
        }
        return sb.toString();
        
    }
}
