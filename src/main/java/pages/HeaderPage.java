package pages;

import browser.MethodsForSearch;
import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderPage extends MethodsForSearch{
    private final String xpathBtnAbout = "//div[@class='supernav_container']/a[3]";
    private final String xpathSubmenuStore = "//div[@class='supernav_container']//a[contains(@data-tooltip-content,'submenu_store')]";
    private final String xpathSubmenuCommunity = "//div[@class='supernav_container']//a[contains(@data-tooltip-content,'submenu_community')]";
    private final String xpathPopupMenuHomePage = "//div[@class='supernav_content']//div[@class='submenu_store']//a[1]";
    private final String xpathPopupMenuMarketPage = "//div[@class='supernav_content']//div[@class='submenu_community']/a[4]";

    private WebElement btnAbout;
    private WebElement submenuStore;
    private WebElement submenuCommunity;
    private WebElement popupMenuHomePage;
    private WebElement popupMenuMarketPage;

    public void clickPopupMenuHomePage() {
        submenuStore = expectedConditions(xpathSubmenuStore);
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(submenuStore).build().perform();
        popupMenuHomePage = expectedConditions(xpathPopupMenuHomePage);
        popupMenuHomePage.click();
    }

    public void clickPopupMenuCommunityMarketPage() {
        submenuCommunity = expectedConditions(xpathSubmenuCommunity);
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(submenuCommunity).build().perform();
        popupMenuMarketPage = expectedConditions(xpathPopupMenuMarketPage);
        popupMenuMarketPage.click();
    }

    public void clickButtonAbout() {
        btnAbout = expectedConditions(xpathBtnAbout);
        btnAbout.click();
    }

    public void clickSubMenuStore() {
        submenuStore = expectedConditions(xpathSubmenuStore);
        submenuStore.click();
    }
}
