package ut5.baraja;

import java.util.Random;

/**
 *
 */
public enum Valor {
    AS(1),

    DOS(2),

    TRES(3),

    CUATRO(4),

    CINCO(5),

    SEIS(6),

    SIETE(7),

    SOTA(10),

    CABALLO(11),

    REY(12);

    private final int valor;

    Valor(int valor) {
        this.valor = valor;
    }

    /**
     *
     */
    public int getValor() {
        return valor;
    }

    public static Valor getAleatorio() {
        Valor[] valores = Valor.values();
        Random generador = new Random();
        int posAleatoria = generador.nextInt(valores.length);
        return valores[posAleatoria];
    }

}
