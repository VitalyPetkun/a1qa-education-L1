package pages;

import Utils.ConfigManager;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MethodsForSearch {
    public WebElement expectedConditions(String xpath) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getPropertyInt("waitingTime")))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public boolean invisibilityOfElementWithText(String xpath, String originalText) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getPropertyInt("waitingTime")))
                .until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), originalText));
    }



    public int webElementInInt(WebElement element) {
        return Integer.valueOf(element.getText().replaceAll("[^0-9]+", ""));
    }
}
