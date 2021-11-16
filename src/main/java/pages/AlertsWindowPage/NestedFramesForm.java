package pages.AlertsWindowPage;

import elements.Iframe;
import elements.TextBox;
import pages.BaseForm;

public class NestedFramesForm extends BaseForm {
    private Iframe parentIframe;
    private Iframe childIframe;
    private TextBox txtChildFrame;
    private TextBox txtParentFrame;

    public NestedFramesForm() {
        super("//div[@id='framesWrapper']", "NestedFramesForm");
    }

    public String getTextParentFrame() {
        parentIframe = new Iframe("//iframe[@id='frame1']", "ParentFrame");
        parentIframe.switchToFrame();
        txtParentFrame = new TextBox("//body", "txtParentFrame");
        return txtParentFrame.getText();
    }

    public String getTextChildFrame() {
        childIframe = new Iframe("//iframe", "ChildFrame");
        childIframe.switchToFrame();
        txtChildFrame= new TextBox("//body", "txtParentFrame");
        return txtChildFrame.getText();
    }
}
