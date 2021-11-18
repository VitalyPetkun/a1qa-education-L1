package pages.alertswindowpage;

import elements.Button;
import framework.BaseForm;

public class AlertsWindowsPage extends BaseForm {
    private final String xpathBtnAlerts = "//div[contains(@class,'collapse show')]//li[@id='item-1']";
    private final String xpathBtnNestedFrames = "//div[contains(@class,'collapse show')]//li[@id='item-3']";
    private final String xpathBtnFrames = "//div[contains(@class,'collapse show')]//li[@id='item-2']";
    private final String xpathBtnBrowserWindows = "//div[contains(@class,'collapse show')]//li[@id='item-0']";

    public AlertsWindowsPage() {
        super("//div[@class='left-pannel']", "AlertsWindows Page");
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
