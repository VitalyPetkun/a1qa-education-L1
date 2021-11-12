package browser;

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
        org.openqa.selenium.Alert element = WaiterUtils.alertIsPresent();
        element.accept();
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
        } catch (Exception e) {
            foundAlert = false;
        }
        return foundAlert;
    }
}
