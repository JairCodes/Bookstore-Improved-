package bookstoreproject.inventory;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String mess){
        super(mess);
    }
}
