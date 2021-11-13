package browser;

import utils.MyLogger;

public class Alert {
    private String elementName;

    public Alert(String elementName) {
        this.elementName = elementName;
    }

    public String getTextAlert() {
        org.openqa.selenium.Alert element = WaiterUtils.alertIsPresent();
        return element.getText();
    }

    public void acceptAlert() {
        try {
            org.openqa.selenium.Alert element = WaiterUtils.alertIsPresent();
            element.accept();
            MyLogger.logInfo("close alert.");
        } catch (Exception ex) {
            MyLogger.logError("not close alert.");
        }
    }
    
    public void inputTextAlert(String text) {
        org.openqa.selenium.Alert element = WaiterUtils.alertIsPresent();
        element.sendKeys(text);
    }

    public boolean isAlertOpen() {
        boolean foundAlert = false;
        try {
            WaiterUtils.alertIsPresent();
            foundAlert = true;
            MyLogger.logInfo("open alert.");
        } catch (Exception e) {
            foundAlert = false;
            MyLogger.logWarn("not open alert.");
        }
        return foundAlert;
    }
}
