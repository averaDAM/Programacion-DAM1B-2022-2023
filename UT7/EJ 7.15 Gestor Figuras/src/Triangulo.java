import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Modela un triángulo
 *
 */


public class Triangulo extends Figura{
    private int lado1;
    private int lado2;
    private int lado3;

    /**
     * Constructor de la clase Triángulo
     *
     */
    public Triangulo(int x, int y, Color c, int lado1, int lado2, int lado3) {
        super(x, y, c);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double sp = calcularPerimetro() / 2;
        return Math.sqrt(sp*(sp-lado1)*(sp-lado2)*(sp-lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado1: " + lado1 + "\n" +
                "Lado2: " + lado2 + "\n" +
                "Lado3: " + lado3 + "\n";
    }

    /**
     * Los triángulos, además de ser figuras iguales, deben tener los 3 lados iguales
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        //Si no son figuras iguales según el criterio general de Figura, ya no seguimos
        if(!super.equals(o)){
            return false;
        }

        //Comparamos los 3 lados.
        //Para que sea independiente del orden en que se han asignado, previamente los ordenamos
        List<Integer> ladosT1 = new ArrayList<>();
        ladosT1.addAll(Arrays.asList(lado1, lado2, lado3));
        ladosT1.sort(null);

        List<Integer> ladosT2 = new ArrayList<>();
        ladosT2.addAll(Arrays.asList(lado1, lado2, lado3));
        Collections.sort(ladosT2);

        //El método equals de List ya compara elemento a elemento de ambas listas
        return ladosT1.equals(ladosT2);
    }

    /**
     * Si se sobreescribe equals() hay que sobreescribir HashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode() + lado1 + lado2 + lado3;
    }
}

