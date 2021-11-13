package elements;

import browser.Browser;
import utils.MyLogger;

public class Iframe extends BaseElement{
    private String locator;
    private String elementName;

    public Iframe(String locator, String elementName) {
        super(locator, elementName);
        this.locator = locator;
        this.elementName = elementName;
    }

    public void switchToFrame() {
        try {
            Browser.getDriver().switchTo().frame(findElement(locator));
            MyLogger.logInfo("switch to " + elementName + ".");
        } catch (Exception ex) {
            MyLogger.logError("not switch to " + elementName + ".");
        }
    }
}
