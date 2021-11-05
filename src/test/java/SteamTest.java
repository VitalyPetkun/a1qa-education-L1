import browser.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.List;

public class SteamTest {
    private static HomePage homePage;
    private static AboutPage aboutPage;
    private static SalesLeadersPage salesLeadersPage;
    private static GamePage gamePage;
    private static MarketPage marketPage;
    private static ItemClass itemClass;

    @BeforeMethod
    private void setup() {
        BrowserFactory.getDriver().get(ConfigProperties.getPropertyString("URLHomePage"));
        BrowserFactory.getDriver().manage().timeouts();
    }

    @Test
    private void openRequiredPages() {
        homePage = new HomePage();
        aboutPage = new AboutPage();

        homePage.getHeaderPage().clickPopupMenuHomePage();
        Assert.assertTrue((homePage.getUniqueElementHomePage() > 0),
                "Didn't go to the Home page.");

        homePage.getHeaderPage().clickButtonAbout();
        Assert.assertTrue((aboutPage.getUniqueElementAboutPage() > 0),
                "Didn't go to the About page.");

        Assert.assertTrue(aboutPage.getGamersOnline() > aboutPage.getGamersInGame(),
                "The number of players online is less than in the game.");

        aboutPage.getHeaderPage().clickSubMenuStore();
        Assert.assertTrue((homePage.getUniqueElementHomePage() > 0),
                "Didn't go to the Home page.");
    }


    @Test
    private void samplesOfGames() {
        homePage = new HomePage();
        salesLeadersPage = new SalesLeadersPage();
        gamePage = new GamePage();
        int numberGamesOnRequestBeforeClickCheckBoxAction;
        int numberOfActionGames;
        int numberGamesOnRequestAfterClickCheckBoxAction;

        homePage.getHeaderPage().clickPopupMenuHomePage();
        Assert.assertTrue((homePage.getUniqueElementHomePage() > 0),
                "Didn't go to the Home page.");

        homePage.clickPopupMenuSalesLeaders();
        Assert.assertTrue((salesLeadersPage.getUniqueElementSalesLeadersPage() > 0),
                "Didn't go to the Top Sellers page.");

        salesLeadersPage.clickCheckBoxSteamOSPlusLinux();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxSteamOSPlusLinux(),
                "CheckBox 'SteamOS + Linux' in the block 'OS' not selected.");

        salesLeadersPage.clickCheckBoxCooperativeLAN();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxCooperativeLAN(),
                "CheckBox 'Cooperative (LAN)' in the block 'Number of players' not selected.");

        numberGamesOnRequestBeforeClickCheckBoxAction = salesLeadersPage.getNumberGamesOnRequest();
        numberOfActionGames = salesLeadersPage.getNumberOfActionGames();

        salesLeadersPage.clickCheckBoxAction();
        Assert.assertTrue(salesLeadersPage.statusCheckBoxAction(),
                "CheckBox 'Action' in the block 'Tags' not selected.");

        numberGamesOnRequestAfterClickCheckBoxAction = salesLeadersPage.getNumberGamesOnRequest();

        while (numberGamesOnRequestBeforeClickCheckBoxAction == numberGamesOnRequestAfterClickCheckBoxAction) {
            numberGamesOnRequestAfterClickCheckBoxAction = salesLeadersPage.getNumberGamesOnRequest();
        }

        Assert.assertTrue(numberOfActionGames == numberGamesOnRequestAfterClickCheckBoxAction,
                "The number of games in the list does not match the number of games with a tag 'Action'.");

        Assert.assertTrue(numberOfActionGames == salesLeadersPage.getNumberGamesInList(),
                "The specified number of results for the request does not match the number of games with the tag 'Action'.");

        List<String> infoFirstGame = salesLeadersPage.getInfoFirstGame();
        salesLeadersPage.clickFirstGame();
        List<String> infoGame = gamePage.getInfoWithGamePage();

        Assert.assertTrue(gamePage.getUniqueElementGamePage(),
                "Didn't go to the page with the description of the game.");
        Assert.assertTrue(infoFirstGame.containsAll(infoGame) && infoGame.containsAll(infoFirstGame),
                "Game name, release date and price in the results list do not match on the game description page.");
    }

    @Test
    private void searchFilters() {
        homePage = new HomePage();
        marketPage = new MarketPage();
        itemClass = new ItemClass();
        String resultsBeforeUpdated;
        String nameFirstItem;
        String nameItem;

        homePage.getHeaderPage().clickPopupMenuHomePage();
        Assert.assertTrue((homePage.getUniqueElementHomePage() > 0),
                "Didn't go to the Home page.");

        homePage.getHeaderPage().clickPopupMenuCommunityMarketPage();
        Assert.assertTrue((marketPage.getUniqueElementMarketPage() > 0),
                "Didn't go to the Community Market page.");

        marketPage.clickShowAdvancedOptions();
        Assert.assertTrue((marketPage.getUniqueElementShowAdvancedOptions() > 0),
                "The form SEARCH COMMUNITY MARKET not open.");

        marketPage.choosingSearchParameters();
        marketPage.clickButtonSearch();

        Assert.assertTrue(marketPage.checkFiltersSearch(ConfigProperties.getPropertyString("filtersSearchGame"))
                        .equals(ConfigProperties.getPropertyString("filtersSearchGame")),
                "Search filter did not appear - Dota 2");
        Assert.assertTrue(marketPage.checkFiltersSearch(ConfigProperties.getPropertyString("filtersSearchHero"))
                        .equals(ConfigProperties.getPropertyString("filtersSearchHero")),
                "Search filter did not appear - Lifestealer");
        Assert.assertTrue(marketPage.checkFiltersSearch(ConfigProperties.getPropertyString("filtersSearchRarity"))
                        .equals(ConfigProperties.getPropertyString("filtersSearchRarity")),
                "Search filter did not appear - Immortal");
        Assert.assertTrue(marketPage.checkFiltersSearch(ConfigProperties.getPropertyString("searchParameter"))
                        .equals(ConfigProperties.getPropertyString("searchParameter")),
                "Search filter did not appear - golden");
        for (int i = 0; i < ConfigProperties.getPropertyInt("numberItemForCheckSearchParameter"); i++) {
            Assert.assertTrue(marketPage.checkSearchResults(i).contains("Golden"),
                    "The first five results do not contain a word 'Golden' in the title.");
        }

        resultsBeforeUpdated = marketPage.getResultsBeforeUpdated();
        marketPage.deleteFilters();
        Assert.assertTrue((resultsBeforeUpdated != marketPage.listUpdated()), "The list of items has not been updated.");

        nameFirstItem = marketPage.getNameFirstItem();
        marketPage.clickFirstItem();
        Assert.assertTrue(itemClass.checkFilters(ConfigProperties.getPropertyString("filtersSearchHero"))
                        .contains(ConfigProperties.getPropertyString("filtersSearchHero")),
                "Information on the item page does not match the filter - Lifestealer");
        Assert.assertTrue(itemClass.checkFilters(ConfigProperties.getPropertyString("filtersSearchRarity"))
                        .contains(ConfigProperties.getPropertyString("filtersSearchRarity")),
                "Information on the item page does not match the filter - Immortal");
        nameItem = itemClass.getNameItem();
        Assert.assertTrue(nameFirstItem.equals(nameItem),
                "Item name from the previous page does not match.");
    }

    @AfterMethod
    private void quitDriver() {
        BrowserFactory.quit();
    }
}
