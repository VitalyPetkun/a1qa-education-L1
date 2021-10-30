package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SalesLeadersPage {
    @FindBy(xpath = "//span[@class='tab_filter_control tab_filter_control_include '][@data-loc='SteamOS + Linux']//span[@class='tab_filter_control_checkbox']")
    private WebElement checkBoxSteamOSPlusLinux;

    public boolean getUniqueElementSalesLeadersPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='additional_search_options']")));
        List<WebElement> additionalSearchOptions = driver.findElements(By.xpath("//div[@id='additional_search_options']"));
        boolean elementIs = additionalSearchOptions.size() > 0;
        return elementIs;
    }
}
