package ut5.baraja;

public class AppBaraja {
    public static void main(String[] args) {
        //Generamos una carta aleatoria y la mostramos
        CartaBaraja carta = new CartaBaraja();
        System.out.println("Carta aleatoria generada: " + carta.toString());

        //Generamos una baraja completa
        Baraja baraja = new Baraja();
        baraja.barajar();
        System.out.println("Estado de la baraja después de crearla y barajar:");
        baraja.printBaraja();
    }
}
