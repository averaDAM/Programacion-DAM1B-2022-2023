import java.awt.*;

/**
 * Clase Figura 
 *
 *
 */


public abstract class Figura implements Comparable<Figura>{

    private Point centro;
    private Color color;

    /**
     * Constructor de la clase Figura
     * Toda figura tiene un centro y un color
     *
     */
    public Figura(int x, int y, Color c) {
        centro = new Point(x, y);
        color = c;
    }


    /**
     *
     *  Accesor para el centro de la figura
     *  @return el centro de la figura
     */
    public Point getCentro() {
        return centro;
    }

    /**
     *
     * Accesor para el color de la figura
     *  @return el color de la figura
     */
    public Color getColor() {
        return color;
    }


    //Métodos abstractos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    /**
     *
     *  Representación textual de una figura
     *
     *
     */
    public String toString() {
        return "Tipo Figura: " + getClass().getSimpleName() + "\n" +
                "Centro: " + centro + "\n" +
                "Color: " + color + "\n" +
                "Área: " + calcularArea() + "\n" +
                "Perímetro: " + calcularPerimetro() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        //Código estándar. No suele cambiar
        if(o == null) return false;
        if(o == this) return true;
        if(this.getClass() != o.getClass()) return false;

        //Código específico de nuestro criterio de igualdad
        //Para acceder a los getters de Figura necesitamos hacer un casting del Object o
        Figura otra = (Figura) o;
        return this.getColor().equals(otra.getColor()) &&
                this.calcularArea() == otra.calcularArea();
    }

    //Dos objetos iguales para equals() deben tener el mismo HashCode
    //Por tanto, hashCode() debe devolver el mismo número para dos objetos iguales
    @Override
    public int hashCode() {
        return (int)calcularArea() + color.hashCode() * 13;
    }

    @Override
    public int compareTo(Figura o) {
        //Las áreas son doubles. Y no queremos que se trunquen decimales en la comparación
        //así que usamos el compare de Double, que ya compara con decimales
        return Double.compare(this.calcularArea(), o.calcularArea());
    }

}
