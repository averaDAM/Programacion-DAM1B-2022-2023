import java.util.ArrayList;
import java.util.Iterator;

/**
 * Un objeto de esta clase mantiene una colección Arraylist de objetos estudiante
 */


public class Curso {

    private final ArrayList<Estudiante> curso;

    /**
     * Constructor
     */
    public Curso() {
        curso = new ArrayList<>();
    }

    /**
     * Añade un estudiante a la colección
     */
    public void añadirEstudiante(String nombre, int nota) {
        Estudiante e = new Estudiante(nombre, nota);
        curso.add(e);
    }

    /**
     * nº de alumnos en el curso
     */
    public int cuantosAlumnos() {
        return curso.size();
    }

    /**
     * Representación en formato texto del curso
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de estudiantes del curso: ");
        for (Estudiante e : curso) {
            sb.append(e + "\n");
        }
        return sb.toString();
    }

    /**
     * Calcual la media de notas del curso. Utiliza for mejorado
     */
    public double getMedia() {
        double sumaNotas = 0;
        for (Estudiante e : curso) {
            sumaNotas += e.getNota();
        }
        return sumaNotas / cuantosAlumnos();
    }

    /**
     * Nombre del alumno con nota máxima. Con for mejorado
     */
    public String alumnoNotaMaximaV1() {
        int maxNota = -1;
        String nomAlumno = "";
        for (Estudiante e : curso) {
            if (e.getNota() > maxNota) {
                maxNota = e.getNota();
                nomAlumno = e.getNombre();
            }
        }
        return nomAlumno;
    }

    /**
     * Nombre del alumno con nota máxima. Utiliza un iterador
     */
    public String alumnoNotaMaximaV2() {
        int maxNota = -1;
        String nomAlumno = "";

        Iterator<Estudiante> itCurso = curso.iterator();
        while (itCurso.hasNext()) {
            Estudiante e = itCurso.next();
            if (e.getNota() > maxNota) {
                maxNota = e.getNota();
                nomAlumno = e.getNombre();
            }
        }
        return nomAlumno;
    }

        /**
         * Borrar el primer estudiante de la colección. Esta no puede estar vacía
         */
        public void borrarPrimero ()
        {
            if(cuantosAlumnos()>0){
                curso.remove(0);
            }
        }


        /**
         * Borrar los alumnos que han suspendido. Con un interador
         */
        public void borrarSuspensos ()
        {
            Iterator<Estudiante> itCurso = curso.iterator();
            while (itCurso.hasNext()) {
                Estudiante e = itCurso.next();
                if(e.getNota()<5){
                    itCurso.remove();
                }
            }
        }

        /**
         *
         * Devuelve true si hay algún notable. Con for mejorado
         */
        public boolean hayAlgunNotable ()
        {
            for (Estudiante e : curso) {
                if(e.getNota()>=7){
                    return true;
                }
            }
            return false;
        }

        /**
         *
         * cuantos estudiantes tienen un nombre que empieza por la cadena indicada
         *
         */
        public int empiezanPor (String str)
        {
            int contador = 0;
            for (Estudiante e : curso) {
                if(e.getNombre().startsWith(str))
                    contador++;
            }
            return contador;
        }

        /**
         *
         * Devuelve el suspenso más alto del curso
         */
        public int suspensoMasAlto ()
        {
            int suspensoMax = 0;
            for (Estudiante e : curso) {
                if(e.getNota()<5 && e.getNota()>suspensoMax){
                    suspensoMax = e.getNota();
                }
            }
            return suspensoMax;
        }

        /**
         *
         * Calcula y devuelve el total de suspensos. Con un iterador.
         */
        public int totalSuspensosIterador ()
        {
            int suspensos = 0;
            Iterator<Estudiante> itCurso = curso.iterator();
            while (itCurso.hasNext()) {
                if(itCurso.next().getNota()<5){
                    suspensos++;
                }
            }
            return suspensos;
        }


        /**
         *
         * Calcula y devuelve como un string las dos notas más altas del curso.
         * Con un while normal.
         */
        public String dosNotasMasAltas ()
        {
            int max = 0;
            int segundoMax = 0;
            int i = 0;
            while(i<cuantosAlumnos()){
                int nota =curso.get(i).getNota();
                if(nota>max){
                    segundoMax = max;
                    max = nota;
                } else if (nota>segundoMax && nota!=max) {
                    segundoMax = nota;
                }
                i++;
            }
            return max + " - " + segundoMax;
        }


    }
