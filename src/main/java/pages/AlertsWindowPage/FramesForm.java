package pages.AlertsWindowPage;

import browser.Browser;
import elements.Iframe;
import elements.TextBox;
import pages.BaseForm;

public class FramesForm extends BaseForm {
    private Iframe topIframe;
    private Iframe bottomIframe;
    private TextBox txtBottomFrame;
    private TextBox txtTopFrame;

    public FramesForm() {
        super("//div[@id='framesWrapper']", "FramesForm");
    }

    public String getTextTopFrame() {
        topIframe = new Iframe("//iframe[@id='frame1']", "TopFrame");
        topIframe.switchToFrame();
        txtTopFrame = new TextBox("//body", "txtTopFrame");
        return txtTopFrame.getText();
    }

    public String getTextBottomFrame() {
        Browser.getDriver().switchTo().defaultContent();
        bottomIframe = new Iframe("//iframe[@id='frame2']", "BottomFrame");
        bottomIframe.switchToFrame();
        txtBottomFrame = new TextBox("//body", "txtBottomFrame");
        return txtBottomFrame.getText();
    }
}
