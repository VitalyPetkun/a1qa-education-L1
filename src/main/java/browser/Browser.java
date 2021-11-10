package browser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import Utils.ConfigManager;

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
        factoryMethod(driver);
        setSize();
        driver.manage().timeouts();
        return driver;
    }

    private static void setSize() {
        driver.manage().window().setSize(new Dimension(
                ConfigManager.getPropertyInt("widthFrameBrowser"),
                ConfigManager.getPropertyInt("heightFrameBrowser")));
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
        browser = null;
    }
}
