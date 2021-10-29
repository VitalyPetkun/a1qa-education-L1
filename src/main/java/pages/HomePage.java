package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HomePage {
    @FindBy(xpath = "//div[@id='global_header']//span[@id='logo_holder']//a")
    private WebElement logoHolder;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem'][1]")
    private WebElement buttonAbout;

    @FindBy(xpath = "//div[@id='global_header']//div[@class='supernav_container']//a[@class='menuitem supernav'][@data-tooltip-content='.submenu_store']")
    private WebElement subMenuStore;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(ConfProperties.getPropertyString("URLHomePage"));
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

    public boolean getUniqueElementHomePage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home_page_gutter_block']")));
        List<WebElement> gutterBlock= driver.findElements(By.xpath("//div[@class='home_page_gutter_block']"));
        boolean elementIs = gutterBlock.size() > 0;
        return elementIs;
    }
}
