package ordenadores.demo;

/**
 * @author
 */
public class Portatil extends Ordenador{

    private double peso;
    private final int DESCUENTO = 2;
    /**
     * Constructor
     */
    public Portatil(String codigo, double precio, String slogan, double peso) {
        super(codigo, precio, slogan);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Implenta el método abstracto calcularDescuento de la clase Ordenador
     */
    @Override
    public double calcularDescuento() {
        return getPrecio() * DESCUENTO / 100;
    }

    @Override
    public String toString() {
        //Devuelve el toString de Ordenador + el peso
        return super.toString() + "Peso: " + peso + "\n";
    }
}
