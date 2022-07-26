package school.devskill.exceptions;

public class NotADirectionException extends RuntimeException {

    public NotADirectionException() {
        super("Invalid direction.");
    }

    public NotADirectionException(String message) {
        super(message);
    }
}
