package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;

public class ItemClass extends MethodsForSearch {
    private final String xpathName = "//h1[@id='largeiteminfo_item_name']";
    private final String xpathFilterRarity = "//div[@id='largeiteminfo_item_type']";
    private final String xpathFilterHero = "//div[@id='largeiteminfo_item_descriptors']/div[1]";

    private WebElement nameItem;
    private WebElement filterRarity;
    private WebElement filterHero;

    public String getNameItem() {
        nameItem = findElement(xpathName);
        return (nameItem.getText());
    }

    public String checkFilters(String filter) {
        switch (filter) {
            case "filtersSearchHero":
                filterHero = findElement(xpathFilterHero);
                return filterHero.getText();
            case "filtersSearchRarity":
                filterRarity = findElement(xpathFilterRarity);
                return filterRarity.getText();
        }
        return filter;
    }
}
