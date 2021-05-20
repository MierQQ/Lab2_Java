package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Factory.Block.BlockType;
import Application.ExecutorPackage.Factory.Block.IBlock;

import java.util.List;

public class ReplaceBlock implements IBlock {

    @Override
    public BlockType getBlockType() {
        return BlockType.inOut;
    }

    @Override
    public void execute(List<String> args, StringBuilder input) throws BlockException {
        if (args.size() != 2) {
            throw new BlockException("Wrong number of args");
        }
        StringBuilder buffer = new StringBuilder(input);
        input.delete(0, input.length());
        input.append(buffer.toString().replace(args.get(0), args.get(1)));
    }
}
