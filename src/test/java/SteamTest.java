import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

@Test
public class SteamTest {
    public static HomePage homePage;
    public static AboutPage aboutPage;
    public static SalesLeadersPage salesLeadersPage;
    public static GamePage firstGamePage;

    @BeforeClass
    public void setup() {
        Browser.getDriver().get(ConfigProperties.getPropertyString("URLHomePage"));
        homePage = new HomePage();
        aboutPage = new AboutPage();
        salesLeadersPage = new SalesLeadersPage();
        Browser.getDriver().manage().timeouts();
    }

    public static void openRequiredPages() {
        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage());

        homePage.clickButtonAbout();
        Assert.assertTrue(aboutPage.getUniqueElementAboutPage());

        Assert.assertTrue(aboutPage.getGamersOnline() > aboutPage.getGamersInGame());

        homePage.clickSubMenuStore();
        Assert.assertTrue(homePage.getUniqueElementHomePage());
    }

    public static void samplesOfGames() {
        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage());

        homePage.clickPopupMenuSalesLeaders();
        Assert.assertTrue(salesLeadersPage.getUniqueElementSalesLeadersPage());

        salesLeadersPage.clickCheckBoxSteamOSPlusLinux();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxSteamOSPlusLinux());

        salesLeadersPage.clickCheckBoxCooperativeLAN();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxCooperativeLAN());

        salesLeadersPage.clickCheckBoxAction();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxAction() &&
                (salesLeadersPage.getNumberOfActionGames() == salesLeadersPage.getNumberGamesInList()) &&
                (salesLeadersPage.getNumberOfActionGames() == salesLeadersPage.getNumberGamesOnRequest()));
        salesLeadersPage.getInfoFirstGame();

        salesLeadersPage.clickFirstGame();
        Assert.assertTrue(salesLeadersPage.getInfoFirstGame() == firstGamePage.getInfoWithGamePage());

    }

    @AfterClass
    public void closeDriver() {
        Browser.getDriver().quit();
    }
}
