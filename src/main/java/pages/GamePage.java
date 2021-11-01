package pages;

import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class GamePage extends Base{
    private String xpathName = "//div[@id='appHubAppName']";
    private String xpathDateOfRelease = "//div[@class='release_date']//div[@class='date']";
    private String xpathPrice =
            "//div[@id='game_area_purchase_section_add_to_cart_68179']//div[@class='discount_prices']//div[@class='discount_original_price']";

    private WebElement name;
    private WebElement dateOfRelease;
    private WebElement price;
    private ArrayList<String> infoGame;

    public ArrayList<String> getInfoWithGamePage() {
        name = findElement(xpathName);
        dateOfRelease = findElement(xpathDateOfRelease);
        price = findElement(xpathPrice);
        infoGame = new ArrayList<String>();
        infoGame.add(0, name.getText());
        infoGame.add(1, dateOfRelease.getText());
        infoGame.add(2, price.getText());
        return infoGame;
    }
}
