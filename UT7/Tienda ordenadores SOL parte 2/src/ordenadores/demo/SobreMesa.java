package ordenadores.demo;

/**
 * @author
 */
public class SobreMesa extends Ordenador{
    private final int DESCUENTO = 10;
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
    public double calcularDescuento() {
        return getPrecio() * DESCUENTO / 100;
    }

    @Override
    public String toString() {
        return super.toString() + "Descripción de la torre: " + descripcionTorre + "\n";
    }
}
