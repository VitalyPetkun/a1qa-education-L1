package pages.elementspage;

import elements.Button;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    private final By xpathBtnWebTables = By.xpath("//div[contains(@class,'collapse show')]//li[@id='item-3']");

    public ElementsPage() {
        super(By.xpath("//div[@class='left-pannel']"), "ElementsPage");
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
