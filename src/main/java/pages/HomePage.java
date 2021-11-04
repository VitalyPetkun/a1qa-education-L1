package pages;

import browser.MethodsForSearch;
import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HomePage extends MethodsForSearch {
    final private String xpathMenuYourStore = "//div[@id='foryou_tab']//span[@class='pulldown']";
    final private String xpathPopupMenuHomePage = "//div[@id='foryou_flyout']//a[@class='popup_menu_item']";
    final private String xpathBtnAbout = "//div[@class='supernav_container']//a[@class='menuitem'][1]";
    final private String xpathSubMenuStore =
            "//div[@class='supernav_container']//a[@class='menuitem supernav'][@data-tooltip-content='.submenu_store']";
    final private String xpathNoteworthyTab = "//div[@id='noteworthy_tab']//a[@class='pulldown_desktop']";
    final private String xpathPopupMenuSalesLeaders = "//div[@id='noteworthy_flyout']//a[@class='popup_menu_item'][1]";
    final private String xpathGutterBlock = "//div[@class='home_page_gutter_block']";

    private WebElement menuYourStore;
    private WebElement popupMenuHomePage;
    private WebElement btnAbout;
    private WebElement subMenuStore;
    private WebElement noteworthyTab;
    private WebElement popupMenuSalesLeaders;

    public void clickPopupMenuHomePage() {
        menuYourStore = expectedConditions(xpathMenuYourStore);
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(menuYourStore).build().perform();
        popupMenuHomePage = expectedConditions(xpathPopupMenuHomePage);
        popupMenuHomePage.click();
    }

    public void clickButtonAbout() {
        btnAbout = expectedConditions(xpathBtnAbout);
        btnAbout.click();
    }

    public void clickSubMenuStore() {
        subMenuStore = expectedConditions(xpathSubMenuStore);
        subMenuStore.click();
    }

    public void clickPopupMenuSalesLeaders() {
        noteworthyTab = expectedConditions(xpathNoteworthyTab);
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(noteworthyTab).build().perform();
        popupMenuSalesLeaders = expectedConditions(xpathPopupMenuSalesLeaders);
        popupMenuSalesLeaders.click();
    }

    public boolean getUniqueElementHomePage() {
        List<WebElement> gutterBlock= findElements(xpathGutterBlock);
        return (gutterBlock.size() > 0);
    }
}
