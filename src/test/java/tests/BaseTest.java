package tests;

import Utils.ConfigManager;
import browser.Browser;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeMethod
    private void setup() {
        Browser.openUrl(ConfigManager.getPropertyString("URLHomePage"));
    }

    @AfterMethod
    private void quitDriver() {
        Browser.quit();
    }
}