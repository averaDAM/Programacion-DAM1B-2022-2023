import java.util.HashSet;

/**
 * La clase mantiene información sobre una persona
 * y sus hobbies
 * 
 */
public class Persona 
{
    private String nombre;
    private HashSet<String> hobbies;
  
    /**
     * constructor para los objetos de la clase Persona
     */
    public Persona(String nombre)
    {
        this.nombre = nombre;
        hobbies = new HashSet<>();
    }

    /**
     * Accesor para el nombre   
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @param h añade el nuevo hobbie
     * en minúsculas
     */
    public void addHobbie(String h)
    {
       hobbies.add(h.toLowerCase());
    }
    
    /**
     * @param h el nombre del hobbie a comprobar
     * @return true si tiene ese hobbie
     */
    public boolean tieneHobbie(String h)
    {
         return hobbies.contains(h.toLowerCase());
    }
        
    /** 
     * Devuelve el conjunto de hobbies como un String
     */
    public String hobbiesToString()
    {
        String txtHobbies = "";
        for (String h : hobbies) {
            txtHobbies += h + " ";
        }
        return txtHobbies;
    }
    
     /** 
     * Devuelve una representación de la persona
     * Su nombre y su conjunto de hobbies como un String
     */
    public String toString()
    {
        String texto = "";
        texto += "Nombre: " + nombre + "\n";
        texto += "Hobbies: " + hobbiesToString() + "\n";
        return texto;
    }

    /**
     * Main para probar la clase
     */
    public static void main(String[] args) {
        Persona p = new Persona("Marce");
        p.addHobbie("Leer");
        p.addHobbie("Correr");
        p.addHobbie("Viajar");
        System.out.println(p);
    }
       
}
