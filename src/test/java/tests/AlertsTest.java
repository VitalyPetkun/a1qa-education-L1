package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class AlertsTest extends BaseTest{
    private HomePage homePage;
    @Test
    public void clickAlerts() {
        homePage = new HomePage();
    }
}
