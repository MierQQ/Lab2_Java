package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Factory.Block.BlockType;
import Application.ExecutorPackage.Factory.Block.IBlock;

import java.io.FileWriter;
import java.util.List;

public class WriteFileBlock implements IBlock {
    @Override
    public void execute(List<String> args, StringBuilder input) throws BlockException {
        if (args.size() != 1) {
            throw new BlockException("Wrong number of args");
        }
        try (FileWriter writer = new FileWriter(args.get(0))) {
            writer.write(input.toString());
        } catch (Exception exception) {
            throw new BlockException(exception);
        }
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.In;
    }
}
