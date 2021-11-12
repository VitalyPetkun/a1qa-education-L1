package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import utils.ConfigManager;

public class AlertsTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;

    @Test
    public void checkAlerts() {
        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(),  "Didn't go to the Home page.");

        homePage.clickBtnAlertsFrameAndWindowsHome();
        alertsWindowsPage.clickBtnAlerts();
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().isFormOpen(),  "Didn't go to the Alerts form.");

        alertsWindowsPage.getAlertsForm().clickBtnToSeeAlert();
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().getAlertForm().getTextAlert().contains(ConfigManager.getTestDataString("textAlertToSee")),
                "Alert with the text 'You clicked a button' is not open");

        alertsWindowsPage.getAlertsForm().getAlertForm().clickBtnOk();
        Assert.assertTrue((!alertsWindowsPage.getAlertsForm().getAlertForm().isAlertOpen()), "Alert did not close.");

        alertsWindowsPage.getAlertsForm().clickBtnConfirm();
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().getAlertForm().getTextAlert().contains(ConfigManager.getTestDataString("textAlertConfirm")),
                "Alert with the text 'Do you confirm action?' is not open");

        alertsWindowsPage.getAlertsForm().getAlertForm().clickBtnOk();
        Assert.assertTrue(!alertsWindowsPage.getAlertsForm().getAlertForm().isAlertOpen(), "Alert did not close.");

        Assert.assertTrue(alertsWindowsPage.getAlertsForm().getTextBtnConfirm().contains(ConfigManager.getTestDataString("textAlertBtnConfirm")),
                "The inscription 'You selected Ok' did not appear next to the button");

        alertsWindowsPage.getAlertsForm().clickBtnPromt();
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().getAlertForm().getTextAlert().contains(ConfigManager.getTestDataString("textAlertPromt")),
                "Alert with the text 'Please enter your name' is not open");

        alertsWindowsPage.getAlertsForm().getAlertForm().inputText(ConfigManager.getTestDataString("inputTextAlert"));
        alertsWindowsPage.getAlertsForm().getAlertForm().clickBtnOk();
        Assert.assertTrue(!alertsWindowsPage.getAlertsForm().getAlertForm().isAlertOpen(), "Alert did not close.");
        Assert.assertTrue(alertsWindowsPage.getAlertsForm().getTextBtnPromt().contains(ConfigManager.getTestDataString("inputTextAlert")),
                "The inscription 'You selected Ok' did not appear next to the button");
    }
}
