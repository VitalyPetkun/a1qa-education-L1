package tests;

import utils.ConfigManager;
import browser.Browser;
import org.testng.annotations.*;
import utils.MyLogger;

public class BaseTest {
    @BeforeMethod
    protected void setup() {
        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));
        MyLogger.logInfo("Open Browser.");
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
        MyLogger.logInfo("Close Browser.");
    }
}