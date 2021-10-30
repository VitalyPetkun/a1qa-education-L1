import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.ConfProperties;
import pages.HomePage;
import pages.SalesLeadersPage;

import java.util.concurrent.TimeUnit;

@Test
public class TestSamplesOfGames {
    public static WebDriver driver;
    public static HomePage homePage;
    public static SalesLeadersPage salesLeadersPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        homePage = new HomePage(driver);
        salesLeadersPage = new SalesLeadersPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getPropertyString("URLHomePage"));
    }

    public static void clickMenuYourStoreToGoTheMainPageTrue() {
        homePage.clickMenuYourStore();
        Assert.assertTrue(homePage.getUniqueElementHomePage(driver));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
