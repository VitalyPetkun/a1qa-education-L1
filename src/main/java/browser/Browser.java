package browser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import utils.ConfigManager;

public class Browser extends BrowserFactory{
    private static WebDriver driver;
    private static Browser browser;

    public static WebDriver getDriver() {
        if (browser == null) {
            browser = new Browser();
            setUpDriver();
        }
        return driver;
    }

    private static WebDriver setUpDriver() {
        driver = factoryMethod(driver);
        driver = setSize();
        driver.manage().timeouts();
        return driver;
    }

    private static WebDriver setSize() {
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver openUrl(String url) {
        getDriver().get(url);
        return getDriver();
    }

    public static void quit() {
        driver.quit();
        browser = null;
    }
}
