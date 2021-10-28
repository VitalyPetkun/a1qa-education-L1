import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private final String URL = "https://store.steampowered.com/";
    private final int widthFrame = 1280;
    private final int heightFrame = 800;
    private static WebDriver driver;
    private static Browser INSTANCE;

    private Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(widthFrame, heightFrame));
        driver.get(URL);
        driver.manage().timeouts();
    }

    public static Browser getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Browser();

        return INSTANCE;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
