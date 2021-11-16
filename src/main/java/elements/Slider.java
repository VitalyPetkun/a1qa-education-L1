package elements;

import org.openqa.selenium.Keys;
import utils.MyLogger;

public class Slider extends BaseElement{
    private String locator;
    private String elementName;

    public Slider(String locator, String elementName) {
        super(locator, elementName);
        this.locator = locator;
        this.elementName = elementName;
    }

    public void setSliderValue(int currentValue, int setValue) {
        if(currentValue < setValue)
            for(int i = currentValue; i < setValue; i++)
                findElement(locator).sendKeys(Keys.ARROW_RIGHT);
        if(currentValue > setValue)
            for(int i = currentValue; i > setValue; i--)
                findElement(locator).sendKeys(Keys.ARROW_LEFT);
        MyLogger.logInfo("setValue " + elementName + " - " + setValue + ".");
    }
}
