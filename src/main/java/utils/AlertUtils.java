package utils;

import browser.MyAlert;

public class AlertUtils {
    public void clickBtnOk() {
        MyAlert.acceptAlert();
    }

    public String getTextAlert() {
        return MyAlert.getTextAlert();
    }

    public void inputText(String text) {
        MyAlert.inputTextAlert(text);
    }

    public boolean isAlertOpen() {
        return MyAlert.isAlertOpen();
    }
}


