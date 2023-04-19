package concesionario.modelo;

import java.awt.*;

/**
 *  clase CocheDeportivo 
 *
 */

public class CocheDeportivo extends Coche{
    //sin atributos, solo los heredados


    public CocheDeportivo(String conductor, String modelo, String color) {
        //Un deportivo SIEMPRE inicia en la posicion (0,200)
        super(conductor, modelo, color,  new Point(0, 200));
    }

    @Override
    public void avanza() {
        double aleatorio = Math.random();
        int incrementoX = 0;

        //Si el aleatorio es >= 0.7 se incrementa la x en 50. Si no, en 30
        if(aleatorio >= 0.7) incrementoX = 50;
        else incrementoX = 30;

        //Para modificar el valor de las coordenadas de un punto podemos
        // usar la función translate, que recibe los incrementos para x e y
        super.muevete(incrementoX);

        //También valdría esto
//        Point nuevo = new Point(getPosicion().x + incrementoX, getPosicion().y);
//        setPosicion(nuevo);

    }
}
      
