package pages;

import browser.MethodsForSearch;
import org.openqa.selenium.WebElement;

public class ItemClass extends MethodsForSearch {
    private final String xpathName = "//h1[@id='largeiteminfo_item_name']";
    private final String xpathFilterRarity = "//div[@id='largeiteminfo_item_type']";
    private final String xpathFilterHero = "//div[@id='largeiteminfo_item_descriptors']/div[1]";


    private WebElement name;
    private WebElement filterRarity;
    private WebElement filterHero;


    public String getName() {
        name = findElement(xpathName);
        return (name.getText());
    }

    public boolean checkFilters() {
        boolean check = false;
        filterHero = findElement(xpathFilterHero);
        filterRarity = findElement(xpathFilterRarity);
        if((filterHero.getText().contains(ConfigProperties.getPropertyString("filtersSearchHero"))) &&
                filterRarity.getText().contains(ConfigProperties.getPropertyString("filtersSearchRarity")))
            check = true;
        return check;
    }
}
