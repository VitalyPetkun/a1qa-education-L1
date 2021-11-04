package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GamePage extends MethodsForSearch {
    final private String xpathName = "//div[@id='appHubAppName']";
    final private String xpathDateOfRelease = "//div[@class='release_date']//div[@class='date']";
    final private String xpathPrice =
            "//div[@id='game_area_purchase_section_add_to_cart_68179']//div[@class='discount_prices']//div[@class='discount_original_price']";
    final private String xpathHighlights = "//div[@id='game_highlights']";

    private WebElement name;
    private WebElement dateOfRelease;
    private WebElement price;

    public List<String> getInfoWithGamePage() {
        name = findElement(xpathName);
        dateOfRelease = findElement(xpathDateOfRelease);
        price = findElement(xpathPrice);
        List<String> infoGame = new ArrayList<String>();
        infoGame.add(0, name.getText());
        infoGame.add(1, dateOfRelease.getText());
        infoGame.add(2, price.getText());
        return infoGame;
    }

    public boolean getUniqueElementGamePage() {
        List<WebElement> highlights = findElements(xpathHighlights);
        return (highlights.size() > 0);
    }
}
