package Application.ExecutorPackage.Exceptions;

public class FormatException extends ExecutorExceptions {
    public FormatException(String str, Throwable ex) {
        super(str, ex);
    }

    public FormatException(String str) {
        super(str);
    }

    public FormatException(Throwable ex) {
        super(ex);
    }

    public FormatException() {
    }
}
