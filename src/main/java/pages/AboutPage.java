package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AboutPage {
      private int getGamers(String status) {
            List<WebElement> gamersOnline = Browser.getDriver().findElements(By.xpath("//div[@class='online_stat']"));
            int returnNumber=0;
            if(gamersOnline.size() == 0)
                  Browser.getDriver().navigate().refresh();
            if (status == "Gamers online") {
                  returnNumber = Integer.valueOf(
                          gamersOnline.get(0).getText().replaceAll("[^0-9]+",""));
            }
            if (status == "Gamers in game") {
                  returnNumber = Integer.valueOf(
                          gamersOnline.get(1).getText().replaceAll("[^0-9]+",""));
            }
            return returnNumber;
      }

      public int getGamersOnline() {
            return getGamers("Gamers online");
      }

      public int getGamersInGame() {
            return getGamers("Gamers in game");
      }

      public boolean getUniqueElementAboutPage() {
            WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='about_greeting']")));
            List<WebElement> gutterBlock= Browser.getDriver().findElements(By.xpath("//div[@id='about_greeting']"));
            boolean elementIs = gutterBlock.size() > 0;
            return elementIs;
      }
}
