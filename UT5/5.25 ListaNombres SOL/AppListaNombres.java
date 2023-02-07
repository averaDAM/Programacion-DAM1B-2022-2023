import java.util.Arrays;

/**
 * 
 * Acepta como argumento del main el tamaño máximo de la lista
 * Si no se pasan argumentos se muestra un mensaje de error, se le informa al usuario
 * de la sintaxis a utilizar y se acaba el programa
 * 
 * En otro caso se crea la lista y:
 *  - se llama al método cargarDeFichero() 
 *  - se muestra la lista
 *  - se muestra el nombre más largo
 *  - se borran los que empiezan por 'r'
 *  - se muestra la lista
 *  - se muestra cuántos empiezan por 'aL'
 *  - se muestran los nombres que empiezan por "a"
 */
public class AppListaNombres
{

    /**
     *  
     */
    public static void main(String[] args)
    {
       if(args.length!=1){
           System.out.println("Error de sintaxis.\n" +
                   "java AppListaNombres <tamaño-lista>");
       }
       else{
           ListaNombres l = new ListaNombres(Integer.parseInt(args[0]));
           l.cargarDeFichero();
           l.printLista();

           System.out.println("Nombre más largo: " + l.nombreMasLargo());

           String[] empiezan = l.empiezanPorLetra('r');
           System.out.println("Empiezan por 'r': ");
           System.out.println(Arrays.toString(empiezan));

           l.printLista();
           System.out.println("Empiezan por \"aL\": " + l.empiezanPor("aL"));

           empiezan = l.empiezanPorLetra('a');
           System.out.println("Empiezan por 'a': ");
           System.out.println(Arrays.toString(empiezan));
       }
        
        
    }
}
