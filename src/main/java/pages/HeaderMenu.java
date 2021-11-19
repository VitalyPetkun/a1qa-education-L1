package pages;

import elements.Link;
import org.openqa.selenium.By;

public class HeaderMenu {
    private final By xpathLinkHome = By.xpath("//header/a");

    public void clickLinkHome() {
        new Link(xpathLinkHome, "linkHome").click();
    }
}
