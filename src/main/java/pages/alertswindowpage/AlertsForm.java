package pages.alertswindowpage;

import elements.Button;
import elements.TextBox;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;
import utils.AlertUtils;

public class AlertsForm extends BaseForm {
    private final By xpathBtnToSeeAlert = By.xpath("//button[@id='alertButton']");
    private final By xpathBtnConfirm = By.xpath("//button[@id='confirmButton']");
    private final By xpathBtnPromt = By.xpath("//button[@id='promtButton']");
    private final By xpathTxTBtnConfirm = By.xpath("//span[@id='confirmResult']");
    private final By xpathTxTBtnPromt = By.xpath("//span[@id='promptResult']");

    public AlertsForm() {
        super(new WebTable(By.xpath("//div[@id='javascriptAlertsWrapper']"),"uniqElementAlertForm"), "AlertsForm");
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
