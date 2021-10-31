package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class Base {
    public WebElement expectedConditions(String xpath) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigProperties.getPropertyInt("waitingTime")))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
