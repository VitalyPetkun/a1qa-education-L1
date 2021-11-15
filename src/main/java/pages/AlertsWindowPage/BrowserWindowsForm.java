package pages.AlertsWindowPage;

import elements.Button;
import elements.WebTable;
import pages.BaseForm;

public class BrowserWindowsForm extends BaseForm {
    private Button btnNewTab;
    private Button btnLinks;
    private WebTable webTableElements;

    public BrowserWindowsForm() {
        super("//div[@id='browserWindows']", "BrowserWindowsForm");
    }

    public void clickBtnNewTab() {
        btnNewTab = new Button("//button[@id='tabButton']", "btnNewTab");
        btnNewTab.click();
    }

    public void clickBtnLinks() {
        btnLinks = new Button("//div[contains(@class,'collapse show')]//li[@id='item-5']", "btnLinks");
        btnLinks.click();
    }

    public void clickWebTableElements() {
        webTableElements = new WebTable("//div[@class='left-pannel']//child::div[@class='element-group'][1]//div[@class='header-wrapper']",
                "webTableElements");
        webTableElements.click();
    }
}
