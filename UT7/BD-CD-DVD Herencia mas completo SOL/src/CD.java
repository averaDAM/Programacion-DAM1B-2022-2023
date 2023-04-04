/**
 * La clase CD representa a un objeto CD. La información sobre
 * el CD se almacena y puede ser extraída.
 */
public class CD extends Articulo
{
    private String artista;
    private int numeroDePistas;

    /**
     * Constructor de los objetos de la clase CD
     */
    public CD(String elTitulo, String elArtista, int pistas, int duracion)
    {
        super(elTitulo, duracion);
        artista = elArtista;
        numeroDePistas = pistas;
    }

    /**
     * Devuelve el artista del CD
     */
    public String getArtista()
    {
        return artista;
    }

    /**
     * Devuelve el numero de pistas del CD
     */
    public int getNumeroDePistas()
    {
        return numeroDePistas;
    }

    /**
     * Escribir detalles sobre el CD
     * Redefinir print()
     */
    public void print()
    {
        super.print();
        System.out.println("Artista    " + artista);
        System.out.println("Nº pistas    " + artista);
    }
}
