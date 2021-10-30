import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

    @Test(priority = 1)
    public static void clickMenuYourStore_ToGoTheMainPage_True() {
        homePage.clickPopupMenuHomePage(driver);
        Assert.assertTrue(homePage.getUniqueElementHomePage(driver));
    }

    @Test(priority = 2)
    public static void clickPopupMenuSalesLeaders_ToGoTheSalesLeadersPage_True() {
        homePage.clickPopupMenuSalesLeaders(driver);
        Assert.assertTrue(salesLeadersPage.getUniqueElementSalesLeadersPage(driver));
    }

    @Test(priority = 3)
    public static void clickCheckBoxSteamOSPlusLinux_CheckBoxSelected_True() {
        salesLeadersPage.clickCheckBoxSteamOSPlusLinux(driver);
        Assert.assertTrue(salesLeadersPage.checkBoxStatus());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
