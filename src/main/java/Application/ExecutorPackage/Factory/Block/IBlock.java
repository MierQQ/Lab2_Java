package Application.ExecutorPackage.Factory.Block;

import Application.ExecutorPackage.Exceptions.BlockException;

import java.util.List;

public interface IBlock {
    BlockType getBlockType();

    void execute(List<String> args, StringBuilder input) throws BlockException;
}
