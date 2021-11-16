package tests;

import browser.Browser;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElementsPage.ElementsPage;
import pages.ElementsPage.RegistrationForm;
import pages.ElementsPage.WebTablesForm;
import pages.HomePage;
import userModel.User;
import utils.ConfigManager;
import utils.MyLogger;
import utils.UserManager;


public class TablesTest extends BaseTest {
    private HomePage homePage;
    private ElementsPage elementsPage;

    @DataProvider
    public Object[][] getUser() {
        return new Object[][]{
                {UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getFirstName(),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getLastName(),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getAge(),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getEmail(),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getSalary(),
                        UserManager.getUser(ConfigManager.getTestDataInt("userNumberInFileUsers")).getDepartment()
                }
        };
    }

    @Test(dataProvider = "getUser")
    public void checkTables(User user, String[] userInfo) {
        MyLogger.logInfo("start TablesTest.");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        int sizeWebTableAfterAddUser;

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),
                "Didn't go to the Home page.");

        homePage.clickBtnElements();
        elementsPage.clickBtnWebTables();
        Assert.assertTrue(elementsPage.getWebTablesForm().isFormOpen(), "A page with a Web Tables form is not open.");

        elementsPage.getWebTablesForm().clickBtnAdd();
        Assert.assertTrue(elementsPage.getWebTablesForm().getRegistrationForm().isFormOpen(),
                "The Registration Form did not appear on the page.");

        elementsPage.getWebTablesForm().getRegistrationForm().inputInfoUser(user);
        elementsPage.getWebTablesForm().getRegistrationForm().clickBtnSubmit();
        Assert.assertTrue(elementsPage.getWebTablesForm().getRegistrationForm().isFormClose(),
                "The Registration Form is not closed.");
        Assert.assertTrue(elementsPage.getWebTablesForm().getIndexUserInWebTable(userInfo) >= 0,
                "User userNumber data did not appear in the table.");

        sizeWebTableAfterAddUser = elementsPage.getWebTablesForm().sizeWebTable();
        elementsPage.getWebTablesForm().clickBtnDelete(userInfo);

        Assert.assertFalse(elementsPage.getWebTablesForm().getIndexUserInWebTable(userInfo) >= 0,
                "User userNumber has not been removed from the table.");
        Assert.assertTrue(elementsPage.getWebTablesForm().sizeWebTable() != sizeWebTableAfterAddUser,
                "The number of records in the table has not changed.");

        MyLogger.logInfo("finish TablesTest.");
    }
}
