import java.util.Comparator;

/**
 * Implementación CON NOMBRE de Comparator
 * Puede ser útil si vamos a usar a menudo este criterio de ordenación o comparación
 * en varios puntos de nuestros proyectos
 *
 */
public class FigurasComparatorPerimetro implements Comparator<Figura> {
    @Override
    public int compare(Figura o1, Figura o2) {
        return Double.compare(o1.calcularArea(), o2.calcularArea());
    }
}
