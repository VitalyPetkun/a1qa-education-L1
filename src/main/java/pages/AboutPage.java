package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage {
      private WebDriver driver;

      @FindBy(xpath = "//div[@id='about_greeting']//div[@class='about_subtitle']")
      private WebElement subTitle;

      @FindBy(xpath = "//div[@class='online_stats']//div[@class='online_stat'][1]//text()[2]")
      private WebElement gamersOnline;

      @FindBy(xpath = "//div[@class='online_stats']//div[@class='online_stat'][2]//text()[2]")
      private WebElement gamersInGame;

      public AboutPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
      }

      // comparison gamers on line and gamers in game
      public boolean comparisonOnlineAndGame() {
            Object objGamersOnline = (Object) gamersOnline;
            String strGamersOnline = gamersOnline.getText();
            int intGamersOnline = Integer.parseInt(strGamersOnline);
            String strGamersInGame = gamersInGame.getText();
            int intGamersInGame = Integer.parseInt(strGamersInGame);

            if(intGamersOnline >= intGamersInGame)
                  return true;
            else
                  return false;
      }

      public String getSubTitleAboutPage() {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfProperties.getPropertyString("XPathSubTitle"))));
            return subTitle.getText();
      }
}
