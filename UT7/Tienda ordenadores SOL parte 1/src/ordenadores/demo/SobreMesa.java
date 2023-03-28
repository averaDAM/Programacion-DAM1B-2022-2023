package ordenadores.demo;

/**
 * @author
 */
public class SobreMesa extends Ordenador{
    private String descripcionTorre;

    public SobreMesa(String codigo, double precio, String slogan, String descripcionTorre) {
        super(codigo, precio, slogan);
        this.descripcionTorre = descripcionTorre;
    }

    public String getDescripcionTorre() {
        return descripcionTorre;
    }

    public void setDescripcionTorre(String descripcionTorre) {
        this.descripcionTorre = descripcionTorre;
    }

    @Override
    public String toString() {
        return super.toString() + "Descripción de la torre: " + descripcionTorre + "\n";
    }
}
