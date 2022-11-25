package src;

/**
 * @author CrisMoura on 25/11/2022
 */
public class JogaInvalidaException extends Exception{

    public JogaInvalidaException() {
        super();
    }
    public JogaInvalidaException(String errorMessage) {
        super(errorMessage);
    }
}
