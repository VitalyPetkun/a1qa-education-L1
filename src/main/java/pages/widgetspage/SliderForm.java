package pages.widgetspage;

import elements.Slider;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class SliderForm extends BaseForm {
    private final By xpathSlider = By.xpath("//div[@id='sliderContainer']//input[contains(@class,'slider')]");
    private final By xpathTxtValueSlider = By.xpath("//div[@id='sliderContainer']//input[@id='sliderValue']");

    public SliderForm() {
        super(By.xpath("//div[@id='sliderContainer']"), "SliderForm");
    }

    public void setValueSlider(int value) {
        new Slider(xpathSlider, "slider").setSliderValue(getValueSlider(), value);
    }

    public int getValueSlider() {
        return Integer.valueOf(new TextBox(xpathTxtValueSlider, "txtValueSlider").getTextAttribute("value"));
    }
}
