package pages;

import elements.Button;

public class HomePage extends BaseForm{
    private Button btnAlertsWindows;
    private Button btnElements;
    private Button btnWidgets;

    public HomePage() {
        super("//div[@class='category-cards']", "Home Page");
    }

    public HeaderMenu getHeaderMenu() {
        return new HeaderMenu();
    }

    public void clickBtnAlertsFrameAndWindowsHome() {
        btnAlertsWindows = new Button(".//*[@fill-rule='evenodd']//ancestor::div[contains(@class,'top-card')]//div[@class='card-body']",
                "btnAlertsWindows");
        btnAlertsWindows.click();
    }

    public void clickBtnElements() {
        btnElements = new Button(".//*[@version]//ancestor::div[contains(@class,'top-card')]//preceding-sibling::div[contains(@class,'top-card')]//div[@class='card-body']",
                "btnElements");
        btnElements.click();
    }

    public void clickBtnWidgets() {
        btnWidgets = new Button("//div[contains(@class,'top-card')][4]//div[@class='card-body']",
                "btnWidgets");
        btnWidgets.click();
    }
}
