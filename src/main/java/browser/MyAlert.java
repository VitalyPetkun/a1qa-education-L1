package browser;

import framework.browser.WaiterUtils;
import org.openqa.selenium.Alert;
import framework.utils.MyLogger;

public class MyAlert {
    public static String getTextAlert() {
        Alert element = WaiterUtils.isAlertPresent();
        return element.getText();
    }

    public static void acceptAlert() {
        try {
            MyLogger.logInfo("close alert.");
            Alert element = WaiterUtils.isAlertPresent();
            element.accept();
        } catch (Exception ex) {
            MyLogger.logError("not close alert.");
        }
    }
    
    public static void inputTextAlert(String text) {
        Alert element = WaiterUtils.isAlertPresent();
        element.sendKeys(text);
    }

    public static boolean isAlertOpen() {
        boolean foundAlert = false;
        try {
            MyLogger.logInfo("open alert.");
            WaiterUtils.isAlertPresent();
            foundAlert = true;
        } catch (Exception e) {
            foundAlert = false;
            MyLogger.logWarn("not open alert.");
        }
        return foundAlert;
    }
}
