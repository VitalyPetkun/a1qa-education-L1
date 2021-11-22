package pages.alertswindowpage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
    private final By xpathBtnAlerts = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-1']");
    private final By xpathBtnNestedFrames = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");
    private final By xpathBtnFrames = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-2']");
    private final By xpathBtnBrowserWindows = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-0']");

    public AlertsWindowsPage() {
        super(new WebTable(By.xpath("//div[@class='left-pannel']"),"uniqElementAlertsWindowsPage"), "AlertsWindows Page");
    }

    public void clickBtnAlerts() {
        new Button(xpathBtnAlerts, "btnAlerts").click();
    }

    public void clickBtnNestedFrames() {
        new Button(xpathBtnNestedFrames, "btnNestedFrames").click();
    }

    public void clickBtnFrames() {
        new Button(xpathBtnFrames, "btnFrames").click();
    }

    public void clickBtnBrowserWindows() {
        new Button(xpathBtnBrowserWindows, "btnBrowserWindows").click();
    }

    public AlertsForm getAlertsForm() {
        return new AlertsForm();
    }

    public NestedFramesForm getNestedFramesForm() {
        return new NestedFramesForm();
    }

    public FramesForm getFramesForm() {
        return new FramesForm();
    }

    public BrowserWindowsForm getBrowserWindowsForm() {
        return new BrowserWindowsForm();
    }
}
