public class CampoPreenchidoException extends Exception {
    public CampoPreenchidoException() {
        super("O campo selecionado está preenchido");
    }

    public CampoPreenchidoException(String message) {
        super(message);
    }

    public CampoPreenchidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampoPreenchidoException(Throwable cause) {
        super(cause);
    }

    public CampoPreenchidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
