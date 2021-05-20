package Application.ExecutorPackage.Factory;

import Application.ExecutorPackage.Exceptions.BlockException;
import Application.ExecutorPackage.Exceptions.FactoryInitializationException;
import Application.ExecutorPackage.Factory.Block.IBlock;
import org.apache.log4j.Logger;

import java.util.Properties;

public class Factory {

    private static final Logger logger = Logger.getLogger(Factory.class);
    static private volatile Factory instance;
    private final Properties config = new Properties();

    private Factory() throws FactoryInitializationException {
        try {
            var configStream = ClassLoader.getSystemResourceAsStream("Factory.properties");
            if (null != configStream) {
                config.load(configStream);
            } else {
                throw new FactoryInitializationException("Failed to open Factory.properties");
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new FactoryInitializationException("Failed initialization Factory", exception);
        }
    }

    /**
     * Singleton instance getter
     * This method is thread safe
     */
    static public Factory getInstance() throws FactoryInitializationException {
        if (null == instance) {
            synchronized (Factory.class) {
                if (null == instance) {
                    instance = new Factory();
                }
            }
        }
        logger.info("Returning instance");
        return instance;
    }

    public IBlock getBlock(String key) throws BlockException {
        try {
            if (config.containsKey(key)) {
                logger.info("Returned " + key + " block");
                return (IBlock) Class.forName(config.getProperty(key)).getDeclaredConstructor().newInstance();
            }
            throw new Exception("No such key in file");
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Failed making block");
            throw new BlockException("Failed making block", exception);
        }

    }
}
