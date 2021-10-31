package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SalesLeadersPage extends Base{
    private String xpathAdditionalSearchOptions = "//div[@id='additional_search_options']";
    private String xpathBlockContentOS =
            "//div[@class='block search_collapse_block'][@data-collapse-name='os']//div[@class='block_content block_content_inner']";
    private String xpathCheckBoxSteamOSPlusLinux =
            "//div[contains(@class,'tab_filter_control_row')][contains(@data-param,'os')][contains(@data-value,'linux')]//span";
    private String xpathBlockHeaderNumberGamers =
            "//div[@class='block search_collapse_block collapsed'][@data-collapse-name='category3']//div[@class='block_header']";
    private String xpathCheckBoxCooperativeLAN =
            "//div[@class='tab_filter_control_row '][@data-param='category3'][@data-value='48']//span[1]";
    private String xpathBlockHeaderTags =
            "//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//div[contains(@class,'block_header')]";
    private String xpathFlagSeeAll =
            "//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//a[@class='see_all_expander']";
    private String xpathCheckBoxAction = "//div[@id='TagFilter_Container']//div[@data-param='tags'][@data-value='19']";
    private String xpathFirstGameInList = "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]";
    private String xpathNameFirstGameInList =
            "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//span[@class='title']";
    private String xpathDateOfReleaseFirstGameInList =
            "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//div[contains(@class,'search_released')]";
    private String xpathPriceFirstGameInList =
            "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//div[contains(@class,'search_price discounted')]//br";
    private String xpathNumberOfGamesAction =
            "//div[@id='TagFilter_Container']//div[@data-param='tags'][@data-value='19']//span[@class='tab_filter_control_count']";
    private String xpathNumberGamesOnRequest = "//div[@id='search_results']//div[@class='search_results_count']";
    private String xpathBlockHeaderOS =
            "//div[@class='block search_collapse_block'][@data-collapse-name='os']//div[@class='block_header']";
    private String xpathGamesResultList = "//div[@id='search_resultsRows']";
    private String xpathBlockContentNumberGamers =
            "//div[@class='block search_collapse_block'][@data-collapse-name='category3']//div[@class='block_content block_content_inner']";
    private String xpathBlockContentTags =
            "//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//div[contains(@class,'block_content block_content_inner')]";

    private List<WebElement> additionalSearchOptions;
    private WebElement blockContentOS;
    private WebElement checkBoxSteamOSPlusLinux;
    private WebElement blockHeaderNumberGamers;
    private WebElement blockContentNumberGamers;
    private WebElement blockHeaderTags;
    private WebElement blockContentTags;
    private WebElement checkBoxCooperativeLAN;
    private WebElement flagSeeAll;
    private WebElement checkBoxAction;
    private WebElement firstGameInList;
    private WebElement nameFirstGameInList;
    private WebElement dateOfReleaseFirstGameInList;
    private WebElement priceFirstGameInList;
    private ArrayList<String> infoFirstGameInList;
    private WebElement blockHeaderOS;
    private WebElement numberOfGamesAction;
    private WebElement numberGamesOnRequest;
    private List<WebElement> gamesResultList;

    public void clickCheckBoxSteamOSPlusLinux() {
        blockContentOS = Browser.getDriver().findElement(By.xpath(xpathBlockContentOS));
        blockHeaderOS = Browser.getDriver().findElement(By.xpath(xpathBlockHeaderOS));
        if(!blockContentOS.isDisplayed())
            blockHeaderOS.click();
        checkBoxSteamOSPlusLinux = expectedConditions(xpathCheckBoxSteamOSPlusLinux);
        checkBoxSteamOSPlusLinux.click();
    }

    public boolean statusCheckBoxSteamOSPlusLinux() {
        return checkBoxSteamOSPlusLinux.isEnabled();
    }

    public void clickCheckBoxCooperativeLAN() {
        blockHeaderNumberGamers = Browser.getDriver().findElement(By.xpath(xpathBlockHeaderNumberGamers));
        blockHeaderNumberGamers.click();
        checkBoxCooperativeLAN = expectedConditions(xpathCheckBoxCooperativeLAN);
        checkBoxCooperativeLAN.click();
    }

    public boolean statusCheckBoxCooperativeLAN() {
        return checkBoxCooperativeLAN.isEnabled();
    }

    public void clickCheckBoxAction() {
        blockContentTags = expectedConditions(xpathBlockContentTags);
        blockHeaderTags = expectedConditions(xpathBlockHeaderTags);
        flagSeeAll = expectedConditions(xpathFlagSeeAll);
        if(!blockContentTags.isDisplayed())
            blockHeaderTags.click();
        checkBoxAction = expectedConditions(xpathCheckBoxAction);
        if(!checkBoxAction.isDisplayed())
            flagSeeAll.click();
        checkBoxAction.click();
    }

    public boolean statusCheckBoxAction() {
        return checkBoxAction.isEnabled();
    }

    public ArrayList<String> getInfoFirstGame() {
        infoFirstGameInList = new ArrayList<String>();
        infoFirstGameInList.add(0, getNameFirstGame());
        infoFirstGameInList.add(1, getDateOfReleaseFirstGame());
        infoFirstGameInList.add(2, getPriceFirstGame());
        return infoFirstGameInList;
    }

    public void clickFirstGame() {
        firstGameInList = Browser.getDriver().findElement(By.xpath(xpathFirstGameInList));
        firstGameInList.click();
    }

    public boolean getUniqueElementSalesLeadersPage() {
        additionalSearchOptions = Browser.getDriver().findElements(By.xpath(xpathAdditionalSearchOptions));
        return (additionalSearchOptions.size() > 0);
    }

    public String getNumberOfActionGames() {
        numberOfGamesAction = Browser.getDriver().findElement(By.xpath(xpathNumberOfGamesAction));
        return numberOfGamesAction.getText();
    }

    public String getNumberGamesOnRequest() {
        numberGamesOnRequest = Browser.getDriver().findElement(By.xpath(xpathNumberGamesOnRequest));
        return numberGamesOnRequest.getText().replaceAll("[^0-9]+","");
    }

    public String getNumberGamesInList() {
        gamesResultList = Browser.getDriver().findElements(By.xpath(xpathGamesResultList));
        return String.valueOf(gamesResultList.size());
    }

    private String getNameFirstGame() {
        nameFirstGameInList = Browser.getDriver().findElement(By.xpath(xpathNameFirstGameInList));
        return nameFirstGameInList.getText();
    }

    private String getDateOfReleaseFirstGame() {
        dateOfReleaseFirstGameInList = Browser.getDriver().findElement(By.xpath(xpathDateOfReleaseFirstGameInList));
        return dateOfReleaseFirstGameInList.getText();
    }

    private String getPriceFirstGame() {
        priceFirstGameInList= Browser.getDriver().findElement(By.xpath(xpathPriceFirstGameInList));
        return priceFirstGameInList.getText();
    }
}
