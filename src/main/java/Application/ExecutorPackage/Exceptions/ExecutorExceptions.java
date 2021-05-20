package Application.ExecutorPackage.Exceptions;

public class ExecutorExceptions extends Exception {
    public ExecutorExceptions(String str, Throwable ex) {
        super(str, ex);
    }

    public ExecutorExceptions(String str) {
        super(str);
    }

    public ExecutorExceptions(Throwable ex) {
        super(ex);
    }

    public ExecutorExceptions() {
    }
}
