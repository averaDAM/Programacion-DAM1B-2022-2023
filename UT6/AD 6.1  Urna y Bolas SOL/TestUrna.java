 

/**
 * 
 */

 
public class TestUrna
{
        public static void main (String[] args)
        {
               if(args.length!=1){
                       System.out.println("Error de sintaxis: \n" +
                               "java TestUrna <numBolas>");
               }
               else{
                       int numBolas = Integer.parseInt(args[0]);
                       //Creamos la urna
                       Urna u = new Urna();

                       //Metemos la cantidad de bolas indicadas
                       for (int i = 0; i < numBolas; i++) {
                               u.meterBola(new Bola());
                       }

                       //Testeamos las funciones de Urna
                       //Mostramos el estado inicial de la urna
                       u.mostrarUrna();
                       System.out.println("Hay " + u.cuantasBlancas()  + " bolas blancas y "
                               + u.cuantasNegras() + " bolas negras");


               }
                        
                
        }
        
        
        
}
