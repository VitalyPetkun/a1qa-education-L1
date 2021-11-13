package elements;

import browser.Browser;
import browser.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.MyLogger;

import java.util.List;

abstract class BaseElement{
    private String locator;
    private String elementName;

    BaseElement(String locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    protected WebElement findElement(String xpath) {
        return Browser.getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElements(String xpath) {
        return Browser.getDriver().findElements(By.xpath(xpath));
    }

    public void click() {
        try {
            WebElement element = WaiterUtils.elementToBeClickable(locator);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            MyLogger.logInfo("click " + elementName + ".");
        } catch (Exception ex) {
            MyLogger.logError("not click " + elementName + ".");
        }
    }

    public String getText() {
        return findElement(locator).getText();
    }

    public boolean isPresentUniqElement() {
        return findElements(locator).size() > 0;
    }


}
