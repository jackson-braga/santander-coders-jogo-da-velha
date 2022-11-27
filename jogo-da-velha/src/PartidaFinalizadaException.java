public class PartidaFinalizadaException extends Exception {
    public PartidaFinalizadaException() {
        super("A partida já terminou");
    }

    public PartidaFinalizadaException(String message) {
        super(message);
    }

    public PartidaFinalizadaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartidaFinalizadaException(Throwable cause) {
        super(cause);
    }

    public PartidaFinalizadaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
