package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WidgetsPage.WidgetsPage;
import utils.ConfigManager;
import utils.MyLogger;

public class SliderAndProgressBarTest extends BaseTest {
    private HomePage homePage;
    private WidgetsPage widgetsPage;
    private int currentValueProgressBar;

    @Test
    public void checkSliderAndProgressBar() {
        MyLogger.logInfo("start SliderAndProgressBarTest.");

        homePage = new HomePage();
        widgetsPage = new WidgetsPage();

        homePage.getHeaderMenu().clickLinkHome();
        Assert.assertTrue(homePage.isFormOpen(), "Didn't go to the Home page.");

        homePage.clickBtnWidgets();
        widgetsPage.clickBtnSlider();
        Assert.assertTrue(widgetsPage.getSliderForm().isFormOpen(), "A page with a Slider form is not open.");

        widgetsPage.getSliderForm().setValueSlider(ConfigManager.getTestDataInt("numberForSlider"));
        Assert.assertTrue(widgetsPage.getSliderForm().getValueSlider() == ConfigManager.getTestDataInt("numberForSlider"),
                "The value next to the slider does not match the randomly generated one.");

        widgetsPage.clickBtnProgressBar();
        Assert.assertTrue(widgetsPage.getProgressBarForm().isFormOpen(), "A page with a Progress Bar form is not open.");

        widgetsPage.getProgressBarForm().clickBtnStart();
        currentValueProgressBar = widgetsPage.getProgressBarForm().getCurrentValue();
        while (ConfigManager.getTestDataInt("ageEngineer") != currentValueProgressBar)
            currentValueProgressBar = widgetsPage.getProgressBarForm().getCurrentValue();
        widgetsPage.getProgressBarForm().clickBtnStop();
        Assert.assertTrue(widgetsPage.getProgressBarForm().getCurrentValue() == ConfigManager.getTestDataInt("ageEngineer"),
                "The value on the load bar does not match the age of the engineer.");

        MyLogger.logInfo("finish SliderAndProgressBarTest.");
    }
}
