
/**
 *  
 */
public class DemoAlumno
{

    /**
     *  
     *  Aceptar como argumentos del main el nombre y la nota de un alumno
     *  crear un objeto Alumno y mostrar su representación
     */
    public static void main(String[] args)
    {
       if(args.length != 2){
           System.out.println("Error en argumentos\n" +
                   "Sintaxis correcta: java DemoAlumno <nombre> <nota>");
       }
       else{
           //Pasamos el segundo argumento de String a int. (Asumimos que es un número, si no, se generará excepción).
           int nota = Integer.parseInt(args[1]);
           Alumno a = new Alumno(args[0], nota);
           System.out.println("Alumno creado: ");
           System.out.println(a.toString());
       }
        
    }
}
