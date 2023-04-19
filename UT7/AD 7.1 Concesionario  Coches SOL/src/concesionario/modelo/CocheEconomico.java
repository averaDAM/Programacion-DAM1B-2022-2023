package concesionario.modelo;

import java.awt.*;

/**
 * Clase CocheEconomico 
 *
 */

public class CocheEconomico extends Coche{
    // sin atributos, solo los heredados
    public CocheEconomico(String conductor, String modelo, String color,
                          Point posicion) {
        super(conductor, modelo, color, posicion);
    }

    @Override
    public void avanza() {
        double aleatorio = Math.random();
        int incrementoX = 0;

        //Si el aleatorio es >= 0.7 se incrementa la x en 50. Si no, en 30
        if(aleatorio >= 0.5) incrementoX = 20;
        else incrementoX = 25;

        //Para modificar el valor de las coordenadas de un punto podemos
        // usar la función translate, que recibe los incrementos para x e y
        super.muevete(incrementoX);
    }
}


