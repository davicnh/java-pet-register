package entities;

public class PetException extends RuntimeException {

    public PetException() {
        super("Erro no cadastro de pet.");
    }
}
