import java.awt.*;

/**
 * Representa a un cuadrado
 *
 *
 */

public class Cuadrado extends Figura{
    private int lado;
    /**
     * Constructor de la clase Cuadrado
     *
     *
     */
    public Cuadrado(int x, int y, Color c, int lado) {
        super(x, y, c);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado: " + lado + "\n";
    }
}
