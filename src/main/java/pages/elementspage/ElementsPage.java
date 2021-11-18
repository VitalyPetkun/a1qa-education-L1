package pages.elementspage;

import elements.Button;
import framework.BaseForm;

public class ElementsPage extends BaseForm {
    private final String xpathBtnWebTables = "//div[contains(@class,'collapse show')]//li[@id='item-3']";

    public ElementsPage() {
        super("//div[@class='left-pannel']", "ElementsPage");
    }

    public void clickBtnWebTables() {
        new Button(xpathBtnWebTables, "btnWebTables").click();
    }

    public WebTablesForm getWebTablesForm() {
        return new WebTablesForm();
    }

    public LinksForm getLinksForm() {
        return new LinksForm();
    }
}
