package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.ConfProperties;
import pages.MainPage;
import browser.Browser;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    public static WebDriver driver;
    public static MainPage homePage;
    public static AboutPage aboutPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getInstance();
        homePage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getPropertyString("URLMainPage"));
    }

    @Test
    public static void clickLogoHolderToGoTheMainPageTrue() {
        homePage.clickLogoHolder();
        Assert.assertEquals(ConfProperties.getPropertyString("URLMainPage"),driver.getCurrentUrl());
    }

    @Test
    public static void clickButtonAboutToGoTheAboutPageTrue() {
        homePage.clickButtonAbout();
        Assert.assertEquals(ConfProperties.getPropertyString("URLAboutPage"),driver.getCurrentUrl());
    }

    @Test
    public static void clickSubMenuStoreToGoTheMainPageTrue() {
        homePage.clickSubMenuStore();
        Assert.assertEquals(ConfProperties.getPropertyString("URLMainPage"),driver.getCurrentUrl());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
