import javax.sound.midi.Soundbank;

/**
 * Los métodos de instancia pueden acceder directamente a variables de instancia y métodos de instancia.
 * Los métodos de instancia pueden acceder directamente a variables de clase y métodos de clase.
 *
 * Los métodos estáticos (de clase) pueden acceder directamente a variables de clase y métodos de clase.
 *
 * Los métodos de clase NO PUEDEN acceder a variables de instancia o métodos de instancia directamente:
 *  - deben usar una referencia de objeto.
 *   - Además, los métodos de clase no pueden usar la palabra clave this ya que no hay una instancia a la que hacer referencia.
 */
public class Bicicleta {
    private int marcha;
    private int velocidad;
    //ID numérico: número correlativo de bicicleta creada.
    private int id;
    //Variable estátic (de clase) para llevar la cuenta de bicicletas creadas
    private static int numBicicletas;

    public Bicicleta(int marcha, int velocidad) {
        this.marcha = marcha;
        this.velocidad = velocidad;
        //Para asignar el num de Bici correlativo incrementamos el atributo estático y copiamos su valor resultante
        numBicicletas++;
        //Ejemplo de que los métodos de instancia pueden acceder a valores estáticos
        this.id = numBicicletas;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Podíamos haber hecho un método de instancia (no static)
    //pero como accede a un valor estático, para no confundir, mejor declaramos un método de clase
    public static int getNumBicicletas() {
        return numBicicletas;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "marcha=" + marcha +
                ", velocidad=" + velocidad +
                ", id=" + id +
                '}';
    }

    /**
     * Ejemplo de main en la propia clase
     */
    public static void main(String[] args) {
        //this.marcha ++; //No se puede usar THIS en un método de clase
        //marcha++; //Tampoco puedo referenciar directamente elementos de instancia

        //Creo un objeto de la clase, y a través de él sí que puedo acceder a sus elementos de instancia
        Bicicleta b1 = new Bicicleta(4,25);

        b1.marcha++;//Como estoy en la propia clase, puedo acceder directamente a elementos private
        System.out.println(b1);

        Bicicleta b2 = new Bicicleta(2, 15);
        System.out.println(b2.toString());
        System.out.println("Por ahora he creado " + numBicicletas + " bicis");

        //Como estoy en la propia clase, desde este método puedo modificar atributos privados
        numBicicletas = 10;
        Bicicleta b3 = new Bicicleta(1,10);
        System.out.println("Bicicleta b3: " + b3.toString());

        //Comprobamos que los valores de b2 siguen intactos
        System.out.println("Bicicleta b2: " + b2.toString());
    }
}
