package pages;

import elements.Button;
import framework.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {
    private final By xpathBtnAlertsWindows =
            By.xpath(".//*[@fill-rule='evenodd']//ancestor::div[contains(@class,'top-card')]//div[@class='card-body']");
    private final By xpathBtnElements =
            By.xpath(".//*[@version]//ancestor::div[contains(@class,'top-card')]//preceding-sibling::div[contains(@class,'top-card')]//div[@class='card-body']");
    private final By xpathBtnWidgets = By.xpath("//div[contains(@class,'top-card')][4]//div[@class='card-body']");

    public HomePage() {
        super(By.xpath("//div[@class='category-cards']"), "Home Page");
    }

    public void clickBtnAlertsFrameAndWindowsHome() {
        new Button(xpathBtnAlertsWindows,"btnAlertsWindows").click();
    }

    public void clickBtnElements() {
        new Button(xpathBtnElements,"btnElements").click();
    }

    public void clickBtnWidgets() {
        new Button(xpathBtnWidgets,"btnWidgets").click();
    }

    public HeaderMenu getHeaderMenu() {
        return new HeaderMenu();
    }
}
