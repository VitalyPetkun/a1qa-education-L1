package elements;

public class TextBox extends BaseElement{
    private String locator;

    public TextBox(String locator, String elementName) {
        super(locator, elementName);
        this.locator = locator;
    }

    public void inputText(String text) {
        findElement(locator).sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return findElement(locator).getAttribute(attribute);
    }
}
