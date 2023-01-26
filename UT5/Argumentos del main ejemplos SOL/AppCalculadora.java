
/**
 * 
 */
public class AppCalculadora
{

    /**
     *  
    /**
     *  si no se pasan argumentos al main mostrar error,
     *  en caso contrario aceptar los argumentos, crear un array de enteros con ellos
     *  crear la calculadora a partir de los valores de ese array y mostrar la calculadora
     *  
     */
    public static void main(String[] args)
    {
         if(args.length == 0){
             System.out.println("Error de llamada.\n" +
                     "Sintaxis: java AppCalculadora <serie de números>");
         }
         else{
             Calculadora c = new Calculadora();
             //Recorremos el array de argumentos recogiendo cada uno de ellos y pasándolo a int
             // y los vamos introduciendo en un objeto Calculadora
             for (int i = 0; i < args.length; i++) {
                 c.introducirNumero(Integer.parseInt(args[i]));
             }

             System.out.println("Calculadora inicial: " + c.toString());
             //Ahora podemos empezar a probar funciones de la clase
             c.borrarPares();
             System.out.println("Borrados los pares: " + c.toString());
             //etc..
         }
    }
}
