package christmas.exception;

public abstract class ChristmasEventException extends IllegalArgumentException {

    public ChristmasEventException(String message) {
        super("[ERROR] " + message);
    }
}
