package pages;

import browser.MethodsForSearch;
import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HomePage extends MethodsForSearch {
    private final String xpathNoteworthyTab = "//div[@id='noteworthy_tab']//a[@class='pulldown_desktop']";
    private final String xpathPopupMenuSalesLeaders = "//div[@id='noteworthy_flyout']//a[@class='popup_menu_item'][1]";
    private final String xpathGutterBlock = "//div[@class='home_page_gutter_block']";

    private WebElement noteworthyTab;
    private WebElement popupMenuSalesLeaders;
    private HeaderPage headerPage;

    public HomePage() {
        headerPage = new HeaderPage();
    }

    public void clickPopupMenuSalesLeaders() {
        noteworthyTab = expectedConditions(xpathNoteworthyTab);
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(noteworthyTab).build().perform();
        popupMenuSalesLeaders = expectedConditions(xpathPopupMenuSalesLeaders);
        popupMenuSalesLeaders.click();
    }

    public int getUniqueElementHomePage() {
        List<WebElement> gutterBlock= findElements(xpathGutterBlock);
        return gutterBlock.size();
    }

    public HeaderPage getHeaderPage() {
        return headerPage;
    }
}
