package elements;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import java.util.List;

abstract class BaseElement extends WaiterUtils{
    private String locator;
    private String elementName;

    BaseElement(String locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    BaseElement(String elementName) {
        this.elementName = elementName;
    }

    protected WebElement findElement(String xpath) {
        return Browser.getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElements(String xpath) {
        return Browser.getDriver().findElements(By.xpath(xpath));
    }

    public boolean isDisplayed() {
        return findElement(locator).isDisplayed();
    }

    public void click() {
        WebElement element = elementToBeClickable(locator);
        element.click();
    }

    public String getText() {
        WebElement element = findElement(locator);
        return element.getText();
    }

}
