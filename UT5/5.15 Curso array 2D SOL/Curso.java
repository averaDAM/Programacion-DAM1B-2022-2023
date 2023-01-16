import java.util.Arrays;
import java.util.Random;
import java.util.logging.Filter;

/**
 * Guarda las notas que han sacado una serie
 * de estudiantes en varias asignaturas
 */
public class Curso {
    private static final int MAX_ESTUDIANTES = 10;
    private static final int MAX_ASIGNATURAS = 6;
    private final int[][] notas;

    /**
     * Constructor
     */
    public Curso() {
        notas = new int[MAX_ESTUDIANTES][MAX_ASIGNATURAS];
        inicializar(notas);
    }

    /**
     * Código para probar la clase Curso
     */
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.escribir();
         double[] mediasPorAlumno = curso.calcularMediaPorAlumno();
         System.out.println("Media por alumno");
         System.out.println(Arrays.toString(mediasPorAlumno));
         double[] mediasPorAsignatura = curso.calcularMediaPorAsignatura();
         System.out.println("Media por asignatura");
         System.out.println(Arrays.toString(mediasPorAsignatura));
         int alumno = 7;
         System.out.println("Suspensos del alumno " + alumno
         + " = " + curso.suspensosDelAlumno(alumno));
         int asignatura = 4;
         System.out.println("Aprobados en asignatura " + asignatura +
         " = " + curso.aprobadosEnAsignatura(asignatura));

         System.out.println("Ejemplo array desigual (ragged) ");
         char[][] ragged = Curso.ejemploRagged();
         for (int fila = 0; fila < ragged.length; fila++)   {
             for (int col = 0; col < ragged[fila].length; col++)  {
                System.out.print(ragged[fila][col]);
             }
             System.out.println();
         }
    }

    /**
     * Inicializa el array con notas aleatorias entre 1 y 10 inclusive
     * Usaremos un generador
     */
    private void inicializar(int[][] notas) {
        Random generador = new Random();
        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            for (int j = 0; j < MAX_ASIGNATURAS; j++) {
                notas[i][j] = generador.nextInt(11);
            }
        }
    }

    /**
     * Representación textual de las notas
     * Cada nota formateada a 4 posiciones
     */
    public String toString() {
        String retorno = "Notas estudiantes\n";

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                retorno += String.format("%4d", notas[i][j]);
            }
            retorno += "\n";
        }
        return retorno;
    }

    /**
     * Muestra en pantalla  el array 2D
     */
    public void escribir() {
        System.out.println(this);

    }

    /**
     * Calcular la nota media por alumno
     * Recorrido por filas
     */
    public double[] calcularMediaPorAlumno() {
        double[] medias = new double[MAX_ESTUDIANTES];
        for (int i = 0; i < notas.length; i++) {
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            medias[i] = suma / notas[i].length;
        }
        return medias;
    }

    /**
     * Calcular la nota media por asignatura
     * Recorrido por columnas
     */
    public double[] calcularMediaPorAsignatura() {
        double[] medias = new double[MAX_ASIGNATURAS];
        //Intercambiamos el for que recorre filas por el que recorre columnas
        for (int i = 0; i < notas[0].length; i++) {
            double suma = 0;
            for (int j = 0; j < notas.length; j++) {
                suma += notas[j][i];//OJO A ESTO!!!
            }
            medias[i] = suma;
        }
        return medias;
    }

    /**
     * @param alumno nº de alumno
     */
    public int suspensosDelAlumno(int alumno) {
        if (alumno < 0 || alumno >= notas.length) {
            throw new IllegalArgumentException("Error en nº alumno");
        }

        int suspensos = 0;
        //Recorremos sólo la fila indicada por el parámetro alumno. Ej: alumno 3
        for (int i = 0; i < notas[alumno].length; i++) {
            if(notas[alumno][i]<5)
                suspensos ++;
        }

        return suspensos;
    }

    // /**
    // * 
    // */
     public static char[][] ejemploRagged() {
         int[] longitudFilas = {4, 2, 5, 6};
         char[][] ragged = new char[4][];
         for (int fila = 0; fila < ragged.length; fila++) {
            ragged[fila] = new char[longitudFilas[fila]];
            for (int col = 0; col < ragged[fila].length; col++)  {
                ragged[fila][col] = 'X';
            }
         }
         return ragged;
     }

    /**
     * @param asignatura nº de asignatura -
     */
    public int aprobadosEnAsignatura(int asignatura) {
        if (asignatura < 0 || asignatura >= notas[0].length) {
            throw new IllegalArgumentException("Error en nº asignatura");
        }

        //Es por asignatura. Así que dada una columna, tenemos que recorrer
        // y comprobar esa columna en todas las filas
        int aprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i][asignatura]>=5){
                aprobados++;
            }
        }
        return aprobados;
    }
}
