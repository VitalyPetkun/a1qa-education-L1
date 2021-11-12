package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        try {
            driver = factoryMethod(driver);
        } catch (NullPointerException ex) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
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
