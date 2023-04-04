import java.util.Comparator;

/**
 * Implementaci�n CON NOMBRE de Comparator
 * Puede ser �til si vamos a usar a menudo este criterio de ordenaci�n o comparaci�n
 * en varios puntos de nuestros proyectos
 *
 */
public class FigurasComparatorPerimetro implements Comparator<Figura> {
    @Override
    public int compare(Figura o1, Figura o2) {
        return Double.compare(o1.calcularArea(), o2.calcularArea());
    }
}
