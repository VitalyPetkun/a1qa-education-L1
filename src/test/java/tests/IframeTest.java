package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;

public class IframeTest extends BaseTest{
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;

    @Test
    public void checkIframe() {
        homePage = new HomePage();
        alertsWindowsPage = new AlertsWindowsPage();

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isPageOpen(),  "Didn't go to the Home page.");

        homePage.getHeaderMenu().clickBtnCloseAdvertising();
        homePage.clickBtnAlertsFrameAndWindowsHome();
        alertsWindowsPage.clickBtnNestedFrames();

    }
}
