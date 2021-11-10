package elements;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract class BaseElement {

    protected WebElement findElement(String xpath) {
        return Browser.getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElements(String xpath) {
        return Browser.getDriver().findElements(By.xpath(xpath));
    }
}
