package Application.ExecutorPackage.Factory.Block;

import Application.ExecutorPackage.Exceptions.BlockException;

import java.util.List;

public class BlockContext {
    private IBlock block;

    private BlockType type;
    private List<String> args;

    public BlockContext(IBlock block, List<String> args) {
        this.block = block;
        this.args = args;
        this.type = block.getBlockType();
    }

    public BlockType getType() {
        return type;
    }

    public IBlock getBlock() {
        return block;
    }

    public void setBlock(IBlock block) {
        this.block = block;
        this.type = block.getBlockType();
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }


    public String getArgs(int index) {
        return args.get(index);
    }

    public void execute(StringBuilder input) throws BlockException {
        block.execute(args, input);
    }
}
