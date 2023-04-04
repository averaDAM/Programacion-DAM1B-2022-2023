import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Clase GestorFiguras 
 *
 *
 */


public class GestorFiguras {

    private ArrayList<Figura> figuras; // la colecci�n de figuras

    /**
     * Constructor de la clase GestorFiguras
     */
    public GestorFiguras() {
        figuras = new ArrayList<>();
    }

    /**
     *
     * @param  f una nueva figura a a�adir
     *
     */
    public void addFigura(Figura f) {
        figuras.add(f);
    }

    /**
     *
     * Mostrar todas las figuras
     */
    public void listarFiguras() {
        listarFiguras(figuras);
    }

    /**
     *
     */
    private void listarFiguras(List<Figura> figuras) {
        for (Figura f : figuras) {
            System.out.println(f);
        }
    }


    /**
     *
     *
     * @return la figura de mayor �rea
     */
    public Figura mayorArea() {
        double areaMax = -1;
        Figura figAreaMax = null;
        for (Figura f : figuras) {
            if(f.calcularArea() > areaMax){
                areaMax = f.calcularArea();
                figAreaMax = f;
            }
        }
        return figAreaMax;
    }

    /**
     *
     * @param color el color de la figura a borrar
     *
     */
    public void borrarDeColor(Color color) {
        Iterator<Figura> itFiguras = figuras.iterator();
        while (itFiguras.hasNext()) {
            Figura f = itFiguras.next();
            //Siempre debemos usar equals() para comparar referencias
            if(f.getColor().equals(color)){
                itFiguras.remove();
            }
        }
    }

    /**
     *
     * @param  f la figura con la que comparar, se borrar
     *      las que son iguales a ella
     *
     */
    public void borrarIguales(Figura f) {
        while(figuras.contains(f)){
            figuras.remove(f);
        }
    }


    /**
     * Ordenamos las figuras usando su criterio de ordenaci�n natural (el de la interfaz Comparable)
     */
    public void ordenarPorArea() {
        Collections.sort(figuras);
    }

    /**
     * Ordenamos las figuras por un criterio de ordenaci�n m�s inusual, usando una implementaci�n de Comparator
     * En esta versi�n uso la implementaci�n CON nombre de Comparator: FigurasComparatorPerimetro
     */
    public void ordenarPorPerimetro() {
        Collections.sort(figuras, new FigurasComparatorPerimetro());
    }

    /**
     * Otra versi�n de la funci�n anterior
     * En este caso usando una implementaci�n AN�NIMA de comparator
     * Puede ser �til si s�lo usamos el criterio de ordenaci�n correspondiente
     * en casos muy excepcionales, o una �nica vez
     */
    public void ordenarPorPerimetroV2() {
        Collections.sort(figuras, new Comparator<Figura>() {
            @Override
            public int compare(Figura o1, Figura o2) {
                return Double.compare(o1.calcularPerimetro(), o2.calcularPerimetro());
            }
        });
    }

    /**
     * Otra versi�n
     * Usando una funci�n lambda de Java (paradigma de programaci�n funcional)
     * M�s info: https://openwebinars.net/blog/crear-expresiones-lambda-en-java/#:~:text=Podemos%20utilizar%20expresiones%20Lambda%20con,)%20%2D%3E%20%2D(o1.
     */
    public void ordenarPorPerimetroV3() {
        Collections.sort(figuras, (f1, f2) -> Double.compare(f1.calcularPerimetro(), f2.calcularPerimetro()));
    }

}
