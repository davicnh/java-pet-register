package exceptions;

public class PesoException extends RuntimeException {
    public PesoException() {
        super("Peso inválido.");
    }
}
