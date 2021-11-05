package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.ConfigProperties;

public class BrowserFactory {
    private static WebDriver driver;
    private static BrowserFactory browser;

    public static WebDriver getDriver() {
        if (browser == null) {
            browser = new BrowserFactory();
            setupsBrowser();
        }
        return driver;
    }

    private static WebDriver setupsBrowser() {
        factoryMethod();
        setSizeFrameBrowser();
        return driver;
    }

    private static void setSizeFrameBrowser() {
        driver.manage().window().setSize(new Dimension(
                ConfigProperties.getPropertyInt("widthFrameBrowser"),
                ConfigProperties.getPropertyInt("heightFrameBrowser")));
    }

    private static void factoryMethod() {
        switch (ConfigProperties.getPropertyString("nameBrowser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
    }

    public static void quit() {
        driver.quit();
        browser = null;
    }
}
