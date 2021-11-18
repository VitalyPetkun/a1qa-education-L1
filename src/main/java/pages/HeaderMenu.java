package pages;

import elements.Link;

public class HeaderMenu {
    private final String xpathLinkHome = "//header/a";

    public void clickLinkHome() {
        new Link(xpathLinkHome, "linkHome").click();
    }
}
