package pages.alertswindowpage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;

public class BrowserWindowsForm extends BaseForm {
    private final String xpathBtnNewTab = "//button[@id='tabButton']";
    private final String xpathBtnLinks = "//div[contains(@class,'collapse show')]//li[@id='item-5']";
    private final String xpathWebTableElements = "//div[@class='left-pannel']//child::div[@class='element-group'][1]//div[@class='header-wrapper']";

    public BrowserWindowsForm() {
        super("//div[@id='browserWindows']", "BrowserWindowsForm");
    }

    public void clickBtnNewTab() {
        new Button(xpathBtnNewTab, "btnNewTab").click();
    }

    public void clickBtnLinks() {
        new Button(xpathBtnLinks, "btnLinks").click();
    }

    public void clickWebTableElements() {
        new WebTable(xpathWebTableElements, "webTableElements").click();
    }
}
