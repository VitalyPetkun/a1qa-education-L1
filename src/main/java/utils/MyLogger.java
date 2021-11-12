package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static final Logger logger = LogManager.getLogger(MyLogger.class);

    public void logInfo(String element, String page) {
        logger.info(element + " at " + page);
    }

    public void logWarn(String element, String page) {
        logger.warn(element + " at " + page);
    }

    public void logError(String element, String page) {
        logger.error(element + " at " + page);
    }
}
