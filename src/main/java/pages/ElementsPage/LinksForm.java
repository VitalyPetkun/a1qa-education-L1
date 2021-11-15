package pages.ElementsPage;

import elements.Link;
import pages.BaseForm;

public class LinksForm extends BaseForm {
    private Link linkHome;

    public LinksForm() {
        super("//div[@id='linkWrapper']", "LinksForm");
    }

    public void clickLinkHome() {
        linkHome = new Link("//a[@id='simpleLink']", "linkHome");
        linkHome.click();
    }
}
