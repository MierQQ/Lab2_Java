package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Factory.Block.BlockType;
import Application.ExecutorPackage.Factory.Block.IBlock;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortBlock implements IBlock {

    @Override
    public BlockType getBlockType() {
        return BlockType.inOut;
    }

    @Override
    public void execute(List<String> args, StringBuilder input) throws BlockException {
        if (args.size() != 0) {
            throw new BlockException("Wrong number of args");
        }
        StringBuilder buffer = new StringBuilder(input);
        input.delete(0, input.length());
        String[] strArray = buffer.toString().replace("\n", " ").split(" ");
        var str = Arrays.stream(strArray).sorted(Comparator.comparing(String::toLowerCase)).toArray();
        for (int i = 0; i < str.length; ++i) {
            input.append(str[i]);
            if (i != str.length - 1) {
                input.append("\n");
            }
        }
    }
}
