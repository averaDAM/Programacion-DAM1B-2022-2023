package festivales.modelo;

import festivales.io.FestivalesIO;
import festivales.utilidades.ConversionFecha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

/**
 * Un objeto de esta clase almacena los datos de un
 * festival.
 * Todo festival tiene un nombre, se celebra en un lugar
 * en una determinada fecha, dura una serie de días y
 * se engloba en un conjunto determinado de estilos
 *
 */
public class Festival {
    private final String nombre;
    private final String lugar;
    private final LocalDate fechaInicio;
    private final int duracion;
    private final HashSet<Estilo> estilos;
    
    
    public Festival(String nombre, String lugar, LocalDate fechaInicio,
                    int duracion, HashSet<Estilo> estilos) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.estilos = estilos;
        
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public HashSet<Estilo> getEstilos() {
        return estilos;
    }
    
    public void addEstilo(Estilo estilo) {
        this.estilos.add(estilo);
        
    }

    /**
     * devuelve el mes de celebración del festival, como
     * valor enumerado
     *
     */
    public Mes getMes() {
        //Recogemos los valores posibles del enumerado Mes en un array
        Mes[] valoresMeses = Mes.values();
        //Recogemos el valor numérico del mes de la fecha de inicio (de 1 a 12)
        int mesFecha = fechaInicio.getMonthValue();
        return valoresMeses[mesFecha-1];
    }

    /**
     *
     * @param otro
     * @return true si el festival actual empieza
     * en un fecha anterior a otro
     */
    public boolean empiezaAntesQue(Festival otro) {
        return this.fechaInicio.isBefore(otro.getFechaInicio());
        //return this.fechaInicio.compareTo(otro.getFechaInicio()) < 0;
    }

    /**
     *
     * @param otro
     * @return true si el festival actual empieza
     * en un fecha posteior a otro
     */
    public boolean empiezaDespuesQue(Festival otro) {
        return this.fechaInicio.isAfter(otro.getFechaInicio());
        //return this.fechaInicio.compareTo(otro.getFechaInicio()) > 0;
    }

    /**
     *
     * @return true si el festival ya ha concluido
     */
    public boolean haConcluido() {
        //Se trata de calcular la fecha de fin con la fecha de inicio más los días de duración
        // y comprobar si es anterior a la fecha de hoy
        LocalDate fechaFin = calcularFechaFin();
        LocalDate hoy = LocalDate.now();
        return fechaFin.isBefore(hoy);
    }

    /**
     * AÑADIR AL ENUNCIADO Y PROYECTO DE PARTIDA
     * @return true si el festival ya ha empezado, pero no ha concluido
     * (Si empieza el día de hoy se considera que NO ha empezado)
     */
    public boolean enCurso() {
        if(!haConcluido()){
            LocalDate hoy = LocalDate.now();
            return fechaInicio.isBefore(hoy);
        }
        else{
            return false;
        }
    }

    /**
     * Calcula los días que faltan para el inicio del festival
     * @return los días que faltan para el inicio. -1 si ha concluido o ya ha empezado
     */
    public long diasParaInicio(){
        if(haConcluido() || enCurso())
            return -1;
        else{
            LocalDate hoy = LocalDate.now();
            return ChronoUnit.DAYS.between(hoy, fechaInicio);
        }

    }

    /**
     * Añadido al proyecto de partida
     * Calcula la fecha de fin a partir de la fecha de inicio y la duración
     * @return LocalDate con la fecha de fin
     */
    private LocalDate calcularFechaFin() {
        LocalDate fechaFin = fechaInicio.plusDays(duracion);
        return fechaFin;
    }

    /**
     * Representación textual del festival, exactamente
     * como se indica en el enunciado
     *
     */
    @Override
    public String toString() {
        String texto = nombre + "\t" + estilos.toString() + "\n";
        texto += lugar + "\n";
        texto += formatearFecha();
        texto += "\n------------------------------------------------------------";
        return texto;
    }

    /**
     * Añadido al proyecto de partida
     * Formatea la fecha del festival en el formato necesario para el toString
     */
    private String formatearFecha() {
        String retorno = "";

        if(duracion == 1){
            String fechaStr = ConversionFecha.getFechaStr(fechaInicio,"dd MMM yyyy");
            retorno += fechaStr;
        }
        else{
            //Calculamos la fecha de inicio en formato dd MMM.
            retorno += ConversionFecha.getFechaStr(fechaInicio,"dd MMM");
            //Ahora calulamos la fecha de fin en formato dd MMM. yyyy
            retorno += " - ";
            retorno +=  ConversionFecha.getFechaStr(calcularFechaFin(),"dd MMM yyyy");
        }

        //Ahora calculamos los días que quedan para el inicio, o si está en curso, o si ha concluido
        LocalDate hoy = LocalDate.now();
        if(haConcluido()){
            retorno += " (concluido) ";
        }
        else if(enCurso()){
            retorno += " (ON) ";
        }
        else{
            long diasFaltan = diasParaInicio();
            retorno += " (quedan " + diasFaltan + " días)";
        }

        return retorno;
    }


    /**
     * Código para probar la clase Festival
     *
     */
    public static void main(String[] args) {
        System.out.println("Probando clase Festival");
        String datosFestival = "Gazpatxo Rock : " +
                "valencia: 19-03-2023  :1  :rock" +
                ":punk " +
                ": hiphop ";
        Festival f1 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f1);
        
        datosFestival = "black sound fest:badajoz:25-02-2023:  21" +
                ":rock" + ":  blues";
        Festival f2 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f2);
    
        datosFestival = "guitar bcn:barcelona: 28-01-2023 :  170" +
                ":indie" + ":pop:fusion";
        Festival f3 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f3);
    
        datosFestival = "  benidorm fest:benidorm:26-01-2023:3" +
                ":indie" + ": pop  :rock";
        Festival f4 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f4);
      
        
        System.out.println("\nProbando empiezaAntesQue() empiezaDespuesQue()" +
                "\n");
        if (f1.empiezaAntesQue(f2)) {
            System.out.println(f1.getNombre() + " empieza antes que " + f2.getNombre());
        } else if (f1.empiezaDespuesQue(f2)) {
            System.out.println(f1.getNombre() + " empieza después que " + f2.getNombre());
        } else {
            System.out.println(f1.getNombre() + " empieza el mismo día que " + f2.getNombre());
        }

        System.out.println("\nProbando haConcluido()\n");
        System.out.println(f4);
        System.out.println(f4.getNombre() + " ha concluido? " + f4.haConcluido());
        System.out.println(f1);
        System.out.println(f1.getNombre() + " ha concluido? " + f1.haConcluido());
 
        
        
    }
}
