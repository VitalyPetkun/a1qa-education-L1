package elements;

import java.util.concurrent.TimeoutException;

public class Alert extends BaseElement{
    public Alert(String elementName) {
        super(elementName);
    }

    public String getTextAlert() {
        org.openqa.selenium.Alert element = alertIsPresent();
        return element.getText();
    }

    public void acceptAlert() {
        org.openqa.selenium.Alert element = alertIsPresent();
        element.accept();
    }
    
    public void inputTextAlert(String text) {
        org.openqa.selenium.Alert element = alertIsPresent();
        element.sendKeys(text);
    }

    public boolean isAlertOpen() {
        boolean foundAlert = false;
        try {
            alertIsPresent();
            foundAlert = true;
        } catch (Exception e) {
            foundAlert = false;
        }
        return foundAlert;
    }
}
