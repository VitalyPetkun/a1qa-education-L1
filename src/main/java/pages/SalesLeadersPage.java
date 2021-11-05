package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SalesLeadersPage extends MethodsForSearch {
    private final String xpathAdditionalSearchOptions = "//div[@id='additional_search_options']";
    private final String xpathBlockContentOS = "//div[@data-collapse-name='os']//div[@class='block_content block_content_inner']";
    private final String xpathCheckBoxSteamOSPlusLinux = "//div[contains(@data-value,'linux')]/span";
    private final String xpathBlockHeaderNumberGamers = "//div[@data-collapse-name='category3']//div[@class='block_header']";
    private final String xpathCheckBoxCooperativeLAN = "//div[@data-value='48']/span";
    private final String xpathFlagSeeAll = "//div[@data-collapse-name='tags']/a";
    private final String xpathCheckBoxAction = "//div[@id='TagFilter_Container']//div[@data-value='19']";
    private final String xpathFirstGameInList = "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]";
    private final String xpathNameFirstGameInList = "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//span[@class='title']";
    private final String xpathDateOfReleaseFirstGameInList = "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//div[contains(@class,'search_released')]";
    private final String xpathPriceFirstGameInList = "//a[contains(@class,'search_result_row')][1]//div[@class='col search_price  responsive_secondrow']";
    private final String xpathNumberOfGamesAction = "//div[@data-value='19']//span[@class='tab_filter_control_count']";
    private final String xpathNumberGamesOnRequest = "//div[@id='search_results']//div[@class='search_results_count']";
    private final String xpathBlockHeaderOS = "//div[@class='block search_collapse_block'][@data-collapse-name='os']//div[@class='block_header']";
    private final String xpathGamesResultList = "//div[@id='search_resultsRows']/a";
    private final String xpathBlockContentNumberGamers = "//div[@data-collapse-name='category3']//div[contains(@class,'block_content')]";

    private WebElement blockContentOS;
    private WebElement checkBoxSteamOSPlusLinux;
    private WebElement blockHeaderNumberGamers;
    private WebElement blockContentNumberGamers;
    private WebElement checkBoxCooperativeLAN;
    private WebElement flagSeeAll;
    private WebElement checkBoxAction;
    private WebElement firstGameInList;
    private WebElement blockHeaderOS;
    private WebElement numberOfGamesAction;
    private WebElement numberGamesOnRequest;

    public void clickCheckBoxSteamOSPlusLinux() {
        blockContentOS = findElement(xpathBlockContentOS);
        blockHeaderOS = findElement(xpathBlockHeaderOS);
        if (!blockContentOS.isDisplayed())
            blockHeaderOS.click();
        checkBoxSteamOSPlusLinux = expectedConditions(xpathCheckBoxSteamOSPlusLinux);
        checkBoxSteamOSPlusLinux.click();
    }

    public boolean statusCheckBoxSteamOSPlusLinux() {
        return checkBoxSteamOSPlusLinux.isEnabled();
    }

    public void clickCheckBoxCooperativeLAN() {
        blockContentNumberGamers = findElement(xpathBlockContentNumberGamers);
        blockHeaderNumberGamers = findElement(xpathBlockHeaderNumberGamers);
        if (!blockContentNumberGamers.isDisplayed())
            blockHeaderNumberGamers.click();
        checkBoxCooperativeLAN = findElement(xpathCheckBoxCooperativeLAN);
        if (invisibilityOfElementWithText(xpathCheckBoxCooperativeLAN, checkBoxCooperativeLAN.getText()))
            checkBoxCooperativeLAN.click();
    }

    public boolean statusCheckBoxCooperativeLAN() {
        return checkBoxCooperativeLAN.isEnabled();
    }

    public void clickCheckBoxAction() {
        checkBoxAction = expectedConditions(xpathCheckBoxAction);
        checkBoxAction.click();
    }

    public boolean statusCheckBoxAction() {
        return checkBoxAction.isEnabled();
    }

    public List<String> getInfoFirstGame() {
        List<String> infoFirstGameInList = new ArrayList<String>();
        infoFirstGameInList.add(0, getNameFirstGame());
        infoFirstGameInList.add(1, getDateOfReleaseFirstGame());
        infoFirstGameInList.add(2, getPriceFirstGame());
        return infoFirstGameInList;
    }

    public void clickFirstGame() {
        firstGameInList = expectedConditions(xpathFirstGameInList);
        firstGameInList.click();
    }

    public int getUniqueElementSalesLeadersPage() {
        List<WebElement> additionalSearchOptions = findElements(xpathAdditionalSearchOptions);
        return additionalSearchOptions.size();
    }

    public int getNumberOfActionGames() {
        flagSeeAll = expectedConditions(xpathFlagSeeAll);
        flagSeeAll.click();
        int returnNum = 0;
        numberOfGamesAction = expectedConditions(xpathNumberOfGamesAction);
            returnNum = webElementInInt(numberOfGamesAction);
        return returnNum;
    }

    public int getNumberGamesOnRequest() {
        numberGamesOnRequest = expectedConditions(xpathNumberGamesOnRequest);
            return webElementInInt(findElement(xpathNumberGamesOnRequest));
    }

    public int getNumberGamesInList() {
        List<WebElement> gamesResultList = findElements(xpathGamesResultList);
            return gamesResultList.size();
    }

    private String getNameFirstGame() {
        return expectedConditions(xpathNameFirstGameInList).getText();
    }

    private String getDateOfReleaseFirstGame() {
        return expectedConditions(xpathDateOfReleaseFirstGameInList).getText();
    }

    private String getPriceFirstGame() {
        return String.valueOf(webElementInInt(expectedConditions(xpathPriceFirstGameInList)));
    }
}
