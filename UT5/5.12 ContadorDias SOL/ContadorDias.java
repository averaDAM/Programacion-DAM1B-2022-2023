
/**
 * La clase modela un contador de d�as transcurridos 
 * hasta una fecha determinada
 * Ejer 5.12
 */
public class ContadorDias
{
    private int[] diasMes;

    /**
     * 
     */
    public ContadorDias()
    {
        diasMes = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    }

    /**
     * Cuenta el n� de d�as desde el inicio de a�o
     *
     * @param  mes mes actual entre 1 y 12
     * @param  dia actual  entre 1 y 31
     * @param  a�o actual
     * @return la cantidad de d�as desde el comienzo de a�o
     */

    public int contarDias(int dia, int mes, int a�o)
    {
        int numDias = dia;
        for (int i = 0; i < mes - 1; i++) {
            numDias += diasMes[i];
        }
        return numDias;
    }
    
    
    /**
     * return true si a�o es bisiesto
     * Un a�o es bisiesto si es m�ltiplo de 4 pero no de 100 o s� de 400
     * Hazlo sin if
     */
    private boolean esBisiesto(int a�o)
    {
        return (a�o%4==0) && ((a�o % 100 != 0) || (a�o % 400 == 0));
    }

}
