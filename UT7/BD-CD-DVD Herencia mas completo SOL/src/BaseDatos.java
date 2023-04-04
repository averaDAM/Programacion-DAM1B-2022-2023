/**
 * La clase BaseDatos almacena objetos CD y Videos. 
 * Se puede imprimir una lista de CD y Videos.
 * Esta versi?n no guarda los datos en el disco y no proporciona
 * m?todos de b?squeda.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {
    private ArrayList<Articulo> articulos;

    /**
     * Construir una base de datos vac?a
     */
    public BaseDatos() {
        articulos = new ArrayList<>();
    }

    /**
     * A?adir un art?culo a la base da datos
     */
    public void addArticulo(Articulo elArticulo) {
        articulos.add(elArticulo);
    }

    /**
     * Imprimir una lista de tods los articulos almacenados, CD y Videos
     */
    public void listar() {
        for (Articulo articulo : articulos) {
            articulo.print();
        }
    }

    /**
     * devuelve la cantidad de DVD en la base de datos
     *
     */
    public int totalDVD() {
        int cont = 0;
        for (Articulo art : articulos) {
            if(art instanceof DVD)
                cont++;
        }
        return cont;
    }

    /**
     * devuelve la duración total entre todos los cd's Con iterador
     *
     */
    public int totalDuracionCD() {
        //El iterador tiene que ser de elementos Articulo. No tenemos forma (sin crear colecciones auxiliares)
        //de iterar sólo sobre sobre elementos CD
        Iterator<Articulo> itArticulos = articulos.iterator();
        int duracion = 0;
        while (itArticulos.hasNext()) {
            Articulo art = itArticulos.next();
            if(art instanceof CD){
                duracion += art.getDuracion();
            }
        }
        return duracion;
    }

    /**
     * borrar todos los cd's
     *
     *
     */
    public void borrarCD() {
        //Para borrados, lo más sencillo es usar un iterador
        Iterator<Articulo> itArticulos = articulos.iterator();
        while (itArticulos.hasNext()) {
            Articulo art = itArticulos.next();
            if(art instanceof CD){
                itArticulos.remove();
            }
        }
    }

    /**
     * cuenta los vídeos que hay con el formato indicado
     *
     */
    public int videosConFormato(String formato) {
        int cont = 0;
        for (Articulo articulo : articulos) {
            if(articulo instanceof Video){
                //Para leer el formato del vídeo necesitamos usar getFormato() de la clase Video
                //No podemos desde un artículo. No reconoce el método
                //Solución: hacemos un casting.
                //En este punto estamos completamente seguros de que no dará un ClassCastException
                // porque lo hemos verificado con instanceof
                Video v = (Video) articulo;
                if(v.getFormato().equals(formato)){
                    cont++;
                }
            }
        }
        return cont;
    }

}
