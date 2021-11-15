package pages.ElementsPage;

import elements.Button;
import pages.BaseForm;

public class ElementsPage extends BaseForm {
    private Button btnWebTables;
    private WebTablesForm webTablesForm;
    private LinksForm linksForm;

    public ElementsPage() {
        super("//div[@class='left-pannel']", "ElementsPage");
    }

    public void clickBtnWebTables() {
        btnWebTables = new Button("//div[contains(@class,'collapse show')]//li[@id='item-3']", "btnWebTables");
        btnWebTables.click();
    }

    public WebTablesForm getWebTablesForm() {
        webTablesForm = new WebTablesForm();
        return webTablesForm;
    }

    public LinksForm getLinksForm() {
        linksForm = new LinksForm();
        return linksForm;
    }
}
