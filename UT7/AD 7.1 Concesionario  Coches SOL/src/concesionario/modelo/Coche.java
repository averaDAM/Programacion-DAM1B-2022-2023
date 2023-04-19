package concesionario.modelo;

import java.awt.*;

/**
 * Modela un cohe
 */

public abstract class Coche {
    private String conductor;
    private String modelo;
    private String color;
    private Point posicion;

    /**
     * Constructor
     */

    public Coche(String conductor, String modelo, String color,
                 Point posicion) {
        this.conductor = conductor;
        this.modelo = modelo;
        this.color = color;
        this.posicion = posicion;
    }

    /**
     * accesor para el conductor
     */
    public String getConductor() {
        return conductor;
    }

    /**
     * accesor para el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * accesor para el color
     */
    public String getColor() {
        return color;
    }

    /**
     * accesor para la posición
     */
    public Point getPosicion() {
        return posicion;
    }

    /**
     * mutador para el conductor
     */
    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    /**
     * mutador para el modelo
     */
    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    /**
     * mutador para el color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * mutador para la posición
     */
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }


    /**
     * Representación textual del coche
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n" +
                "Conductor: " + conductor + "\n" +
                "Modelo: " + modelo + "\n" +
                "Posición: " + posicion + "\n";

    }



    @Override
    public int hashCode() {
        return (conductor.hashCode() + modelo.hashCode() + color.hashCode()) * 13;
    }

    /**
     * Dos coches se consideran iguales si tienen el mismo tipo,
     * conductor, modelo y color
     */
    @Override
    public boolean equals(Object o) {
        //Comrpobaciones estándar
        if (this == o) return true;
        if (o == null) return false;

        //Comprobaciones específicas de este enunciado
        Coche coche = (Coche) o;
        return conductor.equals(coche.conductor) &&
                modelo.equals(coche.modelo) &&
                color.equals(coche.color);
    }

    /**
     * Método abstracto avanza. No sabemos cómo avanza, depende del tipo de coche
     */
    public abstract void avanza();

    /**
     * Función añadida para que veáis que un fragmento de una función específica de
     * cada subclase (avanzar()) puede ser igual para todos, y por tanto, ser implementable
     * en la clase general. Es decir, aunque cada coche avanza de modo distinto, la llamada a
     * la función translate es común para todos.
     *
     *
     * @param incrementoX
     */
    protected void muevete(int incrementoX) {
        this.getPosicion().translate(incrementoX, 0);
    }
}
