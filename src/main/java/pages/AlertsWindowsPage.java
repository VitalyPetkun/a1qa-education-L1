package pages;

import elements.Button;

public class AlertsWindowsPage extends BaseForm{
    private Button btnAlerts;
    private Button btnNestedFrames;
    private Button btnFrames;

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
        return new AlertsForm();
    }

    public NestedFramesForm getNestedFramesForm() {
        return new NestedFramesForm();
    }

    public FramesForm getFramesForm() {
        return new FramesForm();
    }

}
