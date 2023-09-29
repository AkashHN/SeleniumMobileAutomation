import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class Log4jConfiguration {

    private static final Logger logger = LogManager.getLogger(Log4jConfiguration.class);

    @BeforeSuite
    public void setUpLog4j() {
        // Initialize Log4j
        System.setProperty("log4j.configurationFile", "log4j2.xml");
        logger.info("Log4j initialized");
    }
}
