

/**
 * Clase para probar las otras dos
 */
public class DemoCurso
{

    /**
     *   
     */
    public static void main(String[] args)
    {
        Curso dam1b = new Curso();
        dam1b.añadirEstudiante("Luisa", 9);
        dam1b.añadirEstudiante("Angel", 3);
        dam1b.añadirEstudiante("Ana", 4);
        dam1b.añadirEstudiante("Alberto", 8);
        System.out.println("Hay " + dam1b.cuantosAlumnos() +
            " alumnos");
        System.out.println(dam1b.toString());
        System.out.printf("La media es %4.2f" , dam1b.getMedia());
        System.out.println("\nAlumno con nota máxima " +
            dam1b.alumnoNotaMaximaV1());

        int suspensoMasAlto = dam1b.suspensoMasAlto();
        if (suspensoMasAlto == 0)
        {
            System.out.println("No hay suspensos");
        }
        else
        {
            System.out.println("Suspenso más alto " + suspensoMasAlto); 
        }
        System.out.println("Dos notas más altas " + dam1b.dosNotasMasAltas());
    }

}
