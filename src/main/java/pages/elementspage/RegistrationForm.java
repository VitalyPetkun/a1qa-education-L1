package pages.elementspage;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;
import usermodel.User;

public class RegistrationForm extends BaseForm {
    private final By xpathBtnSubmit = By.xpath("//button[@id='submit']");
    private final By xpathTxtFirstName = By.xpath("//input[@id='firstName']");
    private final By xpathTxtLastName = By.xpath("//input[@id='lastName']");
    private final By xpathTxtEmail = By.xpath("//input[@id='userEmail']");
    private final By xpathTxtAge = By.xpath("//input[@id='age']");
    private final By xpathTxtSalary = By.xpath("//input[@id='salary']");
    private final By xpathTxtDepartment = By.xpath("//input[@id='department']");

    public RegistrationForm() {
        super(By.xpath("//div[@class='modal-content']"), "RegistrationForm");
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
