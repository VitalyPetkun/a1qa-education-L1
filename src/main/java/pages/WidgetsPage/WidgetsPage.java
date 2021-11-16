package pages.WidgetsPage;

import elements.Button;
import pages.BaseForm;

public class WidgetsPage extends BaseForm {
    private Button btnSlider;
    private Button btnProgressBar;
    private SliderForm sliderForm;
    private ProgressBarForm progressBarForm;

    public WidgetsPage() {
        super("//div[@class='left-pannel']", "WidgetsPage");
    }

    public void clickBtnSlider() {
        btnSlider = new Button("//div[contains(@class,'collapse show')]//li[@id='item-3']", "btnSlider");
        btnSlider.click();
    }

    public void clickBtnProgressBar() {
        btnProgressBar = new Button("//div[contains(@class,'collapse show')]//li[@id='item-4']", "btnProgressBar");
        btnProgressBar.click();
    }

    public SliderForm getSliderForm() {
        sliderForm = new SliderForm();
        return sliderForm;
    }

    public ProgressBarForm getProgressBarForm() {
        progressBarForm = new ProgressBarForm();
        return progressBarForm;
    }
}
