package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }

    private static void setUpDriver() {
        try {
            driver = BrowserFactory.factoryMethod(driver);
        } catch (NullPointerException ex) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        setSize();
        timeouts();
    }

    private static void setSize() {
        driver.manage().window().maximize();
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    private static void timeouts() {
        driver.manage().timeouts();
    }

    public static void quit() {
        getDriver().quit();
        driver = null;
    }

    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static void switchToNextWindow(String originalWindow) {
        WaiterUtils.numberOfWindowsToBe();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                switchToWindow(windowHandle);
                break;
            }
        }
    }

    public static void switchToWindow(String windowHandle) {
        getDriver().switchTo().window(windowHandle);
    }

    public static void closeWindow() {
        getDriver().close();
    }
}
