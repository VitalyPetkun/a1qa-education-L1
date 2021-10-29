package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AboutPage {
      @FindBy(xpath = "//div[@id='about_greeting']//div[@class='about_subtitle']")
      private WebElement subTitle;

      private int getGamers(WebDriver driver, String status) {
            driver.get(ConfProperties.getPropertyString("URLAboutPage"));
            List<WebElement> gamersOnline = driver.findElements(By.xpath("//div[@class='online_stat']"));
            int returnNumber=0;
            if (status == "Gamers online") {
                  returnNumber = Integer.valueOf(
                          gamersOnline.get(0).getText().replaceAll("[^0-9]+",""));
            }
            if (status == "Gamers in game") {
                  returnNumber = Integer.valueOf(
                          gamersOnline.get(1).getText().replaceAll("[^0-9]+",""));
            }
            /*try {
                  if(gamersOnline.size() == 0)
                        throw new NullPointerException();

            } catch (Exception e){
            }*/
            return returnNumber;
      }

      public int getGamersOnline(WebDriver driver) {
            return getGamers(driver, "Gamers online");
      }

      public int getGamersInGame(WebDriver driver) {
            return getGamers(driver, "Gamers in game");
      }

      public String getSubTitleAboutPage(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='about_greeting']//div[@class='about_subtitle'])")));
            return subTitle.getText();
      }
}
