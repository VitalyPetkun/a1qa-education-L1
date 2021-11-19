package pages.alertswindowpage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {
    private final By xpathBtnNewTab = By.xpath("//button[@id='tabButton']");
    private final By xpathBtnLinks = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-5']");
    private final By xpathWebTableElements = By.xpath("//div[@class='element-group']//div[@class='header-text' and text()='Elements']");

    public BrowserWindowsForm() {
        super(By.xpath("//div[@id='browserWindows']"), "BrowserWindowsForm");
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
