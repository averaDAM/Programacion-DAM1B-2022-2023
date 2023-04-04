/**
 * La clase Video representa a un objeto Video. Se puede almacenar
 *  y recuperar la información sobre un vídeo.
 */
public class Video extends Articulo 
{
    private String formato;

    /**
     * Constructor de objetos de la clase Video
     */
    public Video(String elTitulo, String elFormato, int duracion)
    {
        super(elTitulo, duracion);
        formato = elFormato;
    }

    /**
     * Devolver el formato del vídeo
     */
    public String getFormato()
    {
        return formato;
    }
    
     /**
     * Escribir detalles sobre el CD
     * Redefinir print()
     */
    public void print()
    {
        super.print();
        System.out.println("Formato vídeo    " + getFormato());
         
    }
}
