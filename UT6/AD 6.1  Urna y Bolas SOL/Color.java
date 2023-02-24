import java.util.Random;

public enum Color {
    BLANCO, NEGRO;

    public static Color getColorAleatorio(){
        Color[] colores = Color.values();
        Random generador = new Random();
        int posAleatoria = generador.nextInt(colores.length);
        return colores[posAleatoria];
    }
}
