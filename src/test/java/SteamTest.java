import browser.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

@Test
public class SteamTest {
    private static HomePage homePage;
    private static AboutPage aboutPage;
    private static SalesLeadersPage salesLeadersPage;
    private static GamePage gamePage;

    @BeforeClass
    public void setup() {
        BrowserFactory.getDriver().get(ConfigProperties.getPropertyString("URLHomePage"));
        BrowserFactory.getDriver().manage().timeouts();
    }

    public static void openRequiredPages() {
        homePage = new HomePage();
        aboutPage = new AboutPage();

        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage(),
                "Не перешел на главную страницу.");

        homePage.clickButtonAbout();
        Assert.assertTrue(aboutPage.getUniqueElementAboutPage(),
                "Не перешел на страницу \"About\".");

        Assert.assertTrue(aboutPage.getGamersOnline() > aboutPage.getGamersInGame(),
                "Число игроков онлайн меньше, чем в игре.");

        homePage.clickSubMenuStore();
        Assert.assertTrue(homePage.getUniqueElementHomePage(),
                "Не перешел на страницу магазина.");
    }

    public static void samplesOfGames() {
        homePage = new HomePage();
        salesLeadersPage = new SalesLeadersPage();
        gamePage = new GamePage();

        homePage.clickPopupMenuHomePage();
        Assert.assertTrue(homePage.getUniqueElementHomePage(),
                "Не перешел на главную страницу.");

        homePage.clickPopupMenuSalesLeaders();
        Assert.assertTrue(salesLeadersPage.getUniqueElementSalesLeadersPage(),
                "Не перешел на страницу \"Лидеры продаж\".");

        salesLeadersPage.clickCheckBoxSteamOSPlusLinux();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxSteamOSPlusLinux(),
                "Чекбокс \"SteamOS + Linux\" в блоке \"Операционная система\" не выбран.");
        salesLeadersPage.clickCheckBoxCooperativeLAN();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxCooperativeLAN(),
                "Чекбокс \"Кооператив (LAN)\" в блоке \"Количество игроков\" не выбран.");

        salesLeadersPage.clickCheckBoxAction();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxAction(),
                "Чекбокс \"Экшен\" в блоке \"Метки\" не выбран.");
        Assert.assertTrue(salesLeadersPage.getNumberOfActionGames() == salesLeadersPage.getNumberGamesInList(),
                "Указанное количество результатов по запросу не соответствует количеству игр с меткой \"Экшен\"");
        Assert.assertTrue(salesLeadersPage.getNumberOfActionGames() == salesLeadersPage.getNumberGamesOnRequest(),
                "Количество игр в списке не соответствует количеству игр с меткой \"Экшен\"");

        salesLeadersPage.getInfoFirstGame();

        salesLeadersPage.clickFirstGame();
        Assert.assertTrue(gamePage.getUniqueElementGamePage(),
                "Не перешел на страницу с описанием игры.");
        Assert.assertTrue(salesLeadersPage.getInfoFirstGame() == gamePage.getInfoWithGamePage(),
                "Название игры, дата релиза и цена в списке результатов не соответствуем на странице с описанием игры");
    }

    @AfterClass
    public void quitDriver() {
        BrowserFactory.getDriver().quit();
    }
}
