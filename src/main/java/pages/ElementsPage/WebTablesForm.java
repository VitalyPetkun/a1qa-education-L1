package pages.ElementsPage;

import elements.Button;
import elements.WebTable;
import pages.BaseForm;
import userModel.User;


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

    public void clickBtnDelete(User user) {
        btnDelete = new Button("//span[@id='delete-record-" + String.valueOf(checkUserInWebTable(user) + 1) + "']",
                "btnDeleteUser" + String.valueOf(checkUserInWebTable(user) + 1));
        btnDelete.click();
    }

    public int sizeWebTable() {
        listRows = new WebTable("//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]",
                "listRowsWebTable");
        return listRows.sizeList();
    }

    public boolean isPresentUserData(User user) {
        boolean isPresentUserData = false;
        if (checkUserInWebTable(user) >= 0)
            isPresentUserData = true;
        return isPresentUserData;
    }

    private int checkUserInWebTable(User user) {
        String[] listUsers;
        int index = -1;
        listRows = new WebTable("//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]",
                "listRowsWebTable");

        for (int i = 0; i < listRows.sizeList(); i++) {
            listUsers = listRows.listElements().get(i).getText().split("\n");
            if (listUsers[0].contains(user.getFirstName()))
                if (listUsers[1].contains(user.getLastName()))
                    if (listUsers[2].contains(user.getAge()))
                        if (listUsers[3].contains(user.getEmail()))
                            if (listUsers[4].contains(user.getSalary()))
                                if (listUsers[5].contains(user.getDepartment()))
                                    index = i;
        }
        return index;
    }

    public RegistrationForm getRegistrationForm() {
        registrationForm = new RegistrationForm();
        return registrationForm;
    }
}
