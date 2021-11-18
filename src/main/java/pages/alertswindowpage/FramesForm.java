package pages.alertswindowpage;

import browser.Browser;
import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;

public class FramesForm extends BaseForm {
    private final String xpathTopIframe = "//iframe[@id='frame1']";
    private final String xpathBottomIframe = "//iframe[@id='frame2']";
    private final String xpathTxtTopFrame = "//body";
    private final String xpathTxtBottomFrame = "//body";

    public FramesForm() {
        super("//div[@id='framesWrapper']", "FramesForm");
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
