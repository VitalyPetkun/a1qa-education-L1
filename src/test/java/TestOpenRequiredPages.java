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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getPropertyString("URLHomePage"));
    }

    public static void clickLogoHolderToGoTheMainPageTrue() {
        homePage.clickLogoHolder();
        Assert.assertEquals(ConfProperties.getPropertyString("URLHomePage"), driver.getCurrentUrl());
    }

    public static void clickButtonAboutToGoTheAboutPageTrue() {
        homePage.clickButtonAbout();
        Assert.assertEquals(ConfProperties.getPropertyString("URLAboutPage"), driver.getCurrentUrl());
    }

    public static void comparisonOnlineAndGameOnlineMoreTrue() {

        int num1 = aboutPage.getGamersOnline(driver);
        int num2 = aboutPage.getGamersInGame(driver);
        Assert.assertTrue(aboutPage.getGamersOnline(driver) >= aboutPage.getGamersInGame(driver));
    }

    public static void clickSubMenuStoreToGoTheMainPageTrue() {
        homePage.clickSubMenuStore();
        Assert.assertEquals(ConfProperties.getPropertyString("URLHomePage"), driver.getCurrentUrl());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
