package tests;

import utils.ConfigManager;
import browser.Browser;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeMethod
    protected void setup() {
        Browser.openUrl(ConfigManager.getConfigString("URLHomePage"));
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}