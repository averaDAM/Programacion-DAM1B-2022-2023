import java.util.Comparator;

/**
 * A�adida al proyecto base
 * Usamos dos veces este comparador, para ordenaci�n y para ordenaci�n inversa por tama�o
 * As� que genero una implementaci�n y la uso las dos veces
 */
public class ComparadorFicherosTam implements Comparator<Fichero> {

    @Override
    public int compare(Fichero o1, Fichero o2) {
        return Integer.compare(o1.getTama�o(),o2.getTama�o());
    }

}
