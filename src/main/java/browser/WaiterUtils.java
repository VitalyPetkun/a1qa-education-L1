package browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigManager;

import java.time.Duration;

public class WaiterUtils {
    public static WebElement elementToBeClickable(String xpath) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static Alert alertIsPresent() {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfigInt("waitingTime")))
                .until(ExpectedConditions.alertIsPresent());
    }
}
