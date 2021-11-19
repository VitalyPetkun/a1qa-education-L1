package pages.widgetspage;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ProgressBarForm extends BaseForm {
    private final By xpathBtnStart = By.xpath("//button[@id='startStopButton']");
    private final By xpathBtnStop = By.xpath("//button[@id='startStopButton']");
    private final By xpathTxtCurrentValue = By.xpath("//div[@id='progressBar']/div");

    public ProgressBarForm() {
        super(By.xpath("//div[@id='progressBarContainer']"), "ProgressBarForm");
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
