package exceptions;

/**
 * Исключение, выбрасываемое при неверном формате даты.
 */
public class InvalidDateFormatException extends Exception {
    public InvalidDateFormatException(String message) {
        super(message);
    }
}
