import java.awt.*;

/**
 * Modela un círculo de radio determinado
 *
 *
 */

public class Circulo extends Figura{

    private double radio;

    /**
     * Constructor de la clase Circulo
     *
     */
    public Circulo(int x, int y, Color c, double radio) {
        super(x, y, c);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    /**
     *
     * @return el valor del radio
     */
    public double getRadio() {
        return radio;
    }

    @Override
    public String toString() {
        return super.toString() +
        "Radio: " + radio + "\n";
    }
}
