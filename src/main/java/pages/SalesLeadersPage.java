package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SalesLeadersPage {
    @FindBy(xpath = "//div[@class='block search_collapse_block'][@data-collapse-name='os']//div[@class='block_header']")
    private WebElement blockHeaderOS;

    @FindBy(xpath = "//div[contains(@class,'tab_filter_control_row')][contains(@data-param,'os')][contains(@data-value,'linux')]")
    private WebElement checkBoxSteamOSPlusLinux;

    public void clickCheckBoxSteamOSPlusLinux(WebDriver driver) {
        blockHeaderOS.click();
        WebElement checkBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'tab_filter_control_row')][contains(@data-param,'os')][contains(@data-value,'linux')]")));
        checkBoxSteamOSPlusLinux.click();
    }

    public boolean checkBoxStatus() {
        boolean status = checkBoxSteamOSPlusLinux.isSelected();
        return status;
    }

    public boolean getUniqueElementSalesLeadersPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='additional_search_options']")));
        List<WebElement> additionalSearchOptions = driver.findElements(By.xpath("//div[@id='additional_search_options']"));
        boolean elementIs = additionalSearchOptions.size() > 0;
        return elementIs;
    }
}
