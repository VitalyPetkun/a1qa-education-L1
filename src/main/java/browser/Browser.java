package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfigProperties;

public class Browser {
    private static WebDriver driver;
    private static Browser browser;

    public static WebDriver getDriver() {
        if (browser == null) {
            browser = new Browser();
            setupsBrowser();
        }
        return driver;
    }

    private static WebDriver setupsBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setSizeFrameBrowser();
        return driver;
    }

    private static void setSizeFrameBrowser() {
        driver.manage().window().setSize(new Dimension(
                ConfigProperties.getPropertyInt("widthFrameBrowser"),
                ConfigProperties.getPropertyInt("heightFrameBrowser")));
    }
}
