public class HoraException extends RuntimeException{
    private String mensaje;

    public HoraException(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "HoraException{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }

    public String getMensaje() {
        return mensaje;
    }
}
