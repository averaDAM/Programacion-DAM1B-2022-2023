/**
 *
 *
 */
public abstract class Fichero implements Comparable<Fichero>{
    private String titulo;
    private int tama�o;

    /**
     *
     */
    public Fichero(String titulo, int tama�o) {
        this.titulo = titulo;
        this.tama�o = tama�o;
    }

    /**
     *
     */
    public int getTama�o() {
        return tama�o;
    }

    /**
     *
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     */
    public void display() {
        System.out.println(getClass().getSimpleName());
        System.out.println("T�tulo: " + titulo);
        System.out.println("Tama�o: " + tama�o);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() + tama�o;
    }

    /**
     * Dos ficheros son iguales si tienen el mismo t�tulo y tama�o
     * y si son del mismo tipo
     */
    @Override
    public boolean equals(Object obj) {
        //Las comparaciones b�sicas
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;

        //Nuestra comparaci�n adicional
        Fichero f=(Fichero)obj;
        return f.titulo.equals(this.titulo) && f.getTama�o()==this.tama�o;
    }

    /**
     * Es posible comparar dos ficheros en base a su
     * t�tulo (si coincide el t�tulo se tendr� en cuenta el tama�o - criterio natural de
     * ordenaci�n)
     */
    @Override
    public int compareTo(Fichero o) {
        if(this.titulo.equals(o.getTitulo())){
            return this.tama�o-o.tama�o;
        }
        else{
            return this.titulo.compareTo(o.getTitulo());
        }
    }
}
