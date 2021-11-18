package elements;

import browser.Browser;
import framework.BaseElement;
import utils.MyLogger;

public class Iframe extends BaseElement {
    public Iframe(String locator, String elementName) {
        super(locator, elementName);
    }

    public void switchToFrame() {
        try {
            MyLogger.logInfo("switch to " + getElementName() + ".");
            Browser.getDriver().switchTo().frame(findElement());
        } catch (Exception ex) {
            MyLogger.logError("not switch to " + getElementName() + ".");
        }
    }
}
