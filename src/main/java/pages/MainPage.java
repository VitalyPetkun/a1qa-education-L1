package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='global_header']//span[@id='logo_holder']//a")
    private WebElement logoHolder;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem']")
    private WebElement buttonAbout;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem supernav'][@data-tooltip-content='.submenu_store']")
    private WebElement subMenuStore;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLogoHolder() {
        logoHolder.click();
    }

    public void clickButtonAbout() {
        buttonAbout.click();
    }

    public void clickSubMenuStore() {
        subMenuStore.click();
    }

    /*public String sdfg() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(ConfProperties.getPropertyString("XPathContentTitle"))));
        return driver.getCurrentUrl();
    }
    */
}
