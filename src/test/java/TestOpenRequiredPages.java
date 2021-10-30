import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.ConfProperties;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

@Test
public class TestOpenRequiredPages {
    public static WebDriver driver;
    public static HomePage homePage;
    public static AboutPage aboutPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        homePage = new HomePage(driver);
        aboutPage = new AboutPage();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(ConfProperties.getPropertyString("URLHomePage"));
    }

    @Test(priority = 1)
    public static void clickPopupMenuHomePage_ToGoTheMainPage_True() {
        homePage.clickPopupMenuHomePage(driver);
        Assert.assertTrue(homePage.getUniqueElementHomePage(driver));
    }

    @Test(priority = 2)
    public static void clickButtonAbout_ToGoTheAboutPage_True() {
        homePage.clickButtonAbout();
        Assert.assertTrue(aboutPage.getUniqueElementAboutPage(driver));

    }

    @Test(priority = 3)
    public static void comparisonOnlineAndGameOnlineMore_OnlineGamersAreMore_True() {
        Assert.assertTrue(aboutPage.getGamersOnline(driver) >= aboutPage.getGamersInGame(driver));
    }

    @Test(priority = 4)
    public static void clickSubMenuStore_ToGoTheMainPage_True() {
        homePage.clickSubMenuStore();
        Assert.assertTrue(homePage.getUniqueElementHomePage(driver));
    }


    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
