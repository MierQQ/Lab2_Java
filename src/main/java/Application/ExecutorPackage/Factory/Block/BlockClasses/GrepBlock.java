package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Factory.Block.BlockType;
import Application.ExecutorPackage.Factory.Block.IBlock;

import java.util.List;

public class GrepBlock implements IBlock {
    @Override
    public void execute(List<String> args, StringBuilder input) throws BlockException {
        if (args.size() != 1) {
            throw new BlockException("Wrong number of args");
        }
        StringBuilder buffer = new StringBuilder(input);
        input.delete(0, input.length());
        String[] str = buffer.toString().split("\n");
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains(args.get(0))) {
                input.append(str[i]);
                if (i != str.length - 1) {
                    input.append("\n");
                }
            }
        }
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.inOut;
    }
}
