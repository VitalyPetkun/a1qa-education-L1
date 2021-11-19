package elements;

import framework.BaseElement;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator, String elementName) {
        super(locator, elementName);
    }

    public void inputText(String text) {
        findElement().sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }
}
