package pages.elementspage;

import elements.Button;
import elements.WebTable;
import framework.BaseForm;
import usermodel.User;

import java.util.Arrays;

public class WebTablesForm extends BaseForm {
    private final String xpathBtnAdd = "//button[@id='addNewRecordButton']";
    private final String xpathListRowsWebTable =
            "//div[contains(@class,'rt-tr') and (contains(@class,'-even') or contains(@class,'-odd')) and not(contains(@class,'-padRow'))]";

    public WebTablesForm() {
        super("//div[contains(@class,'ReactTable')]", "WebTablesForm");
    }

    public void clickBtnAdd() {
        new Button(xpathBtnAdd, "btnAdd").click();
    }

    public void clickBtnDelete(User user) {
        new Button("//span[@id='delete-record-" + (getIndexUserInWebTable(user) + 1) + "']",
                "btnDeleteUser" + (getIndexUserInWebTable(user) + 1)).click();
    }

    public int sizeWebTable() {
        return new WebTable(xpathListRowsWebTable, "listRowsWebTable").sizeList();
    }

    public int getIndexUserInWebTable(User user) {
        String[] listUsers;
        String[] userInfo = new String[] {user.getFirstName(), user.getLastName(), user.getAge(),
                user.getEmail(), user.getSalary(), user.getDepartment()};
        int index = -1;

        WebTable listRows = new WebTable(xpathListRowsWebTable,"listRowsWebTable");
        for (int i = 0; i < listRows.sizeList(); i++) {
            listUsers = listRows.listElements().get(i).getText().split("\n");
            if(Arrays.equals(listUsers, userInfo))
                index = i;
        }
        return index;
    }

    public RegistrationForm getRegistrationForm() {
        return new RegistrationForm();
    }
}
