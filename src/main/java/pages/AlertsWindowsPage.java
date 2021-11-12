package pages;

import elements.Button;

public class AlertsWindowsPage extends BaseForm{
    private Button btnAlerts;
    private Button btnNestedFrames;

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

    public HeaderMenu getHeaderMenu() {
        return new HeaderMenu();
    }
}
