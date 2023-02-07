/**
 * clase Utilidades
 * incluye  métodos estáticos para trabajar con String
 */
public class Utilidades {

    /**
     * Dada una cadena devuelve una nueva capitalizando los caracteres de
     * tres en tres de forma
     * alterna empezando por mayúscula (mayúscula, minúscula, mayúscula,
     * minúscula, ....)
     * Ej. si la cadena recibida es "texto" devuelve "TEXto"
     * si la cadena recibida es "zapato" devuelve "ZAPato"
     * si la cadena recibida es "de" devuelve "DE"
     */

    public static String capitalizarAlterna(String cadena) {
        String retorno = "";
        int i = 0;
        boolean mayusculas = true;//Variable para ir alternando entre mayúsculas y minúsculas
        while (i <= cadena.length()) {
            int limite = Math.min(i + 3, cadena.length()); //Calculamos si podemos transformar 3 caracteres, o si quedan menos
            if (mayusculas) {
                retorno += cadena.substring(i, limite).toUpperCase();
            } else {
                retorno += cadena.substring(i, limite).toLowerCase();
            }
            mayusculas = !mayusculas;
            i += 3;
        }

        return retorno;
    }


    //Versión con for y avanzando caracter a caracter
    public static String capitalizarAlternaV2(String cadena) {
        String retorno = "";
        boolean mayusculas = true;//Variable para ir alternando entre mayúsculas y minúsculas
        for (int i = 0; i < cadena.length(); i++) { //Vamos caracter a caracter
            if(mayusculas){
                retorno += cadena.toUpperCase().charAt(i);
            }
            else{
                retorno += cadena.toLowerCase().charAt(i);
            }
            //Comprobamos si toca cambiar mayúsculas/minúsculas
            if((i+1) % 3 == 0){
                mayusculas = !mayusculas;
            }
        }

        return retorno;
    }

    /**
     * Dada una cadena devuelve true si hay letras repetidas, false en otro caso
     * Es indiferente mayúsculas o minúsculas
     * <p>
     * Pista!! puedes hacer de forma sencilla este método con ayuda de
     * indexOf y substring
     */
    public static boolean tieneLetrasRepetidas(String cadena) {
        //Vamos a trabajar en mayúsculas, para evitar las posibles diferencias. Valdría en minúsculas también
        cadena = cadena.toUpperCase();
        for (int i = 0; i < cadena.length() - 1; i++) {//El último caracter ya no es necesario comprobarlo
            char buscado = cadena.charAt(i);
            //Buscamos desde la posición del caracter en adelante
            // para evitar que indexOf nos dé la ocurrencia con la posición del propio caracter buscado
            if (cadena.indexOf(buscado, i + 1) != -1) {
                return true;
            }
        }
        //Llegados a este punto, es que no hay repeticiones
        return false;
    }

    //Versión usando substring
    public static boolean tieneLetrasRepetidasV2(String cadena) {
        cadena = cadena.toUpperCase();
        for (int i = 1; i < cadena.length(); i++) {
            char buscado = cadena.charAt(i);
            //Alternativa, si no recordamos el uso de indexOf con dos parámetros
            if (cadena.substring(i+1).indexOf(buscado) >= 0) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     */
    public static void main(String[] args) {
        String cadena = "zaPaTo";
        System.out.println(cadena + "\tCapitalizada alterna: " +
                Utilidades.capitalizarAlterna(cadena));
        cadena = "pez";
        System.out.println(cadena + "\tCapitalizada alterna: " +
                Utilidades.capitalizarAlterna(cadena));

        cadena = "vaso";
        System.out.println(cadena + "\tCapitalizada alterna: " +
                Utilidades.capitalizarAlterna(cadena));

        cadena = "Programaba";
        System.out.println(cadena + "\tCapitalizada alterna: " +
                Utilidades.capitalizarAlterna(cadena));


        cadena = "semana";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
                Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "quebrantos";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
                Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "y";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
                Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "de";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
                Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "abcedfghH";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
                Utilidades.tieneLetrasRepetidas(cadena));

    }

}
