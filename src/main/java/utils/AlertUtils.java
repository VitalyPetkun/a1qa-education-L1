package utils;

import browser.MyAlert;
import framework.utils.MyLogger;

public class AlertUtils {
    public void clickBtnOk() {
        MyLogger.logInfo("click btnOk in Alert.");
        MyAlert.acceptAlert();
    }

    public String getTextAlert() {
        return MyAlert.getTextAlert();
    }

    public void inputText(String text) {
        MyLogger.logInfo("input text in Alert.");
        MyAlert.inputTextAlert(text);
    }

    public boolean isAlertOpen() {
        return MyAlert.isAlertOpen();
    }
}


