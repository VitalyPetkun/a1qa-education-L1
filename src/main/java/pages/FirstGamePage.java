package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.ArrayList;

public class FirstGamePage {
    @FindBy(xpath = "//div[@id='appHubAppName']")
    private WebElement name;

    @FindBy(xpath = "//div[@class='release_date']//div[@class='date']")
    private WebElement dateOfRelease;

    @FindBy(xpath = "//div[@id='game_area_purchase_section_add_to_cart_68179']//div[@class='discount_prices']//div[@class='discount_final_price'][1]")
    private WebElement price;

    public ArrayList<String> getInfoWithFirstGamePage() {
        ArrayList<String> info = new ArrayList<String>();
        info.add(0, name.getText());
        info.add(1, dateOfRelease.getText());
        info.add(2, price.getText());
        return info;
    }
}
