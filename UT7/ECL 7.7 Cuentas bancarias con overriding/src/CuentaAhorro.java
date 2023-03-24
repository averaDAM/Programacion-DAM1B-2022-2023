/**
 * Un cuenta de ahorro es una cuenta bancaria con un tipo de interés aplicado.
 */
public class CuentaAhorro extends Cuenta{
    private int tipoInteres;

    public CuentaAhorro(String nombre, double importe, int tipoInteres) {
        super(nombre, importe);
        this.tipoInteres = tipoInteres;
    }

    /**
     * Devuelve el interés resultante (el tipo aplicado al importe)
     * @return
     */
    public double obtenerInteres(){
        //Uso 100.0 para forzar a que el resultado sea double y no se trunquen los decimales.
        //Valdría también haber definido el atributo tipoInteres como double
        return tipoInteres * getImporte() / 100.0;
    }

    public String toString() {
        return super.toString() +
                "Interés aplicado: (" + tipoInteres + ") " + obtenerInteres() + "\n";
    }
}
