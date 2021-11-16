package pages.WidgetsPage;

import elements.Button;
import elements.TextBox;
import pages.BaseForm;

public class ProgressBarForm extends BaseForm {
    private Button btnStart;
    private Button btnStop;
    private TextBox txtCurrentValue;

    public ProgressBarForm() {
        super("//div[@id='progressBarContainer']", "ProgressBarForm");
    }

    public void clickBtnStart() {
        btnStart = new Button("//button[@id='startStopButton']", "btnStart");
        btnStart.click();
    }

    public void clickBtnStop() {
        btnStop = new Button("//button[@id='startStopButton']", "btnStop");
        btnStop.click();
    }

    public int getCurrentValue() {
        txtCurrentValue = new TextBox("//div[@id='progressBar']/div", "txtCurrentValue");
        return Integer.valueOf(txtCurrentValue.getTextAttribute("aria-valuenow"));
    }
}
