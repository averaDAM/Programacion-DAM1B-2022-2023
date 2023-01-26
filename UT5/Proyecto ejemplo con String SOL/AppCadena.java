import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Clase de prueba para probar la clase Cadena
 */
public class AppCadena {
    public static void main(String[] args) {

        Cadena c = new Cadena("Hola mundo");
        System.out.println("Longitud: " + c.longitud() + "\n" +
                "Primer caracter: " + c.primerCaracter() + "\n" +
                "Último caracter: " + c.ultimoCaracter() + "\n" +
                "Caracter de posición 5: " + c.caracterDePosicion(5) + "\n" +
                "Concatenada con la cadena \" Adiós\": " + c.concatenarCon(new Cadena(" Adiós")).getCadena());

        separador();
        System.out.print("A mayúsculas: ");
        c.aMayusculas();
        System.out.print("A minúsculas: ");
        c.aMinusculas();

        separador();
        System.out.print("¿Es igual que \"Hola mundo\"? ");
        System.out.println(c.igualQue("Hola mundo"));

        System.out.print("¿Es igual que \"Hola MUNDO\"? ");
        System.out.println(c.igualQue("Hola MUNDO"));

        System.out.print("¿Es igual que \"Adiós mundo\"? ");
        System.out.println(c.igualQue("Adiós mundo"));

        separador();
        System.out.print("¿Va después que \"Hola tundo\"? " + c.mayorQue("Hola tundo"));
        System.out.print("\n¿Va después que \"Hola bundo\"? " + c.mayorQue("Hola bundo") + "\n");

        separador();
        System.out.println("Empieza por \"Hol\"? " + c.empiezaPor("Hol"));
        System.out.println("Empieza por \"hol\"? " + c.empiezaPor("hol"));

        separador();
        System.out.println("Cadena a partir de \"la\": " + c.cadenaApartirDe("la"));
        System.out.println("Tiene " + c.cuantasA() + " ocurrencias del caracter 'A'");

        separador();
        Cadena inv = c.invertir();
        System.out.println("Invertida: " + inv.getCadena());

        //Nueva cadena para pruebas de palíndromo
        separador();
        String cad = "abcdefedcba";
        c.setCadena(cad);
        System.out.println("Es palíndromo la cadena " + cad + "? " + c.esPalindromaIterativa());

        cad = "abcd dcba";
        c.setCadena(cad);
        System.out.println("Es palíndromo la cadena " + cad + "? " + c.esPalindromaIterativa());

        cad = "abcd 12 dcba";
        c.setCadena(cad);
        System.out.println("Es palíndromo la cadena " + cad + "? " + c.esPalindromaIterativa());


        separador();
        cad = "Hola mundo";
        c.setCadena(cad);
        System.out.println("3 últimos caracteres de " + cad + ": " + c.tresUltimosCaracteres());

        separador();
        System.out.println("En trozos: ");
        c.visualizarEnTrozos();
        System.out.println("En diagonal: ");
        c.visualizarEnDiagonal();
        c.visualizarEnDiagonalV2();

        separador();
        cad = "tragaldabas";
        System.out.println("Reemplazo 'a' por 'e' en " + cad);
        c.setCadena(cad);
        c.reemplazarPor('a','e');

        cad = "Lorem:ipsum:dolor:sit:amet";
        c.setCadena(cad);
        System.out.print("Número de palabras de " + cad  + " usando el separador " + Cadena.SEPARADOR + " ");
        System.out.println(c.numeroPalabras());

        separador();
        System.out.println("Apariciones de \"or\": " + c.aparicionesDe("or"));

        cad = "murciélago";
        c.setCadena(cad);
        System.out.println(cad  + " tiene " + c.contarVocales() + " vocales");

        char[][] matriz = c.cadenaToArray2D();
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }

        separador();
        cad = "Java es un lenguaje de programación orientado a objetos";
        c.setCadena(cad);
        System.out.println(cad);
        c.eliminarEspacios();
        c.sustituirPorAsterisco('o');


        separador();
        c.printPalabrasV2();

        separador();
        cad = "12 3 5 hola";
        c.setCadena(cad);
        System.out.println("Cadena: " + cad);
        System.out.println("Sus enteros suman: " + c.sumarEnteros());

    }

    private static void separador() {
        System.out.println("******************************");
    }


}
