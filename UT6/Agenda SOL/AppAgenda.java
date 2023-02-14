import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

/**
 *  
 */
public class AppAgenda
{

    /**
     *  
     */
    public static void main(String[] args)
    {
        Agenda agenda = new Agenda();
        agenda.apuntarNota("comprar pan");
        agenda.apuntarNota("comprar leche");
        agenda.apuntarNota("ir dentista");
        agenda.apuntarNota("recargar móvil");
        agenda.listarNotas();
        System.out.println("Total notas: " + agenda.numeroNotas());
        separador();

        System.out.println("Nota tercera: ");
        agenda.mostrarNota(2);
        separador();

        System.out.println("Borramos la nota de la posición 2: ");
         agenda.borrarNota(2);
         agenda.listarNotas();
         separador();


         System.out.println("Notas que contienene 'ar': " +  agenda.notasQueContienen("AR"));

         separador();
        System.out.println("Borramos las que empiezan por \"co\": ");
         agenda.borrarNotasQueEmpiezanPor("co");
         agenda.listarNotas();

         separador();
         agenda.apuntarNota("ir pescaderia");
         agenda.apuntarNota("ir fruteria");
        agenda.listarNotas();
        System.out.println("Notas que acaban en \"ria\": ");
         ArrayList<String> resul = agenda.acabanEn("ria");
         System.out.println(resul.toString());

         //BORRAR REPETIDAS V1
         separador();
         agenda.apuntarNota("ir pescaderia");
         agenda.apuntarNota("ir pescaderia");
         agenda.apuntarNota("ir pescaderia");
         agenda.apuntarNota("comprar leche");
         System.out.println("------ Con Iterator -------");
         agenda.listarNotasConIterador();
        System.out.println("\nBorramos repetidas V1: ");
        agenda.borrarRepetidasV1();
        agenda.listarNotasConIterador();

        //BORRAR REPETIDAS V2
        separador();
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("comprar leche");

        System.out.println("------ Con Iterator -------");
        agenda.listarNotasConIterador();
        System.out.println("\nBorramos repetidas V2: ");
        agenda.borrarRepetidasV2();
        agenda.listarNotasConIterador();

        System.out.println("\n------ DUPLICAMOS -------");
        agenda.duplicarNotas();
        agenda.listarNotas();


        System.out.println("\n------ Primera al final -------");
        agenda.primeraAlFinal();
        agenda.listarNotas();

        System.out.println("\n------ Última al principio -------");
        agenda.ultimaAlPrincipio();
        agenda.listarNotas();

        System.out.println("\n---- INVERTIR V2 ------");
        agenda.invertirV2();
        agenda.listarNotas();

        System.out.println("\n---- INVERTIR V1 ------");
        agenda.invertir();
        agenda.listarNotas();

        System.out.println("\n----  BORRAR ACABADAS EN \"ir\" -------");
        agenda.borrarNotasAcabanEn("ir");  // da error
        agenda.listarNotas();




    }

    public static void separador(){
        System.out.println("\n--------------------------");
    }
}
