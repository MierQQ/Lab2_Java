package Application;

import Application.ExecutorPackage.WorkflowExecutor;

import java.io.FileInputStream;
import java.io.InputStream;

public class Application {
    static public void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Wrong number of arguments: need workflow file name");
            return;
        }
        try (InputStream input = new FileInputStream(args[0])) {
            WorkflowExecutor executor = new WorkflowExecutor(input);
            executor.execute();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
