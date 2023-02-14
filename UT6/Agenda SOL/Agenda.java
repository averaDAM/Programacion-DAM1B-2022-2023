import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Una clase que mantiene una lista
 * con un nº arbitrario de notas.
 * Las notas se numeran de forma externa
 * por el usuario
 */
public class Agenda {
    // Almacén de notas
    private ArrayList<String> notas;

    /**
     * Constructor
     */
    public Agenda() {
        notas = new ArrayList<>();
    }

    /**
     * Almacenar una nueva nota
     *
     * @param nota La nota que se almacena
     */
    public void apuntarNota(String nota) {
        notas.add(nota);
    }

    /**
     * @return El nº de notas actualmente almacenadas
     */
    public int numeroNotas() {
        return notas.size();
    }

    /**
     * Mostrar una nota
     *
     * @param numeroNota El nº de nota a mostrar
     *                   Si numeroNota es incorrecto mostrar mensaje de error
     */
    public void mostrarNota(int numeroNota) {
        if (numeroNota >= 0 && numeroNota < notas.size()) {
            System.out.println(notas.get(numeroNota));
        } else {
            System.out.println("Índice incorrecto");
        }

    }

    /**
     * Borrar una nota
     * Si numeroNota es incorrecto mostrar mensaje de error
     */
    public void borrarNota(int numeroNota) {
        if (numeroNota >= 0 && numeroNota < notas.size()) {
            notas.remove(numeroNota);
        } else {
            System.out.println("Índice erróneo");
        }
    }

    /**
     * Mostar todas las notas
     */
    public void listarNotas() {
        System.out.println("Lista de notas de la agenda: ");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
        }
    }

    /**
     * Mostar todas las notas con un for mejorado
     */
    public void listarNotasConForMejorado() {
        for (String n : notas) {
            System.out.println(n);
        }
    }

    /**
     * Mostar todas las notas con un iterador
     */
    public void listarNotasConIterador() {
        Iterator<String> itAgenda = notas.iterator();
        System.out.println("Lista de notas con iterador: ");
        while (itAgenda.hasNext()) {
            System.out.println(itAgenda.next());
        }
    }

    /**
     * contar las notas que contienen el parámetro
     * utilizando for mejorado
     */
    public int notasQueContienen(String str) {
        int contador = 0;
        str = str.toUpperCase();
        for (String n : notas) {
            if (n.toUpperCase().contains(str)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * borrar las notas que empiezan con el parámetro
     * utilizando un iterador
     */
    public void borrarNotasQueEmpiezanPor(String str) {
        Iterator<String> itNotas = notas.iterator();
        while (itNotas.hasNext()) {
            String n = itNotas.next();
            if (n.startsWith(str)) {
                itNotas.remove();
            }
        }
    }

    /**
     * Devolver una colección con las notas que acaban en "ria"
     * ordenadas
     * Con for mejorado
     */
    public ArrayList<String> acabanEn(String str) {
        ArrayList<String> acaban = new ArrayList<>();
        for (String n : notas) {
            if (n.endsWith(str)) {
                acaban.add(n);
            }
        }
        notas.sort(null);
        return acaban;
    }

    /**
     * Borrar las notas que estén repetidas
     * Ordenando la colección previamente , no siempre nos puede interesar
     */
    public void borrarRepetidasV1() {
        Collections.sort(notas);

        //for hasta size()-1 porque dentro referenciamos i+1,
        // y no hace falta comprobar la última posición
        for (int i = 0; i < notas.size() - 1; i++) {
            if (notas.get(i).equals(notas.get(i + 1))) {
                notas.remove(i);
                i--;
            }
        }

    }

    /**
     * Borrar las notas que estén repetidas
     * con indexOf (sin ordenar previamente)
     */
    public void borrarRepetidasV2() {
        for (int i = notas.size() - 1; i > 0; i--) {//La primera posición no es necesario comprobarla
            String notaI = notas.get(i);
            if (notas.indexOf(notaI) != i) {
                notas.remove(i);
            }
        }
    }

    /**
     * Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     */
    public void invertir() {
        int medio = numeroNotas() / 2;
        for (int i = 0; i < medio; i++) {
            int posEspejo = notas.size() - i - 1;
            //intercambiamos el elemento i con su espejo
            String aux = notas.get(i);
            notas.set(i, notas.get(posEspejo));
            notas.set(posEspejo, aux);
        }
    }

    /**
     * Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     */
    public void invertirV2() {
        Collections.reverse(notas);
    }

    /**
     * Duplica cada nota
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  ["comprar pan", "comprar pan", "comprar leche", "comprar leche", "ir dentista", "ir dentista"]
     */
    public void duplicarNotas() {
        for (int i = 0; i < numeroNotas(); i+=2) {
            String notaI = notas.get(i);
            notas.add(i + 1, notaI);
        }
    }

    /**
     * Reorganiza aleatoriamenta ls notas de la agenda
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método podría  contener ["comprar leche", ir dentista","comprar pan"]
     */
    public void reorganizar() {
        Collections.shuffle(notas);
    }

    /**
     * Coloca la primera nota al final de la lista borrándola de la primera posición
     */
    public void primeraAlFinal() {
        String primera = notas.get(0);
        notas.add(primera);
        notas.remove(0);
    }

    /**
     * Coloca la última nota al principio de la lista borrándola de la última posición
     */
    public void ultimaAlPrincipio() {
        String ultima = notas.get(notas.size()-1);
        notas.add(0, ultima);
        notas.remove(notas.size()-1);
    }

    /**
     * Devuelve la posición de la primera ocurrencia de nota
     */
    public int posicionDeLaNota(String nota) {
        return notas.indexOf(nota);
    }

    /**
     * borrar las notas que empiezan con el parámetro
     * utilizando un for mejorado  INCORRECTO
     */
    public void borrarNotasAcabanEn(String str) {
        int i=0;
        for (String n : notas) {
            if(n.startsWith(str)){
                notas.remove(n);
                //i++;
            }
        }
    }
}
