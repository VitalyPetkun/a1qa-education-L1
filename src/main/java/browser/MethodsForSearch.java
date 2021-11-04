package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ConfigProperties;

import java.time.Duration;
import java.util.List;

public class MethodsForSearch {
    public WebElement expectedConditions(String xpath) {
        return new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(ConfigProperties.getPropertyInt("waitingTime")))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public WebElement findElement(String xpath) {
        return BrowserFactory.getDriver().findElement(By.xpath(xpath));
    }

    public List<WebElement> findElements(String xpath) {
        return BrowserFactory.getDriver().findElements(By.xpath(xpath));
    }
}
