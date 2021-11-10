package pages;

import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HomePage extends BaseForm{
    private HeaderMenu headerMenu;

    public HomePage() {
        headerMenu = new HeaderMenu();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
