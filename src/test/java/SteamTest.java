import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

@Test
public class SteamTest {
    public static HomePage homePage;
    public static AboutPage aboutPage;
    public static SalesLeadersPage salesLeadersPage;
    public static FirstGamePage firstGamePage;


    @BeforeClass
    public void setup() {
        Browser.getDriver().get(ConfProperties.getPropertyString("URLHomePage"));
        homePage = new HomePage();
        aboutPage = new AboutPage();
        salesLeadersPage = new SalesLeadersPage();
        Browser.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void openRequiredPages() {
        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage());

        homePage.clickButtonAbout();
        Assert.assertTrue(aboutPage.getUniqueElementAboutPage());

        Assert.assertTrue(aboutPage.getGamersOnline() >= aboutPage.getGamersInGame());

        homePage.clickSubMenuStore();
        Assert.assertTrue(homePage.getUniqueElementHomePage());
    }

    public static void samplesOfGames() {
        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage());

        homePage.clickPopupMenuSalesLeaders();
        Assert.assertTrue(salesLeadersPage.getUniqueElementSalesLeadersPage());

        /*
        salesLeadersPage.clickCheckBoxSteamOSPlusLinux(driver);
        Assert.assertTrue(salesLeadersPage.statusCheckBoxSteamOSPlusLinux());

        salesLeadersPage.clickCheckBoxCooperativeLAN(driver);
        Assert.assertTrue(salesLeadersPage.statusCheckBoxCooperativeLAN());

        salesLeadersPage.getNumberOfActionGames(driver);

        salesLeadersPage.clickCheckBoxAction(driver);
        Assert.assertTrue(salesLeadersPage.statusCheckBoxAction() &&
                (salesLeadersPage.getNumberOfActionGames(driver) == salesLeadersPage.getNumberGamesInList(driver)) &&
                (salesLeadersPage.getNumberOfActionGames(driver) == salesLeadersPage.getNumberGamesOnRequest()));

        salesLeadersPage.getInfoFirstGame(driver);

        salesLeadersPage.clickFirstGame();
        Assert.assertTrue(salesLeadersPage.getInfoFirstGame(driver)==firstGamePage.getInfoWithFirstGamePage());
        */
    }

    @AfterClass
    public void closeDriver() {
        Browser.getDriver().quit();
    }
}
