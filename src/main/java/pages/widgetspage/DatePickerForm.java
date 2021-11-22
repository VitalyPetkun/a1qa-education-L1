package pages.widgetspage;

import elements.*;
import framework.BaseForm;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public class DatePickerForm extends BaseForm {
    private final By xpathTextBoxSelectDate = By.xpath("//input[@id='datePickerMonthYearInput']");
    private final By xpathTextBoxDateAndTime = By.xpath("//input[@id='dateAndTimePickerInput']");
    private final By xpathPopMenuMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By xpathPopMenuYear = By.xpath("//select[@class='react-datepicker__year-select']");

    public DatePickerForm() {
        super(new WebTable(By.xpath("//div[@id='datePickerContainer']"),"uniqElementDatePickerForm"),"Date Picker Form");
    }

    public String getTxtSelectDate() {
        return new TextBox(xpathTextBoxSelectDate, "TextBoxSelectDate").getTextAttribute("value");
    }

    public String getTxtDateAndTime() {
        return new TextBox(xpathTextBoxDateAndTime, "TextBoxDateAndTime").getTextAttribute("value");
    }

    public void clickSelectDate() {
        new DatePicker(xpathTextBoxSelectDate, "DatePickerSelectDate").click();
    }

    public void clickPopMenuMonth() {
        new PopMenu(xpathPopMenuMonth,"PopMenuMonth").click();
    }

    public void clickPopMenuYear() {
        new PopMenu(xpathPopMenuYear,"PopMenuYear").click();
    }

    public void setMonthInDatePicker(String month) {
        MyLogger.logInfo("set month in date picker - " + month + ".");
        new PopMenuItem(By.xpath("//option[text()='" + month + "']"), "PopMenuMonth " + month).click();
    }

    public void setYearInDatePicker(String year) {
        MyLogger.logInfo("set year in date picker - " + year + ".");
        new PopMenuItem(By.xpath("//option[text()='" + year + "']"),
                "PopMenuYear " + year).click();
    }

    public void setDayInDatePicker(String month, String day) {
        MyLogger.logInfo("set day in date picker - " + day + ".");
        new DatePicker(By.xpath("//div[contains(@class,'react-datepicker__day') and contains(@aria-label,'" + month + " " + day + "')]"),
                "DatePickerDate " + month + day).click();
    }
}
