package cuentas.modelo;

/**
 * Representa a una cuenta bancaria
 * Incluye la clase Cuenta en el paquete cuentas.modelo
 */
public class Cuenta {

    private double importe;

    /**
     * Si el importe es <= 0 se lanza y se avisa de la excepción
     * IllegalArgumentException
     */
    public Cuenta(double importe)  throws IllegalArgumentException {
        if(importe <= 0){
            throw new IllegalArgumentException("Importe negativo");
        }

        this.importe = importe;
    }

    /**
     * Accesor para el importe
     */
    public double getImporte() {

        return importe;
    }

    /**
     * Añadir una cantidad
     * Si la cantidad es <= 0 se lanza y se avisa de la
     * excepción IllegalArgumentException
     */
    public void ingresar(double cantidad) throws IllegalArgumentException  {
        if(cantidad <= 0)
            throw new IllegalArgumentException("Cantidad a ingresar negativa");

        importe += cantidad;

    }

    /**
     * Reintegra de la cuenta la cantidad indicada Si la cantidad es <= 0 se
     * lanza y se avisa de la excepción IllegalArgumentException
     * Si se quiere sacar más cantidad de la que hay se lanza la excepción personalizada
     * SaldoInsuficienteException
     *
     *
     */
    public void sacar(double cantidad) throws IllegalArgumentException, SaldoInsuficienteException{
        if(cantidad <= 0)
            throw new IllegalArgumentException("Cantidad a retirar incorrecta");

        if(cantidad > importe)
            throw new SaldoInsuficienteException("Saldo insuficiente");

        //Si no se han lanzado ninguna de las dos excepciones anteriores, hacemos la retirada
        importe -= cantidad;
    }

    /**
     * Representación textual de la cuenta
     */
    @Override
    public String toString() {

        return "Saldo en la cuenta: " + importe;
    }

}
