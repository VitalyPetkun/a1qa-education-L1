package pages.widgetspage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import org.openqa.selenium.By;

public class WidgetsPage extends BaseForm {
    private final By xpathBtnSlider = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");
    private final By xpathBtnProgressBar = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-4']");
    private final By xpathBtnDatePicker = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-2']");


    public WidgetsPage() {
        super(new WebTable(By.xpath("//div[@class='left-pannel']"),"uniqElementWidgetsPage"), "WidgetsPage");
    }

    public void clickBtnSlider() {
        new Button(xpathBtnSlider, "btnSlider").click();
    }

    public void clickBtnProgressBar() {
        new Button(xpathBtnProgressBar, "btnProgressBar").click();
    }

    public void clickBtnDatePicker() {
        new Button(xpathBtnDatePicker, "btnDatePicker").click();
    }

    public SliderForm getSliderForm() {
        return new SliderForm();
    }

    public ProgressBarForm getProgressBarForm() {
        return new ProgressBarForm();
    }

    public DatePickerForm getDatePickerForm() {
        return new DatePickerForm();
    }
}
