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
    private final String xpathResultsTotal = "//span[@id='searchResults_total']";
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
    private WebElement resultsTotalUpdated;
    private WebElement firstItem;
    private String resultsTotal;

    public String getNameFirstItem() {
        firstItem = expectedConditions(xpathFirstItem);
        return firstItem.getText();
    }

    public void clickFirstItem() {
        firstItem = expectedConditions(xpathFirstItem);
        firstItem.click();
    }

    public boolean listUpdated() {
        resultsTotalUpdated = expectedConditions(xpathResultsTotal);
        return (resultsTotal != resultsTotalUpdated.getText());
    }

    public void deleteFilters() {
        resultsTotalUpdated = expectedConditions(xpathResultsTotal);
        resultsTotal = resultsTotalUpdated.getText();
        deleteInputSearch = expectedConditions(xpathDeleteInputSearch);
        deleteInputSearch.click();
        deleteDota2 = expectedConditions(xpathDeleteDota2);
        deleteDota2.click();
    }

    public void clickShowAdvancedOptions() {
        showAdvancedOptions = expectedConditions(xpathShowAdvancedOptions);
        showAdvancedOptions.click();
    }

    public boolean checkSearchResults() {
        List<WebElement> searchResults = findElements(xpathSearchResults);
        boolean result = false;
        int check = 0;
        for (int i = 0; i < 5; i++) {
            if (searchResults.get(i).getText().contains("Golden"))
                check++;
        }
        if (check == 5)
            return true;
        return result;
    }


    public boolean checkFiltersSearch() {
        List<WebElement> filtersSearch = findElements(xpathFiltersSearch);
        int check = 0;
        boolean result = false;

        check = check + checkFilters(filtersSearch, "filtersSearchGame");
        check = check + checkFilters(filtersSearch, "filtersSearchGame");
        check = check + checkFilters(filtersSearch, "filtersSearchGame");
        check = check + checkFilters(filtersSearch, "filtersSearchGame");

        if (check == 4)
            result = true;
        return result;
    }

    public void choosingSearchParameters() {
        game();
        hero();
        rarity();
        search();
    }


    public boolean getUniqueElementShowAdvancedOptions() {
        List<WebElement> advancedSearch = findElements(xpathAdvancedSearch);
        return (advancedSearch.size() > 0);
    }

    public boolean getUniqueElementMarketPage() {
        List<WebElement> gutterBlock = findElements(xpathFindItems);
        return (gutterBlock.size() > 0);
    }

    public void clickButtonSearch() {
        buttonSearch = expectedConditions(xpathButtonSearch);
        buttonSearch.click();
    }

    private void game() {
        selectedGame = expectedConditions(xpathSelectedGame);
        selectedGame.click();
        dota2 = expectedConditions(xpathDota2);
        dota2.click();
    }

    private void hero() {
        selectedHero = expectedConditions(xpathSelectedHero);
        selectedHero.click();
        lifestealer = expectedConditions(xpathLifestealer);
        lifestealer.click();
    }

    private void rarity() {
        selectedRarity = expectedConditions(xpathSelectedRarity);
        selectedRarity.click();
    }

    private void search() {
        inputSearch = expectedConditions(xpathInputSearch);
        inputSearch.sendKeys(ConfigProperties.getPropertyString("searchParameter"));
    }

    private int checkFilters(List<WebElement> list, String filter) {
        int ret = 0;

        switch (filter) {
            case "filtersSearchGame":
                if (list.get(0).getText().equals(ConfigProperties.getPropertyString(filter)))
                    ret = 1;
                break;
            case "filtersSearchHero":
                if (list.get(1).getText().equals(ConfigProperties.getPropertyString(filter)))
                    ret = 1;
                break;
            case "filtersSearchRarity":
                if (list.get(2).getText().equals(ConfigProperties.getPropertyString(filter)))
                    ret = 1;
                break;
            case "searchParameter":
                if (list.get(3).getText().equals(ConfigProperties.getPropertyString(filter)))
                    ret = 1;
                break;
        }
        return ret;
    }

}
