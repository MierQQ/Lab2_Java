package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class ReadFileBlockTest extends TestCase {

    public void testExecute() throws BlockException {
        StringBuilder expected = new StringBuilder("jija");
        StringBuilder actual = new StringBuilder();
        ReadFileBlock block = new ReadFileBlock();
        List<String> args = new LinkedList<>();
        String str = "input.txt";
        args.add(str);
        block.execute(args, actual);
        Assert.assertEquals(actual.toString(), expected.toString());
    }
}