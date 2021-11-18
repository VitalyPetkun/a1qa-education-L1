package pages.elementspage;

import elements.Link;
import framework.BaseForm;

public class LinksForm extends BaseForm {
    private final String xpathLinkHome = "//a[@id='simpleLink']";

    public LinksForm() {
        super("//div[@id='linkWrapper']", "LinksForm");
    }

    public void clickLinkHome() {
        new Link(xpathLinkHome, "linkHome").click();
    }
}
