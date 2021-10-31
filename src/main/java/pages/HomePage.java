package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public void clickPopupMenuHomePage() {
        WebElement menuYourStore = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='foryou_tab']//span[@class='pulldown']")));
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(menuYourStore).build().perform();
        WebElement popupMenuHomePage = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='foryou_flyout']//a[@class='popup_menu_item']")));
        popupMenuHomePage.click();
    }

    public void clickButtonAbout() {
        WebElement btnAbout = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='supernav_container']//a[@class='menuitem'][1]")));
        btnAbout.click();
    }

    public void clickSubMenuStore() {
        WebElement subMenuStore = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='supernav_container']//a[@class='menuitem supernav'][@data-tooltip-content='.submenu_store']")));
        subMenuStore.click();
    }

    public void clickPopupMenuSalesLeaders() {
        WebElement noteworthyTab = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='noteworthy_tab']//a[@class='pulldown_desktop']")));
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(noteworthyTab).build().perform();
        WebElement popupMenuSalesLeaders = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='noteworthy_flyout']//a[@class='popup_menu_item'][1]")));
        popupMenuSalesLeaders.click();
    }

    public boolean getUniqueElementHomePage() {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home_page_gutter_block']")));
        List<WebElement> gutterBlock= Browser.getDriver().findElements(By.xpath("//div[@class='home_page_gutter_block']"));
        boolean elementIs = gutterBlock.size() > 0;
        return elementIs;
    }
}
