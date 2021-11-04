package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketPage extends MethodsForSearch {
    private final String xpathFindItems = "//div[@id='findItems']//div";

    public boolean getUniqueElementMarketPage() {
        List<WebElement> gutterBlock = findElements(xpathFindItems);
        return (gutterBlock.size() > 0);
    }
}
