package elements;

import browser.Browser;
import browser.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract class BaseElement{
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
        WebElement element = WaiterUtils.elementToBeClickable(locator);
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getText() {
        WebElement element = findElement(locator);
        return element.getText();
    }

    public boolean isPresentUniqElement() {
        List<WebElement> list = findElements(locator);
        return list.size() > 0;
    }

    public void switchToFrame() {
        WebElement element = findElement(locator);
        Browser.getDriver().switchTo().frame(element);
    }
}
