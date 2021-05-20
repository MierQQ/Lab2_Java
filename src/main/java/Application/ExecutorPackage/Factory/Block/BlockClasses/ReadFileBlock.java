package Application.ExecutorPackage.Factory.Block.BlockClasses;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Factory.Block.BlockType;
import Application.ExecutorPackage.Factory.Block.IBlock;

import java.io.FileInputStream;
import java.util.List;

public class ReadFileBlock implements IBlock {
    @Override
    public void execute(List<String> args, StringBuilder input) throws BlockException {
        if (args.size() != 1) {
            throw new BlockException("Wrong number of args");
        }
        if (input == null) {
            throw new BlockException("input StringBuilder equals null");
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(args.get(0));
            String str = new String(fileInputStream.readAllBytes());
            input.append(str);
            fileInputStream.close();
        } catch (Exception exception) {
            throw new BlockException(exception);
        }
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.Out;
    }
}
