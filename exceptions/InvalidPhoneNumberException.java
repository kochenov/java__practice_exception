package exceptions;

/**
 * Исключение, выбрасываемое при неверном формате номера телефона.
 */
public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
