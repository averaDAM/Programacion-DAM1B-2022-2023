
/**
 * Un objeto de esta clase modela una urna 
 * que guarda una serie de bolas blancas y/o negras
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Urna
{

    private ArrayList<Bola> urna;

    /**
     * Constructor
     */
    public Urna()
    {
        urna = new ArrayList<>();
    }

    /**
     * Añade una nueva bola a la urna
     * @param b la bola a añadir
     */
    public void meterBola(Bola b)
    {
        urna.add(b);
    }


    /**
     * Saca una bola de la urna
     * @return la bola sacada
     * @throws RuntimeException si la urna está vacía
     */
    public Bola sacarBola()
    {
        if(!urna.isEmpty()){//si la urna NO está vacía
            int posAleatoria = obtenerPosicionAleatoria(urna.size());
            return urna.get(posAleatoria);
        }
        else{//urna vacía
            throw new RuntimeException("La urna está vacía");
        }
    }

    /**
     * @return un valor que representa una posición
     *          en la urna
     * @param hasta el límite hasta el que generar valores
     *              aleatorios
     */
    private int obtenerPosicionAleatoria(int hasta)
    {
        Random generador = new Random();
        return generador.nextInt(urna.size());
    }

    /**
     *
     * @return   cantidad de bolas blancas en la urna
     */
    public int cuantasBlancas()
    {
        int cont = 0;
        for(Bola b: urna){
            if(b.esBlanca()) cont++;
        }
        return cont;
    }

    /**
     *
     * @return   cantidad de bolas negras en la urna
     */
    public int cuantasNegras()
    {
        int cont = 0;
        for (int i = 0; i < urna.size(); i++) {
            if(urna.get(i).esNegra()) cont++;
        }
        return cont;
    }

    /**
     * Muestra la urna
     *
     */
    public void mostrarUrna()
    {
        System.out.println("Estado actual de la urna: \n");
        Iterator<Bola> itUrna = urna.iterator();
        while (itUrna.hasNext()) {
            Bola b = itUrna.next();
            System.out.println(b.toString() + "\n");
        }
    }

    /**
     * Borra las bolas de color blanco
     *
     */
    public void borrarBlancas()
    {
        Iterator<Bola> itUrna = urna.iterator();
        while (itUrna.hasNext()) {
            Bola b = itUrna.next();
            if(b.esBlanca())
                itUrna.remove();
        }
    }










}
