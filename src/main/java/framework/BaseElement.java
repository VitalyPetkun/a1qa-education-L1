package framework;

import browser.Browser;
import browser.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.MyLogger;

import java.util.List;

public abstract class BaseElement{
    private String locator;
    private String elementName;

    protected BaseElement(String locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    protected WebElement findElement() {
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    protected List<WebElement> findElements(String xpath) {
        return Browser.getDriver().findElements(By.xpath(xpath));
    }

    public void click() {
        try {
            MyLogger.logInfo("click " + elementName + ".");
            WebElement element = WaiterUtils.elementToBeClickable(locator);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception ex) {
            MyLogger.logError("not click " + elementName + ".");
        }
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isPresentUniqElement() {
        return findElements(locator).size() > 0;
    }

    public int sizeList() {
        return findElements(locator).size();
    }

    public List<WebElement> listElements() {
        return findElements(locator);
    }

    protected String getElementName() {
        return elementName;
    }
}
