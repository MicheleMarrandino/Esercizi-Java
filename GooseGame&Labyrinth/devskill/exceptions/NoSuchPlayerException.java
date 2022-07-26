package school.devskill.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchPlayerException extends Exception {

    public NoSuchPlayerException() {
        super("No such player.");
    }

    public NoSuchPlayerException(String message) {
        super(message);
    }
}
