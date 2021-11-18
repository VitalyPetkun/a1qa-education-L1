package elements;

import framework.BaseElement;
import org.openqa.selenium.Keys;
import utils.MyLogger;

public class Slider extends BaseElement {
    public Slider(String locator, String elementName) {
        super(locator, elementName);
    }

    public void setSliderValue(int currentValue, int setValue) {
        MyLogger.logInfo("setValue " + getElementName() + " - " + setValue + ".");
        if(currentValue < setValue)
            for(int i = currentValue; i < setValue; i++)
                findElement().sendKeys(Keys.ARROW_RIGHT);
        if(currentValue > setValue)
            for(int i = currentValue; i > setValue; i--)
                findElement().sendKeys(Keys.ARROW_LEFT);
    }
}
