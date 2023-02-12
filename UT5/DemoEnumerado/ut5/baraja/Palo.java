package ut5.baraja;

import java.util.Random;

public enum Palo {
    BASTOS, COPAS, ESPADAS, OROS;

    public static Palo getAleatorio() {
        Palo[] palos = Palo.values();
        Random generador = new Random();
        int posAleatoria = generador.nextInt(palos.length);
        return palos[posAleatoria];
    }
}
