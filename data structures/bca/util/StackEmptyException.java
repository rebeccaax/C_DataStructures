package bca.util;

/**
 * Created by rebeccaxu on 2/22/18.
 */
public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
    }

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackEmptyException(Throwable cause) {
        super(cause);
    }

    public StackEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
