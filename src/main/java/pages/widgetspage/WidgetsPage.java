package pages.widgetspage;

import elements.Button;
import framework.BaseForm;
import org.openqa.selenium.By;

public class WidgetsPage extends BaseForm {
    private final By xpathBtnSlider = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");
    private final By xpathBtnProgressBar = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-4']");

    public WidgetsPage() {
        super(By.xpath("//div[@class='left-pannel']"), "WidgetsPage");
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
