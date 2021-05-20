package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class ReplaceBlockTest extends TestCase {

    public void testExecute() throws BlockException {
        ReplaceBlock block = new ReplaceBlock();
        StringBuilder input = new StringBuilder("a\n" +
                "c\n" +
                "b\n" +
                "e\n" +
                "d\n" +
                "f");
        List<String> args = new LinkedList<>();
        args.add("a");
        args.add("jija");
        block.execute(args, input);
        Assert.assertEquals(input.toString(), "jija\n" +
                "c\n" +
                "b\n" +
                "e\n" +
                "d\n" +
                "f");
    }
}