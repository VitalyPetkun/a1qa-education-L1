package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfProperties;

public class Browser {
    private static WebDriver driver;
    private static Browser INSTANCE;

    private Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // size frame browser
        driver.manage().window().setSize(new Dimension(
                ConfProperties.getPropertyInt("widthFrameBrowser"),
                ConfProperties.getPropertyInt("heightFrameBrowser")));
    }

    public static WebDriver getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Browser();

        return driver;
    }

    /*public static void main(String[] args) {
        getInstance();
    }*/
}
