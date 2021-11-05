package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketPage extends MethodsForSearch {
    private final String xpathFindItems = "//div[@id='findItems']//div";
    private final String xpathShowAdvancedOptions = "//div[@id='market_search_advanced_show']//span";
    private final String xpathAdvancedSearch = "//div[@id='market_advancedsearch_dialog']//span";
    private final String xpathSelectedGame = "//div[@id='app_option_0_selected']//span";
    private final String xpathDota2 = "//div[@id='app_option_570']//span";
    private final String xpathSelectedHero = "//select[@name='category_570_Hero[]']";
    private final String xpathLifestealer = "//option[contains(@value,'life_stealer')]";
    private final String xpathSelectedRarity = "//input[@id='tag_570_Rarity_Rarity_Immortal']";
    private final String xpathInputSearch = "//input[@id='advancedSearchBox']";
    private final String xpathButtonSearch = "//div[@class='btn_medium btn_green_white_innerfade']//span";
    private final String xpathFiltersSearch = "//div//a[@class='market_searchedForTerm']";
    private final String xpathSearchResults = "//div[@id='searchResultsRows']//a//span[contains(@class,'market_listing_item_name')]";
    private final String xpathDeleteDota2 = "//div/a[@class='market_searchedForTerm'][1]/span";
    private final String xpathDeleteInputSearch = "//div/a[@class='market_searchedForTerm'][4]/span";
    private final String xpathResults = "//span[@id='searchResults_total']";
    private final String xpathFirstItem = "//span[@id='result_0_name']";

    private WebElement showAdvancedOptions;
    private WebElement selectedGame;
    private WebElement selectedHero;
    private WebElement dota2;
    private WebElement lifestealer;
    private WebElement selectedRarity;
    private WebElement inputSearch;
    private WebElement deleteDota2;
    private WebElement deleteInputSearch;
    private WebElement buttonSearch;
    private WebElement resultsAfterUpdated;
    private WebElement firstItem;
    private String strResultsBeforeUpdated;

    public String getNameFirstItem() {
        firstItem = expectedConditions(xpathFirstItem);
        return firstItem.getText();
    }

    public void clickFirstItem() {
        firstItem = expectedConditions(xpathFirstItem);
        firstItem.click();
    }

    public String listUpdated() {
        resultsAfterUpdated = expectedConditions(xpathResults);
        return resultsAfterUpdated.getText();
    }

    public String getResultsBeforeUpdated() {
        resultsAfterUpdated = expectedConditions(xpathResults);
        strResultsBeforeUpdated = resultsAfterUpdated.getText();
        return strResultsBeforeUpdated;
    }

    public void deleteFilters() {
        deleteInputSearch = expectedConditions(xpathDeleteInputSearch);
        deleteInputSearch.click();
        deleteDota2 = expectedConditions(xpathDeleteDota2);
        deleteDota2.click();
    }

    public void clickShowAdvancedOptions() {
        showAdvancedOptions = expectedConditions(xpathShowAdvancedOptions);
        showAdvancedOptions.click();
    }

    public String checkSearchResults(int index) {
        List<WebElement> searchResults = findElements(xpathSearchResults);
        return searchResults.get(index).getText();
    }

    public String checkFiltersSearch(String filter) {
        List<WebElement> filtersSearch = findElements(xpathFiltersSearch);
        switch (filter) {
            case "filtersSearchGame":
                return filtersSearch.get(0).getText();
            case "filtersSearchHero":
                return filtersSearch.get(1).getText();
            case "filtersSearchRarity":
                return filtersSearch.get(2).getText();
            case "searchParameter":
                return filtersSearch.get(3).getText();
        }
        return filter;
    }

    public void choosingSearchParameters() {
        setFilterGame();
        setFilterHero();
        setFilterRarity();
        setFilterSearch();
    }

    public int getUniqueElementShowAdvancedOptions() {
        List<WebElement> advancedSearch = findElements(xpathAdvancedSearch);
        return advancedSearch.size();
    }

    public int getUniqueElementMarketPage() {
        List<WebElement> gutterBlock = findElements(xpathFindItems);
        return gutterBlock.size();
    }

    public void clickButtonSearch() {
        buttonSearch = expectedConditions(xpathButtonSearch);
        buttonSearch.click();
    }

    private void setFilterGame() {
        selectedGame = expectedConditions(xpathSelectedGame);
        selectedGame.click();
        dota2 = expectedConditions(xpathDota2);
        dota2.click();
    }

    private void setFilterHero() {
        selectedHero = expectedConditions(xpathSelectedHero);
        selectedHero.click();
        lifestealer = expectedConditions(xpathLifestealer);
        lifestealer.click();
    }

    private void setFilterRarity() {
        selectedRarity = expectedConditions(xpathSelectedRarity);
        selectedRarity.click();
    }

    private void setFilterSearch() {
        inputSearch = expectedConditions(xpathInputSearch);
        inputSearch.sendKeys(ConfigProperties.getPropertyString("searchParameter"));
    }
}
