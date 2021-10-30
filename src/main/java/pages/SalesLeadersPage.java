package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesLeadersPage {
    @FindBy(xpath = "//span[@class='tab_filter_control tab_filter_control_include '][@data-loc='SteamOS + Linux']//span[@class='tab_filter_control_checkbox']")
    private WebElement checkBoxSteamOSPlusLinux;


}
