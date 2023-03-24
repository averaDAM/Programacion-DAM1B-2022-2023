package festivales.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utilidades para convertir fechas de String a LocalDate y viceversa
 */
public class ConversionFecha {
    /**
     * Parsea una fecha en String a LocalDate según el patrón indicado por el segundo parámetro
     * @param fechaString la fecha a parsear
     * @param formato el patrón correspondiente al formato en que viene fechaString
     * @return la fecha parseada en un objeto LocalDate
     */
    public static LocalDate parsearFecha(String fechaString, String formato) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(fechaString, formateador);
    }

    /**
     * Añadido al proyecto de partida
     * Formatea la fecha en el formato indicado
     * @param fecha
     * @param formato
     * @return
     */
    public static String getFechaStr(LocalDate fecha, String formato) {
        DateTimeFormatter formateador;
        formateador = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formateador);
    }


}
