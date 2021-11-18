package pages.widgetspage;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;

public class ProgressBarForm extends BaseForm {
    private final String xpathBtnStart = "//button[@id='startStopButton']";
    private final String xpathBtnStop = "//button[@id='startStopButton']";
    private final String xpathTxtCurrentValue = "//div[@id='progressBar']/div";

    public ProgressBarForm() {
        super("//div[@id='progressBarContainer']", "ProgressBarForm");
    }

    public void clickBtnStart() {
        new Button(xpathBtnStart, "btnStart").click();
    }

    public void clickBtnStop() {
        new Button(xpathBtnStop, "btnStop").click();
    }

    public int getCurrentValue() {
        return Integer.valueOf(new TextBox(xpathTxtCurrentValue, "txtCurrentValue").getTextAttribute("aria-valuenow"));
    }
}
