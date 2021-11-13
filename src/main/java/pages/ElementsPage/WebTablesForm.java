package pages.ElementsPage;

import elements.Button;
import pages.BaseForm;

public class WebTablesForm extends BaseForm {
    private Button btnAdd;
    private Button btnDelete;
    private RegistrationForm registrationForm;

    public WebTablesForm() {
        super("//div[contains(@class,'ReactTable')]", "WebTablesForm");
    }

    public void clickBtnAdd() {
        btnAdd = new Button("//button[@id='addNewRecordButton']", "btnAdd");
        btnAdd.click();
    }

    public void clickBtnDelete(String userNumber) {
        btnDelete = new Button("//span[@id='delete-record-" + userNumber + "']", "btnDeleteUser" + userNumber);
        btnDelete.click();
    }

    public RegistrationForm getRegistrationForm() {
        registrationForm = new RegistrationForm();
        return registrationForm;
    }
}
