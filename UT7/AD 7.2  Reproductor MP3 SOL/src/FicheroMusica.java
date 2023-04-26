
/**
 *   clase FicheroMusica  
 *
 */
public class FicheroMusica extends Fichero{
    int duracion;

    /**
     * Constructor de la clase FicheroMusica
     */
    public FicheroMusica(String titulo, int tama�o, int duracion) {
        super(titulo, tama�o);
        this.duracion = duracion;
    }

    /**
     *  devuelve la duraci�n en segundos  
     */
    public int getDuracion() {

        return duracion;
    }

    /**
     * Muestra los datos del fichero de m�sica
     * La duraci�n se muestra en formato  XX:XX  (minutos, segundos)
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Duraci�n: " + duracionAMinSecs());
    }

    /**
     * A�adido al proyecto base
     * Pasa la duraci�n en segundos como int
     * a duraci�n en minutos segundos como String
     * en formato: XX:XX
     */
    private String duracionAMinSecs(){
        int minutos=getDuracion()/60;
        int segundos=getDuracion()%60;
        return String.format("%02d",minutos) + ":" + String.format("%02d",segundos);
    }
}
