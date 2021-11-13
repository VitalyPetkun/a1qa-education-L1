package pages.AlertsWindowPage;

import elements.Button;
import elements.TextBox;
import pages.BaseForm;

public class AlertsForm extends BaseForm {
    private Button btnToSeeAlert;
    private Button btnConfirm;
    private TextBox txtBtnConfirm;
    private Button btnPromt;
    private TextBox txtBtnPromt;
    private AlertForm alertForm;


    public AlertsForm() {
        super("//div[@id='javascriptAlertsWrapper']", "AlertsForm");
    }

    public void clickBtnToSeeAlert() {
        btnToSeeAlert = new Button("//button[@id='alertButton']", "btnToSeeAlert");
        btnToSeeAlert.click();
    }

    public void clickBtnConfirm() {
        btnConfirm = new Button("//button[@id='confirmButton']", "btnConfirm");
        btnConfirm.click();
    }

    public String getTextBtnConfirm() {
        txtBtnConfirm = new TextBox("//span[@id='confirmResult']", "TextBoxBtnConfirm");
        return txtBtnConfirm.getText();
    }

    public String getTextBtnPromt() {
        txtBtnPromt = new TextBox("//span[@id='promptResult']", "TextBoxBtnConfirm");
        return txtBtnPromt.getText().replace("You entered ", "");
    }

    public void clickBtnPromt() {
        btnPromt = new Button("//button[@id='promtButton']", "btnPromt");
        btnPromt.click();
    }

    public AlertForm getAlertForm() {
        alertForm = new AlertForm();
        return alertForm;
    }
}
