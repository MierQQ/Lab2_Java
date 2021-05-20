package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WriteFileBlockTest extends TestCase {

    public void testExecute() throws BlockException, IOException {
        List<String> args = new LinkedList<>();
        args.add("output.txt");
        StringBuilder stringBuilder = new StringBuilder("Jija");
        WriteFileBlock block = new WriteFileBlock();
        block.execute(args, stringBuilder);
        FileInputStream fileInputStream = new FileInputStream(args.get(0));
        String str = new String(fileInputStream.readAllBytes());
        Assert.assertEquals(str, "Jija");
    }
}