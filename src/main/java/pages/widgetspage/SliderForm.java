package pages.widgetspage;

import elements.Slider;
import elements.TextBox;
import framework.BaseForm;

public class SliderForm extends BaseForm {
    private final String xpathSlider = "//div[@id='sliderContainer']//input[contains(@class,'slider')]";
    private final String xpathTxtValueSlider = "//div[@id='sliderContainer']//input[@id='sliderValue']";

    public SliderForm() {
        super("//div[@id='sliderContainer']", "SliderForm");
    }

    public void setValueSlider(int value) {
        new Slider(xpathSlider, "slider").setSliderValue(getValueSlider(), value);
    }

    public int getValueSlider() {
        return Integer.valueOf(new TextBox(xpathTxtValueSlider, "txtValueSlider").getTextAttribute("value"));
    }
}
