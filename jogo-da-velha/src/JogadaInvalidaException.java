package jogodavelha;

public class JogadaInvalidaException extends Exception{

    public JogadaInvalidaException() {
    }

    public JogadaInvalidaException(String message) {
        super(message);
    }

    public JogadaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogadaInvalidaException(Throwable cause) {
        super(cause);
    }

    public JogadaInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
