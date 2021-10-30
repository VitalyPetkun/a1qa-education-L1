package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//div[@id='foryou_tab']")
    private WebElement menuYourStore;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem'][1]")
    private WebElement buttonAbout;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem supernav'][@data-tooltip-content='.submenu_store']")
    private WebElement subMenuStore;

    @FindBy(xpath = "//div[@id='noteworthy_tab']//a[@class='pulldown_desktop']")
    private WebElement noteworthyTab;

    @FindBy(xpath = "//div[@id='noteworthy_flyout']//a[@class='popup_menu_item'][1]")
    private WebElement popupMenuSalesLeaders;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(ConfProperties.getPropertyString("URLHomePage"));
    }

    public void clickMenuYourStore() {
        menuYourStore.click();
    }

    public void clickButtonAbout() {
        buttonAbout.click();
    }

    public void clickSubMenuStore() {
        subMenuStore.click();
    }

    public boolean getUniqueElementHomePage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home_page_gutter_block']")));
        List<WebElement> gutterBlock= driver.findElements(By.xpath("//div[@class='home_page_gutter_block']"));
        boolean elementIs = gutterBlock.size() > 0;
        return elementIs;
    }
}
