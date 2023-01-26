/**
 * Ejemplo de main en clase externa
 */
public class AppBicicleta {
    public static void main(String[] args) {
        Bicicleta b1 = new Bicicleta(4,25);
        //b.marcha++; //No puedo. Marcha es privado y estoy en otra clase distinta de Bicicleta
        b1.setMarcha(b1.getMarcha() + 1);
        System.out.println(b1.toString());


        Bicicleta b2 = new Bicicleta(3,20);
        System.out.println(b2.toString());
        System.out.println("He creado hasta ahora  " + Bicicleta.getNumBicicletas());
    }
}
