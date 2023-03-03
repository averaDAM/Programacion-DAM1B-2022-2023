import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Clase que representa un club de personas con una serie de hobbies
 */


public class Club
{

    private ArrayList<Persona> personas;

    /**
     * Constructor de la clase Club
     */
    public Club()
    {
        personas = new ArrayList<>();
    }

    /**
     * @param nombre el nombre de la persona que se añade
     * @param hob el conjunto de hobbies de la persona a añadir
     */
    public void addPersona(String nombre, HashSet<String> hob)
    {
        Persona p = new Persona(nombre);
        personas.add(p);//Se puede hacer antes o después de añadir los hobbies.
        for (String h : hob) {
            p.addHobbie(h);
        }
    }

    /**
     *
     * @param  cual el hobbie a comprobar
     * @return  el nº de personas del club que tienen ese hobbie
     */
    public int personasConHobbie(String cual)
    {
        int cont = 0;
        Iterator<Persona> itPersonas = personas.iterator();
        while (itPersonas.hasNext()) {
            Persona p = itPersonas.next();
            if(p.tieneHobbie(cual)){
                cont++;
            }
        }

        return cont;
    }

    public static void main(String[] args) {
        Club c = new Club();

        HashSet<String> hobbies = new HashSet<>();
        hobbies.add("bailar");
        hobbies.add("leer");
        hobbies.add("DEPorte");

        c.addPersona("Juan", hobbies);

        
        hobbies = new HashSet<>();
        hobbies.add("bailar");
        hobbies.add("leer");
        hobbies.add("canTAR");
        c.addPersona("Elena", hobbies);

        c.printClub();

        System.out.println("\n\nPersonas con el hobbie bailar:");
        System.out.println(c.personasConHobbie("bailar"));


        System.out.println("\n\nBorramos las personas con el hobbie bailar:");
        System.out.println(c.borrarPersonasConHobbie("bailar"));
    }
    /**
     * visualiza la lista de personas
     */

    public void printClub()
    {
        System.out.println("Personas en el club y sus hobbies");
        for (Persona p : personas) {
            System.out.println(p);
        }

    }

    /**
     * Borra de la lista las persona con un determinado hobbie
     * y las añade en el conjunto a devolver
     * Usa un iterador
     *
     * @param  cual el hobbie a comprobar
     * @return el conjunto de nombres de personas con ese hobbie
     */

    public HashSet<String> borrarPersonasConHobbie(String cual)
    {
        Iterator<Persona> itPersonas = personas.iterator();
        HashSet<String> borradas = new HashSet<>();

        while (itPersonas.hasNext()) {
            Persona p = itPersonas.next();
            if(p.tieneHobbie(cual)){
                itPersonas.remove();
                borradas.add(p.getNombre());
            }
        }

        return borradas;
    }


}
