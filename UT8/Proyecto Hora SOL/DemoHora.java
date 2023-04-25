import java.io.IOException;

public class DemoHora
{

    private Hora h1;
    private Hora h2;

    /**
     * Constructor  
     */
    public DemoHora()    {

    }

    /**
     *  Crea una hora incorrecta  y comprueba que aunque no captures la excepción
     *  el compilador no se queja
     *  Captura a continuación la excepción
     *  
     *  Cambia en la clase Hora la excepción a IOException y comprueba el aviso del compilador
     *  Deshaz los cambios
     *  
     *  Crea ahora una clase propia HoraExcepcion que herede de RuntimeException con constructor,
     *  atributo y toString()
     *  Haz los cambios en la clase Hora para que lance esta nueva excepción. Es verificada o no verificada?
     *  
     *  
     * 
     */
    public void demo() {
        try {
            //Probad si queréis a cambiar la hora por una incorrecta y veis la salida
            h1 = new Hora(12, 51, 40);
            System.out.println(h1);
        } catch (HoraException e) {
            System.out.println("Excepcion Hora: " + e.getMensaje());
        }

        //La excepción se recogerá igual, porque HoraException es un subtipo de RuntimeException
        try{
            h2 = new Hora(28, 30, 12);
            System.out.println(h2);
        }
        catch(RuntimeException e){
            e.printStackTrace();//Imprime los datos de una HoraException. e es polimórfica
        }


    }

    public static void main(String[] args) {
        DemoHora demo = new DemoHora();
        demo.demo();
    }
}
