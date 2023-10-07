package fibonnaci.exception;

import java.lang.module.FindException;

public class FibonnaciException extends Exception {

    public FibonnaciException(String mensagem) {
        super(mensagem);
    }

    public FibonnaciException() {
        super();
    }
}
