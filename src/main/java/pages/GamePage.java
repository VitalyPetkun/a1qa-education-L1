package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GamePage extends MethodsForSearch {
    private final String xpathName = "//div[@id='appHubAppName']";
    private final String xpathDateOfRelease = "//div[@class='release_date']//div[@class='date']";
    private final String xpathPrice =
            "//div[contains(@class,'game_purchase_price')]";
    private final String xpathHighlights = "//div[@id='game_highlights']";

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
        infoGame.add(2, String.valueOf(webElementInInt(price)));
        return infoGame;
    }

    public boolean getUniqueElementGamePage() {
        List<WebElement> highlights = findElements(xpathHighlights);
        return (highlights.size() > 0);
    }
}
