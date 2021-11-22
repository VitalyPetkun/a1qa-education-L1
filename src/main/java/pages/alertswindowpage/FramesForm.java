package pages.alertswindowpage;

import elements.WebTable;
import framework.browser.Browser;
import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class FramesForm extends BaseForm {
    private final By xpathTopIframe = By.xpath("//iframe[@id='frame1']");
    private final By xpathBottomIframe = By.xpath("//iframe[@id='frame2']");
    private final By xpathTxtTopFrame = By.xpath("//body");
    private final By xpathTxtBottomFrame = By.xpath("//body");

    public FramesForm() {
        super(new WebTable(By.xpath("//div[@id='framesWrapper']"),"uniqElementFramesForm"), "FramesForm");
    }

    public String getTextTopFrame() {
        new Iframe(xpathTopIframe, "topFrame").switchToFrame();
        return new TextBox(xpathTxtTopFrame, "txtTopFrame").getText();
    }

    public String getTextBottomFrame() {
        Browser.getDriver().switchTo().defaultContent();
        new Iframe(xpathBottomIframe, "bottomFrame").switchToFrame();
        return new TextBox(xpathTxtBottomFrame, "txtBottomFrame").getText();
    }
}
