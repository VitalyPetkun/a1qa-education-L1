package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AboutPage extends Base{
      private String xpathGamersOnline = "//div[@class='online_stat']";
      private String xpathGutterBlock = "//div[@id='about_greeting']";

      private List<WebElement> gamersOnline;
      private List<WebElement> gutterBlock;

      private int getGamers(String status) {
            gamersOnline = findElements(xpathGamersOnline);
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
            gutterBlock = findElements(xpathGutterBlock);
            return (gutterBlock.size() > 0);
      }
}
