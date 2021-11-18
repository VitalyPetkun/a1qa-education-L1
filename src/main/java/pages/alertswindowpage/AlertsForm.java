package pages.alertswindowpage;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import utils.AlertUtils;

public class AlertsForm extends BaseForm {
    private final String xpathBtnToSeeAlert = "//button[@id='alertButton']";
    private final String xpathBtnConfirm = "//button[@id='confirmButton']";
    private final String xpathBtnPromt = "//button[@id='promtButton']";
    private final String xpathTxTBtnConfirm = "//span[@id='confirmResult']";
    private final String xpathTxTBtnPromt = "//span[@id='promptResult']";

    public AlertsForm() {
        super("//div[@id='javascriptAlertsWrapper']", "AlertsForm");
    }

    public void clickBtnToSeeAlert() {
        new Button(xpathBtnToSeeAlert, "btnToSeeAlert").click();
    }

    public void clickBtnConfirm() {
        new Button(xpathBtnConfirm, "btnConfirm").click();
    }

    public void clickBtnPromt() {
        new Button(xpathBtnPromt, "btnPromt").click();
    }

    public String getTextBtnConfirm() {
        return new TextBox(xpathTxTBtnConfirm, "textBoxBtnConfirm").getText();
    }

    public String getTextBtnPromt() {
        return new TextBox(xpathTxTBtnPromt, "textBoxBtnConfirm").getText().replace("You entered ", "");
    }

    public AlertUtils getAlertUtils() {
        return new AlertUtils();
    }
}
