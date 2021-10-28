package tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.ConfProperties;

import java.util.concurrent.TimeUnit;

public class AboutPageTest {
    public static WebDriver driver;
    public static AboutPage aboutPage;

    @BeforeClass
    public static void setup() {
        driver = Browser.getInstance();
        aboutPage = new AboutPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getPropertyString("URLAboutPage"));
    }

    @Test
    public static void comparisonOnlineAndGameOnlineMoreTrue() {
        boolean fact = aboutPage.comparisonOnlineAndGame();
        Assert.assertTrue(fact);
    }


    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}
