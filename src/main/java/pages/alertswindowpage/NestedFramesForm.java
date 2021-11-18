package pages.alertswindowpage;

import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;

public class NestedFramesForm extends BaseForm {
    private final String xpathParentIframe = "//iframe[@id='frame1']";
    private final String xpathChildIframe = "//iframe";
    private final String xpathTxtParentFrame = "//body";
    private final String xpathTxtChildFrame = "//body";

    public NestedFramesForm() {
        super("//div[@id='framesWrapper']", "NestedFramesForm");
    }

    public String getTextParentFrame() {
        new Iframe(xpathParentIframe, "ParentFrame").switchToFrame();
        return new TextBox(xpathTxtParentFrame, "txtParentFrame").getText();
    }

    public String getTextChildFrame() {
        new Iframe(xpathChildIframe, "ChildFrame").switchToFrame();
        return new TextBox(xpathTxtChildFrame, "txtParentFrame").getText();
    }
}
