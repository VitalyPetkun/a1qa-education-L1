package pages;

import elements.Button;

public class HomePage extends BaseForm{
    private Button btnAlertsWindows;

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
}
