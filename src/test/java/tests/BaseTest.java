package tests;

import utils.ConfigManager;
import browser.Browser;
import org.testng.annotations.*;
import utils.MyLogger;

public class BaseTest {
    @BeforeMethod
    protected void setup() {
        MyLogger.logInfo("open Browser.");
    }

    @AfterMethod
    protected void quitDriver() {
        MyLogger.logInfo("close Browser.");
        Browser.quit();
    }
}