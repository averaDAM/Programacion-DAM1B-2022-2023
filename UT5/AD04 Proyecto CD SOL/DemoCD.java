import java.util.Arrays;

/**
 * 
 * Clase de prueba del CD
 */
public class DemoCD
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        // aceptar argumentos a través del main
        if(args.length!=3){
            System.out.println("Error en nº argumentos, Sintaxis: java DemoCD <n> <titulo> <artista>");
        }
        else{
            int capacidad = Integer.parseInt(args[0]);
            // crear el CD
            CD cd = new CD(capacidad, args[1], args[2]);


            // añadir varias canciones al CD (al final del CD
            cd.addCancion("Ave María", 3.45);
            cd.addCancion("Ave César", 3);
            cd.addCancion("Lloraré tus penas", 2.34);
            cd.addCancion("Lucía", 4.55);
            cd.addCancion("Ella", 4.21);
            cd.addCancion("Esclavo de tus besos ", 4.23);
            cd.addCancion("Bulería Bulería ", 3.72);


            //  Mostar el CD
            System.out.println(cd.toString());
            System.out.println("---------------------------------------------");


            // Mostar la duración del CD
            System.out.println("Duración total. " + cd.duracionTotal() + "'");
            System.out.println("---------------------------------------------");

            System.out.println("Canción aleatoria prueba 1: " + cd.getAleatoria().toString());
            System.out.println("Canción aleatoria prueba 2: " + cd.getAleatoria().toString());
            System.out.println("Canción aleatoria prueba 3: " + cd.getAleatoria());

            System.out.println("Títulos de las canciones");
            System.out.println(Arrays.toString(cd.getTitulos()));

            int empiezanPorTus = cd.cancionesQueContienen("tus");
            System.out.println("Contienen \"tus\": " + empiezanPorTus);

            String[] borradas = cd.borrarCancionesQueEmpiezan("AVE");
            System.out.println("Borrando canciones que empiezan por \"ave\"...");
            System.out.println("Se han borrado " + Arrays.toString(borradas));

            System.out.println("El CD queda así: ");
            System.out.println(cd);

            System.out.println("\nHacemos una copia");
            CD copia = cd.crearNuevoCD();
            System.out.println(copia.toString());
        }






    }
}
