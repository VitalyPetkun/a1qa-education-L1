package pages.ElementsPage;

import elements.Button;
import elements.TextBox;
import pages.BaseForm;
import userModel.User;

import java.util.List;

public class RegistrationForm extends BaseForm {
    private Button btnSubmit;
    private TextBox txtFirstName;
    private TextBox txtLastName;
    private TextBox txtEmail;
    private TextBox txtAge;
    private TextBox txtSalary;
    private TextBox txtDepartment;

    public RegistrationForm() {
        super("//div[@class='modal-content']", "RegistrationForm");
    }

    public void clickBtnSubmit() {
        btnSubmit = new Button("//button[@id='submit']", "btnSubmit");
        btnSubmit.click();
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
        txtFirstName = new TextBox("//input[@id='firstName']", "txtFirstName");
        txtFirstName.inputText(firstName);
    }

    private void inputLastName(String lastName) {
        txtLastName = new TextBox("//input[@id='lastName']", "txtLastName");
        txtLastName.inputText(lastName);
    }

    private void inputEmail(String email) {
        txtEmail = new TextBox("//input[@id='userEmail']", "txtEmail");
        txtEmail.inputText(email);
    }

    private void inputAge(String age) {
        txtAge = new TextBox("//input[@id='age']", "txtAge");
        txtAge.inputText(age);
    }

    private void inputSalary(String salary) {
        txtSalary = new TextBox("//input[@id='salary']", "txtSalary");
        txtSalary.inputText(salary);
    }

    private void inputDepartment(String department) {
        txtDepartment = new TextBox("//input[@id='department']", "txtDepartment");
        txtDepartment.inputText(department);
    }
}
