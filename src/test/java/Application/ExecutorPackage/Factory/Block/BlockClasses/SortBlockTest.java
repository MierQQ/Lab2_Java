package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class SortBlockTest extends TestCase {

    public void testExecute() throws BlockException {
        SortBlock block = new SortBlock();
        StringBuilder input = new StringBuilder("a\n" +
                "c\n" +
                "b\n" +
                "e\n" +
                "d\n" +
                "f");
        List<String> args = new LinkedList<>();
        block.execute(args, input);
        Assert.assertEquals(input.toString(), "a\n" +
                "b\n" +
                "c\n" +
                "d\n" +
                "e\n" +
                "f");
    }
}