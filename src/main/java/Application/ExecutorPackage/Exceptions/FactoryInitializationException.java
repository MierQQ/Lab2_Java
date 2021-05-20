package Application.ExecutorPackage.Exceptions;

public class FactoryInitializationException extends ExecutorExceptions {
    public FactoryInitializationException(String str, Throwable ex) {
        super(str, ex);
    }

    public FactoryInitializationException(String str) {
        super(str);
    }

    public FactoryInitializationException(Throwable ex) {
        super(ex);
    }

    public FactoryInitializationException() {
    }
}
