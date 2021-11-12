package pages;

import browser.Browser;
import elements.Button;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderMenu {
    private Link linkHome;
    private Button btnCloseAdvertising;

    public void clickLinkHome() {
        linkHome = new Link("//header/a", "linkHome");
        linkHome.click();
    }

    public void clickBtnCloseAdvertising() {
        btnCloseAdvertising = new Button("//a[@id='close-fixedban']",
                "btnCloseAdvertising");
        btnCloseAdvertising.click();
    }
}
