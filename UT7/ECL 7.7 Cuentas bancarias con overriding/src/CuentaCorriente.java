/**
 * Una cuenta corriente es una cuenta bancaria a la que se le aplicará un recargo si el importe es
 * menor que un importe mínimo exigido.
 */
public class CuentaCorriente extends Cuenta{
    private double recargo;
    private double importeMinimo;

    public CuentaCorriente(String nombre, double importe, double recargo, double importeMinimo) {
        super(nombre, importe);
        this.recargo = recargo;
        this.importeMinimo = importeMinimo;
    }

    /**
     * el recargo será 0 si la cuenta mantiene el importe mínimo.
     * Si no, se devuelve el valor del atributo recargo
     * @return el recargo
     */
    public double obtenerRecargo(){
        if(getImporte()<importeMinimo){
            return recargo;
        }
        else return 0;
    }

    public String toString() {
        return super.toString() +
                "Importe mínimo: " + importeMinimo + "\n" +
                "Recargo: " + obtenerRecargo();
    }

}
