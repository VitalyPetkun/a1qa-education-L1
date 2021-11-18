package elements;

import framework.BaseElement;

public class TextBox extends BaseElement {
    public TextBox(String locator, String elementName) {
        super(locator, elementName);
    }

    public void inputText(String text) {
        findElement().sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }
}
