import java.util.Arrays;
import java.util.List;

public class TestListaNumeros {
    public static void main(String args[]) {
        ListaNumeros lista = new ListaNumeros();
        List<Integer> datos = Arrays.asList(4, 6, 7, 8, 3, 2, 1, 9, 80);
        for (int i : datos) {
            lista.add(i);
        }
        lista.salvarEnFicheroDeTexto("numeros.txt");

        lista.borrarLista();
        lista.leerFicheroDeTexto("numeros.txt");
        if (!lista.estaVacia()) {
            System.out.println("Después de leerFicheroDeTexto() con BufferedReader");
            System.out.println(lista.toString() + "\n");
        }
        lista.borrarLista();

        lista.leerFicheroDeTextoConScanner("numeros.txt");
        if (!lista.estaVacia()) {
            System.out.println("Después de leerFicheroDeTextoConScanner()");
            System.out.println(lista.toString() + "\n");
        }
        lista.borrarLista();

    }
}
