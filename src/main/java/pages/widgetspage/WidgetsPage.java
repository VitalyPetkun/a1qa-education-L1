package pages.widgetspage;

import elements.Button;
import framework.BaseForm;

public class WidgetsPage extends BaseForm {
    private final String xpathBtnSlider = "//div[contains(@class,'collapse show')]//li[@id='item-3']";
    private final String xpathBtnProgressBar = "//div[contains(@class,'collapse show')]//li[@id='item-4']";

    public WidgetsPage() {
        super("//div[@class='left-pannel']", "WidgetsPage");
    }

    public void clickBtnSlider() {
        new Button(xpathBtnSlider, "btnSlider").click();
    }

    public void clickBtnProgressBar() {
        new Button(xpathBtnProgressBar, "btnProgressBar").click();
    }

    public SliderForm getSliderForm() {
        return new SliderForm();
    }

    public ProgressBarForm getProgressBarForm() {
        return new ProgressBarForm();
    }
}
