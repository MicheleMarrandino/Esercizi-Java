package school.devskill.exceptions;

public class MethodNotAllowedException extends RuntimeException {

    public MethodNotAllowedException() {
        super("Method not allowed.");
    }

    public MethodNotAllowedException(String message) {
        super(message);
    }
}
