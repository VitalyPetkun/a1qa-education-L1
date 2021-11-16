package tests;

import utils.ConfigManager;
import browser.Browser;
import org.testng.annotations.*;
import utils.MyLogger;

public class BaseTest {
    @BeforeMethod
    protected void setup() {
        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));
        MyLogger.logInfo("open Browser.");
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
        MyLogger.logInfo("close Browser.");
    }
}