package Application.ExecutorPackage.Exceptions;

public class BlockException extends ExecutorExceptions {
    public BlockException(String str, Throwable ex) {
        super(str, ex);
    }

    public BlockException(String str) {
        super(str);
    }

    public BlockException(Throwable ex) {
        super(ex);
    }

    public BlockException() {
    }
}
