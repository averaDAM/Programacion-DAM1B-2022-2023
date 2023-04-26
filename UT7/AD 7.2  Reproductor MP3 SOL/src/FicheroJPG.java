/**
 * clase FicheroJPG  
 *
 */
public class FicheroJPG extends FicheroImagen{
    Compresion compresion;

    /**
     * Constructor de la clase FicheroJPG
     */
    public FicheroJPG(String titulo, int tama�o, Compresion compresion) {
        super(titulo,tama�o);
        this.compresion=compresion;
    }

    /**
     *
     */
    public Compresion getCompresion() {
        return compresion;
    }

    /**
     *
     */
    public void display() {
        super.display();
        System.out.println("Compresi�n: " + compresion.toString());
    }
}
