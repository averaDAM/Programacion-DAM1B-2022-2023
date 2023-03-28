package ordenadores.demo;

/**
 * @author
 */
public class Portatil extends Ordenador{

    private double peso;
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

    @Override
    public String toString() {
        //Devuelve el toString de Ordenador + el peso
        return super.toString() + "Peso: " + peso + "\n";
    }
}
