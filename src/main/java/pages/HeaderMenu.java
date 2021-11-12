package pages;

import elements.Button;
import elements.Link;

public class HeaderMenu {
    private Link linkHome;
    private Button btnCloseAdvertising;

    public void clickLinkHome() {
        linkHome = new Link("//header/a", "linkHome");
        linkHome.click();
    }
}
