package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class GrepBlockTest extends TestCase {

    public void testExecute() throws BlockException {
        GrepBlock block = new GrepBlock();
        StringBuilder input = new StringBuilder("this text\n" +
                "is a test text\n" +
                "hello world\n" +
                "textod\n" +
                "JIJA");
        List<String> args = new LinkedList<>();
        args.add("JIJA");
        block.execute(args, input);
        Assert.assertEquals(input.toString(), "JIJA");
    }
}