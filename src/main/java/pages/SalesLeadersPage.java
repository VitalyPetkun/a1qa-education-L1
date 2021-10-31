package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SalesLeadersPage {
    @FindBy(xpath = "//div[@class='block search_collapse_block'][@data-collapse-name='os']//div[@class='block_header']")
    private WebElement blockHeaderOS;

    @FindBy(xpath = "//div[contains(@class,'tab_filter_control_row')][contains(@data-param,'os')][contains(@data-value,'linux')]")
    private WebElement checkBoxSteamOSPlusLinux;

    @FindBy(xpath = "//div[@class='block search_collapse_block'][@data-collapse-name='category3']//div[@class='block_header']")
    private WebElement blockNumberOfGamers;

    @FindBy(xpath = "//div[@class='tab_filter_control_row '][@data-param='category3'][@data-value='48']")
    private WebElement checkBoxCooperativeLAN;

    @FindBy(xpath = "//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//div[contains(@class,'block_header')]")
    private WebElement blockTags;

    @FindBy(xpath = "//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//a[@class='see_all_expander']")
    private WebElement flagSeeAll;

    @FindBy(xpath = "//div[@id='TagFilter_Container']//div[@data-param='tags'][@data-value='19']")
    private WebElement checkBoxAction;

    @FindBy(xpath = "//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]")
    private WebElement firstGame;

    @FindBy(xpath = "//div[@id='TagFilter_Container']//div[@data-param='tags'][@data-value='19']//span[@class='tab_filter_control_count']")
    private WebElement numberOfGamesAction;

    @FindBy(xpath = "//div[@id='search_results']//div[@class='search_results_count']")
    private WebElement numberGamesOnRequest;

    public void clickCheckBoxSteamOSPlusLinux(WebDriver driver) {
        blockHeaderOS.click();
        WebElement checkBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'tab_filter_control_row')][contains(@data-param,'os')][contains(@data-value,'linux')]")));
        checkBoxSteamOSPlusLinux.click();
    }

    public boolean statusCheckBoxSteamOSPlusLinux() {
        boolean status = checkBoxSteamOSPlusLinux.isSelected();
        return status;
    }

    public void clickCheckBoxCooperativeLAN(WebDriver driver) {
        blockNumberOfGamers.click();
        WebElement checkBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='tab_filter_control_row '][@data-param='category3'][@data-value='48']")));
        checkBoxCooperativeLAN.click();
    }

    public boolean statusCheckBoxCooperativeLAN() {
        boolean status = checkBoxCooperativeLAN.isSelected();
        return status;
    }

    public void clickCheckBoxAction(WebDriver driver) {
        blockTags.click();
        WebElement flag = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'search_collapse_block')][@data-collapse-name='tags']//a[@class='see_all_expander']")));
        flagSeeAll.click();
        WebElement checkBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='TagFilter_Container']//div[@data-param='tags'][@data-value='19']")));
        checkBoxAction.click();
    }

    public boolean statusCheckBoxAction() {
        boolean status = checkBoxAction.isSelected();
        return status;
    }


    private String getNameFirstGame(WebDriver driver) {
        WebElement nameGame = driver.findElement(
                By.xpath("//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//span[@class='title']"));
        return nameGame.getText();
    }

    private String getDateOfReleaseFirstGame(WebDriver driver) {
        WebElement dateOfReleaseGame = driver.findElement(
                By.xpath("//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//div[contains(@class,'search_released')]"));
        return dateOfReleaseGame.getText();
    }

    private String getPriceFirstGame(WebDriver driver) {
        WebElement priceGame = driver.findElement(
                By.xpath("//div[@id='search_resultsRows']//a[contains(@class,'search_result_row')][1]//div[contains(@class,'search_price discounted')]//br"));
        return priceGame.getText();
    }

    public ArrayList<String> getInfoFirstGame(WebDriver driver) {
        ArrayList<String> info = new ArrayList<String>();
        info.add(0, getNameFirstGame(driver));
        info.add(1, getDateOfReleaseFirstGame(driver));
        info.add(2, getPriceFirstGame(driver));
        return info;
    }

    public void clickFirstGame() {
        firstGame.click();
    }

    public boolean getUniqueElementSalesLeadersPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='additional_search_options']")));
        List<WebElement> additionalSearchOptions = driver.findElements(By.xpath("//div[@id='additional_search_options']"));
        boolean elementIs = additionalSearchOptions.size() > 0;
        return elementIs;
    }

    public String getNumberOfActionGames(WebDriver driver) {
        return numberOfGamesAction.getText();
    }

    public String getNumberGamesOnRequest() {
        return numberGamesOnRequest.getText().replaceAll("[^0-9]+","");
    }

    public String getNumberGamesInList(WebDriver driver) {
        List<WebElement> gamesResultList = driver.findElements(By.xpath("//div[@id='search_resultsRows']"));
        return String.valueOf(gamesResultList.size());
    }
}
