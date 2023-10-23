package bookstoreproject.inventory;

public class NegativeQuantityException extends RuntimeException {
    public NegativeQuantityException(String message) {
        super(message);
    }
}
