package pages.WidgetsPage;

import elements.Slider;
import elements.TextBox;
import pages.BaseForm;

public class SliderForm extends BaseForm {
    private Slider slider;
    private TextBox txtValueSlider;

    public SliderForm() {
        super("//div[@id='sliderContainer']", "SliderForm");
    }

    public void setValueSlider(int value) {
        slider = new Slider("//div[@id='sliderContainer']//input[contains(@class,'slider')]", "slider");
        slider.setSliderValue(getValueSlider(), value);
    }

    public int getValueSlider() {
        txtValueSlider = new TextBox("//div[@id='sliderContainer']//input[@id='sliderValue']", "txtValueSlider");
        return Integer.valueOf(txtValueSlider.getTextAttribute("value"));
    }
}
