package pages.elementspage;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import usermodel.User;

public class RegistrationForm extends BaseForm {
    private final String xpathBtnSubmit = "//button[@id='submit']";
    private final String xpathTxtFirstName = "//input[@id='firstName']";
    private final String xpathTxtLastName = "//input[@id='lastName']";
    private final String xpathTxtEmail = "//input[@id='userEmail']";
    private final String xpathTxtAge = "//input[@id='age']";
    private final String xpathTxtSalary = "//input[@id='salary']";
    private final String xpathTxtDepartment = "//input[@id='department']";

    public RegistrationForm() {
        super("//div[@class='modal-content']", "RegistrationForm");
    }

    public void clickBtnSubmit() {
        new Button(xpathBtnSubmit, "btnSubmit").click();
    }

    public void inputInfoUser(User user) {
        inputFirstName(user.getFirstName());
        inputLastName(user.getLastName());
        inputEmail(user.getEmail());
        inputAge(user.getAge());
        inputSalary(user.getSalary());
        inputDepartment(user.getDepartment());
    }

    private void inputFirstName(String firstName) {
        new TextBox(xpathTxtFirstName, "txtFirstName").inputText(firstName);
    }

    private void inputLastName(String lastName) {
        new TextBox(xpathTxtLastName, "txtLastName").inputText(lastName);
    }

    private void inputEmail(String email) {
        new TextBox(xpathTxtEmail, "txtEmail").inputText(email);
    }

    private void inputAge(String age) {
        new TextBox(xpathTxtAge, "txtAge").inputText(age);
    }

    private void inputSalary(String salary) {
        new TextBox(xpathTxtSalary, "txtSalary").inputText(salary);
    }

    private void inputDepartment(String department) {
        new TextBox(xpathTxtDepartment, "txtDepartment").inputText(department);
    }
}
