package pages.ElementsPage;

import elements.Button;
import elements.WebTable;
import pages.BaseForm;
import java.util.Arrays;

public class WebTablesForm extends BaseForm {
    private Button btnAdd;
    private Button btnDelete;
    private RegistrationForm registrationForm;
    private WebTable listRows;

    public WebTablesForm() {
        super("//div[contains(@class,'ReactTable')]", "WebTablesForm");
    }

    public void clickBtnAdd() {
        btnAdd = new Button("//button[@id='addNewRecordButton']", "btnAdd");
        btnAdd.click();
    }

    public void clickBtnDelete(String[] user) {
        btnDelete = new Button("//span[@id='delete-record-" + (getIndexUserInWebTable(user) + 1) + "']",
                "btnDeleteUser" + (getIndexUserInWebTable(user) + 1));
        btnDelete.click();
    }

    public int sizeWebTable() {
        listRows = new WebTable("//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]",
                "listRowsWebTable");
        return listRows.sizeList();
    }

    public int getIndexUserInWebTable(String[] user) {
        String[] listUsers;
        int index = -1;
        listRows = new WebTable("//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]",
                "listRowsWebTable");
        for (int i = 0; i < listRows.sizeList(); i++) {
            listUsers = listRows.listElements().get(i).getText().split("\n");
            if(Arrays.equals(listUsers, user))
                index = i;
        }
        return index;
    }

    public RegistrationForm getRegistrationForm() {
        registrationForm = new RegistrationForm();
        return registrationForm;
    }
}
