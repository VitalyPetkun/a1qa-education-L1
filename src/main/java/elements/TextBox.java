package elements;

import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement{
    private String locator;
    private String elementName;

    public TextBox(String locator, String elementName) {
        super(locator, elementName);
        this.locator = locator;
        this.elementName = elementName;
    }

    public void inputText(String text) {
        findElement(locator).sendKeys(text);
    }
}
