package pages.AlertsWindowPage;

import elements.Button;
import pages.BaseForm;

public class AlertsWindowsPage extends BaseForm {
    private Button btnAlerts;
    private Button btnNestedFrames;
    private Button btnFrames;
    private AlertsForm alertsForm;
    private NestedFramesForm nestedFramesForm;
    private FramesForm framesForm;

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

}
