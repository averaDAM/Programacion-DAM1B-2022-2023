package concesionario.modelo;

import java.awt.*;

/**
 * Representa a un taxi
 */

public class Taxi extends Coche{
    private int numPlazas;

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public Taxi(String conductor, String modelo, String color,
                Point posicion, int numPlazas) {
        super(conductor, modelo, color, posicion);
        this.numPlazas = numPlazas;
    }

    @Override
    public void avanza() {
        double aleatorio = Math.random();
        int incrementoX = 0;

        //Si el aleatorio es >= 0.7 se incrementa la x en 50. Si no, en 30
        if(aleatorio >= 0.33) incrementoX = 35;
        else incrementoX = 15;

        //Para modificar el valor de las coordenadas de un punto podemos
        // usar la función translate, que recibe los incrementos para x e y
        muevete(incrementoX);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Plazas " + numPlazas + "\n";
    }
}
