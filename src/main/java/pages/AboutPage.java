package pages;

import browser.MethodsForSearch;
import browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AboutPage extends MethodsForSearch {
      private final String xpathGamers = "//div[@class='online_stat']";
      private final String xpathGutterBlock = "//div[@id='about_greeting']";

      private HeaderPage headerPage;

      public AboutPage() {
            headerPage = new HeaderPage();
      }

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
                                    returnNumber = webElementInInt(gamers.get(0));
                                    break;
                              case "Gamers in game":
                                    returnNumber = webElementInInt(gamers.get(1));
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

      public int getUniqueElementAboutPage() {
            List<WebElement> gutterBlock = findElements(xpathGutterBlock);
            return gutterBlock.size();
      }

      public HeaderPage getHeaderPage() {
            return headerPage;
      }
}
