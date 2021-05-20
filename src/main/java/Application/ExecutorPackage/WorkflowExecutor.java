package Application.ExecutorPackage;


import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Exceptions.FactoryInitializationException;
import Application.ExecutorPackage.Exceptions.FormatException;
import Application.ExecutorPackage.Factory.Block.BlockContext;
import Application.ExecutorPackage.Factory.Block.IBlock;
import Application.ExecutorPackage.Factory.Factory;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.*;

import static Application.ExecutorPackage.Factory.Block.BlockType.*;

public class WorkflowExecutor {
    private static final Logger logger = Logger.getLogger(WorkflowExecutor.class);
    private final Map<String, BlockContext> map;
    private InputStream input;

    public WorkflowExecutor(InputStream input) {
        this.input = input;
        map = new HashMap<>();
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public void execute() throws FormatException, BlockException, FactoryInitializationException {
        logger.info("Workflow start");
        int line = 0;
        Scanner scanner = new Scanner(input);
        String str;
        if (!scanner.hasNextLine()) {
            logger.info("Input stream is empty");
            scanner.close();
            return;
        }
        str = scanner.nextLine();
        line++;
        if (!str.replaceAll(" ", "").replaceAll("#.*", "").equals("desc")) {
            logger.error("Token \"desc\" not found");
            throw new FormatException("Token \"desc\" not found");
        }
        while (!str.equals("csed") && scanner.hasNextLine()) {
            str = scanner.nextLine();
            line++;
            if (str.replaceAll("#.*", "").replaceAll(" ", "").equals("csed")) {
                continue;
            }
            String[] stringArray = str.replaceAll("#.*", "").replaceAll(" +", " ").split(" ");
            if (!stringArray[0].matches("[1-9]\\d*")) {
                logger.error("Unrecognized token in " + stringArray[0] + " line:" + line + ". Need: Block number = Block name [Args]");
                throw new FormatException("Unrecognized token in " + stringArray[0] + " line:" + line + ". Need: Block number = Block name [Args]");
            }
            if (!stringArray[1].equals("=")) {
                logger.error("Unrecognized token in " + stringArray[0] + " line:" + line + ". Need: Block number = Block name [Args]");
                throw new FormatException("Unrecognized token in " + stringArray[0] + " line:" + line + ". Need: Block number = Block name [Args]");
            }
            List<String> args = new LinkedList<>(Arrays.asList(stringArray).subList(3, stringArray.length));
            IBlock block;
            try {
                block = Factory.getInstance().getBlock(stringArray[2]);
            } catch (BlockException | FactoryInitializationException e) {
                logger.error("Error while making block \"" + stringArray[2] + "\": " + e.getMessage());
                throw e;
            }
            BlockContext blockContext = new BlockContext(block, args);
            map.put(stringArray[0], blockContext);
        }
        if (!str.replaceAll("#.*", "").replaceAll(" ", "").equals("csed")) {
            logger.error("Token \"csed\" not found");
            throw new FormatException("Token \"csed\" not found");
        }
        if (!scanner.hasNextLine()) {
            logger.info("Workflow nodes not found");
            return;
        }

        String[] workflowNode = scanner.nextLine().replaceAll("#.*", "").replaceAll(" ", "").split("->");
        if (workflowNode.length == 0) {
            logger.info("Workflow nodes not found");
            return;
        }
        for (int i = 0; i < workflowNode.length; ++i) {
            if (i != 0 && i != workflowNode.length - 1) {
                if (map.get(workflowNode[i]).getType() != inOut) {
                    logger.error("Middle block is not \"inOut\" block");
                    throw new BlockException("Middle block is not \"inOut\" block");
                }
            }
            if (i == 0) {
                if (map.get(workflowNode[i]).getType() != Out) {
                    logger.error("First block is not \"In\" block");
                    throw new BlockException("First block is not \"In\" block");
                }
            }
            if (i == workflowNode.length - 1) {
                if (map.get(workflowNode[i]).getType() != In) {
                    logger.error("Last block is not \"Out\" block");
                    throw new BlockException("Last block is not \"Out\" block");
                }
            }
        }
        StringBuilder buffer = new StringBuilder();
        for (var node : workflowNode) {
            map.get(node).execute(buffer);
        }
        logger.info("Workflow end");
        scanner.close();
    }
}
