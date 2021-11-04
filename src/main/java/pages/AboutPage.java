package pages;

import browser.MethodsForSearch;
import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AboutPage extends MethodsForSearch {
      private final String xpathGamers = "//div[@class='online_stat']";
      private final String xpathGutterBlock = "//div[@id='about_greeting']";

      private int getGamers(String status) {
            List<WebElement> gamers = findElements(xpathGamers);
            int returnNumber = 0;

            switch (gamers.size()) {
                  case 0:
                        BrowserFactory.getDriver().navigate().refresh();
                        break;
                  default:
                        switch (status) {
                              case "Gamers online":
                                    returnNumber = getNumberGamers(0, gamers);
                                    break;
                              case "Gamers in game":
                                    returnNumber = getNumberGamers(1, gamers);
                                    break;
                        }
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
            List<WebElement> gutterBlock = findElements(xpathGutterBlock);
            return (gutterBlock.size() > 0);
      }

      private int getNumberGamers(int number, List<WebElement> gamers) {
            return Integer.valueOf(gamers.get(number).
                    getText().replaceAll("[^0-9]+",""));
      }
}
