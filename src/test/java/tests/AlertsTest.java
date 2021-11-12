package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertForm;
import pages.AlertsForm;
import pages.AlertsWindowsPage;
import pages.HomePage;
import utils.ConfigManager;

public class AlertsTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;
    private AlertsForm alertsForm;
    private AlertForm alertForm;

    @Test
    public void checkAlerts() {
        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();
        alertsForm = new AlertsForm();
        alertForm = new AlertForm();

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isPageOpen(),  "Didn't go to the Home page.");

        homePage.getHeaderMenu().clickBtnCloseAdvertising();
        homePage.clickBtnAlertsFrameAndWindowsHome();
     //   alertsWindowsPage.getHeaderMenu().clickBtnCloseAdvertising();
        alertsWindowsPage.clickBtnAlerts();
        Assert.assertTrue(alertsForm.isPageOpen(),  "Didn't go to the Alerts form.");

        alertsForm.clickBtnToSeeAlert();
        Assert.assertTrue(alertForm.getTextAlert().contains(ConfigManager.getTestDataString("textAlertToSee")),
                "Alert with the text 'You clicked a button' is not open");

        alertForm.clickBtnOk();
        Assert.assertTrue((!alertForm.isAlertOpen()), "Alert did not close.");

        alertsForm.clickBtnConfirm();
        Assert.assertTrue(alertForm.getTextAlert().contains(ConfigManager.getTestDataString("textAlertConfirm")),
                "Alert with the text 'Do you confirm action?' is not open");

        alertForm.clickBtnOk();
        Assert.assertTrue(!alertForm.isAlertOpen(), "Alert did not close.");

        Assert.assertTrue(alertsForm.getTextBtnConfirm().contains(ConfigManager.getTestDataString("textAlertBtnConfirm")),
                "The inscription 'You selected Ok' did not appear next to the button");

        alertsForm.clickBtnPromt();
        Assert.assertTrue(alertForm.getTextAlert().contains(ConfigManager.getTestDataString("textAlertPromt")),
                "Alert with the text 'Please enter your name' is not open");

        alertForm.inputText(ConfigManager.getTestDataString("inputTextAlert"));
        alertForm.clickBtnOk();
        Assert.assertTrue(!alertForm.isAlertOpen(), "Alert did not close.");
        Assert.assertTrue(alertsForm.getTextBtnPromt().contains(ConfigManager.getTestDataString("inputTextAlert")),
                "The inscription 'You selected Ok' did not appear next to the button");
    }
}
