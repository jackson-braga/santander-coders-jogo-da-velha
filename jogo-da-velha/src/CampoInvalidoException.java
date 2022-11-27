public class CampoInvalidoException extends Exception {
    public CampoInvalidoException() {
    }

    public CampoInvalidoException(String message) {
        super(message);
    }

    public CampoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampoInvalidoException(Throwable cause) {
        super(cause);
    }

    public CampoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
