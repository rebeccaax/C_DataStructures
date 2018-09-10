package unit4.day1;

/**
 * Created by rebeccaxu on 1/22/18.
 */
public class FileFormatException extends Exception {

    public FileFormatException() {
    }

    public FileFormatException(String message) {
        super(message);
    }

    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileFormatException(Throwable cause) {
        super(cause);
    }

    public FileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
