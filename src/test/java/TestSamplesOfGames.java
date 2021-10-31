import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ConfProperties;
import pages.FirstGamePage;
import pages.HomePage;
import pages.SalesLeadersPage;

import java.util.concurrent.TimeUnit;

@Test
public class TestSamplesOfGames {
    public static WebDriver driver;
    public static HomePage homePage;
    public static SalesLeadersPage salesLeadersPage;
    public static FirstGamePage firstGamePage;

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
        Assert.assertTrue(salesLeadersPage.statusCheckBoxSteamOSPlusLinux());
    }

    @Test(priority = 4)
    public static void clickCheckBoxCooperativeLAN_CheckBoxSelected_True() {
        salesLeadersPage.clickCheckBoxCooperativeLAN(driver);
        Assert.assertTrue(salesLeadersPage.statusCheckBoxCooperativeLAN());
    }

    @Test(priority = 5)
    public static void getNumberOfActionGames() {
        salesLeadersPage.getNumberOfActionGames(driver);
    }

    @Test(priority = 6)
    public static void clickCheckBoxActionGames_CheckBoxSelected_True() {
        salesLeadersPage.clickCheckBoxAction(driver);
        Assert.assertTrue(salesLeadersPage.statusCheckBoxAction() &&
                (salesLeadersPage.getNumberOfActionGames(driver) == salesLeadersPage.getNumberGamesInList(driver)) &&
                (salesLeadersPage.getNumberOfActionGames(driver) == salesLeadersPage.getNumberGamesOnRequest()));
    }

    @Test(priority = 7)
    public static void getInfoForFirstGame() {
        salesLeadersPage.getInfoFirstGame(driver);
    }

    @Test(priority = 8)
    public static void clickFirstGame_ToGoTheFirstGamePage_True() {
        salesLeadersPage.clickFirstGame();
        Assert.assertTrue(salesLeadersPage.getInfoFirstGame(driver)==firstGamePage.getInfoWithFirstGamePage());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
