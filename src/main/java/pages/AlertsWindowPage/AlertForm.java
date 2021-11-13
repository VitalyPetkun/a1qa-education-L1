package pages.AlertsWindowPage;

import browser.Alert;

public class AlertForm {
    private Alert alert;

    public AlertForm() {
        alert = new Alert("alert");
    }

    public void clickBtnOk() {
        alert.acceptAlert();
    }

    public String getTextAlert() {
        return alert.getTextAlert();
    }

    public void inputText(String text) {
        alert.inputTextAlert(text);
    }

    public boolean isAlertOpen() {
        return alert.isAlertOpen();
    }
}


