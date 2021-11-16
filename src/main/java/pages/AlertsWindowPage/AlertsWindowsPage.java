package pages.AlertsWindowPage;

import elements.Button;
import pages.BaseForm;

public class AlertsWindowsPage extends BaseForm {
    private Button btnAlerts;
    private Button btnNestedFrames;
    private Button btnFrames;
    private Button btnBrowserWindows;
    private AlertsForm alertsForm;
    private NestedFramesForm nestedFramesForm;
    private FramesForm framesForm;
    private BrowserWindowsForm browserWindowsForm;

    public AlertsWindowsPage() {
        super("//div[@class='left-pannel']", "AlertsWindows Page");
    }

    public void clickBtnAlerts() {
        btnAlerts = new Button("//div[contains(@class,'collapse show')]//li[@id='item-1']", "btnAlerts");
        btnAlerts.click();
    }

    public void clickBtnNestedFrames() {
        btnNestedFrames = new Button("//div[contains(@class,'collapse show')]//li[@id='item-3']", "btnNestedFrames");
        btnNestedFrames.click();
    }

    public void clickBtnFrames() {
        btnFrames = new Button("//div[contains(@class,'collapse show')]//li[@id='item-2']", "btnFrames");
        btnFrames.click();
    }

    public void clickBtnBrowserWindows() {
        btnBrowserWindows = new Button("//div[contains(@class,'collapse show')]//li[@id='item-0']", "btnBrowserWindows");
        btnBrowserWindows.click();
    }

    public AlertsForm getAlertsForm() {
        alertsForm = new AlertsForm();
        return alertsForm;
    }

    public NestedFramesForm getNestedFramesForm() {
        nestedFramesForm = new NestedFramesForm();
        return nestedFramesForm;
    }

    public FramesForm getFramesForm() {
        framesForm = new FramesForm();
        return framesForm;
    }

    public BrowserWindowsForm getBrowserWindowsForm() {
        browserWindowsForm = new BrowserWindowsForm();
        return browserWindowsForm;
    }
}
