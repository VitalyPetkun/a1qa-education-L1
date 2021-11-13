package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage.ElementsPage;
import pages.HomePage;
import utils.ConfigManager;
import utils.MyLogger;
import utils.UserManager;

public class TablesTest  extends BaseTest{
    private HomePage homePage;
    private ElementsPage elementsPage;

    @Test
    public void checkTables() {
        MyLogger.logInfo("Start TablesTest.");

        homePage = new HomePage();
        elementsPage = new ElementsPage();

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        homePage.clickBtnElements();
        elementsPage.clickBtnWebTables();
        Assert.assertTrue(elementsPage.getWebTablesForm().isFormOpen(),  "A page with a Web Tables form is not open.");

        elementsPage.getWebTablesForm().clickBtnAdd();
        Assert.assertTrue(elementsPage.getWebTablesForm().getRegistrationForm().isFormOpen(),
                "The Registration Form did not appear on the page.");

        elementsPage.getWebTablesForm().getRegistrationForm()
                .inputInfoUser(UserManager.getUser(ConfigManager.getTestDataInt("userNumberAdd")));
        elementsPage.getWebTablesForm().getRegistrationForm().clickBtnSubmit();
        Assert.assertFalse(elementsPage.getWebTablesForm().getRegistrationForm().isFormOpen(),
                "The Registration Form is not closed.");

        MyLogger.logInfo("Finish TablesTest.");
    }
}
