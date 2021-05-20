package Application.ExecutorPackage.Factory;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Exceptions.FactoryInitializationException;
import Application.ExecutorPackage.Factory.Block.BlockClasses.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest extends TestCase {
    @Test
    public void testGetBlock() throws FactoryInitializationException, BlockException {
        Assert.assertTrue(Factory.getInstance().getBlock("readfile") instanceof ReadFileBlock);
        Assert.assertTrue(Factory.getInstance().getBlock("writefile") instanceof WriteFileBlock);
        Assert.assertTrue(Factory.getInstance().getBlock("grep") instanceof GrepBlock);
        Assert.assertTrue(Factory.getInstance().getBlock("dump") instanceof DumpBlock);
        Assert.assertTrue(Factory.getInstance().getBlock("replace") instanceof ReplaceBlock);
        Assert.assertTrue(Factory.getInstance().getBlock("sort") instanceof SortBlock);
    }
}