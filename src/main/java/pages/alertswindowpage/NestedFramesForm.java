package pages.alertswindowpage;

import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class NestedFramesForm extends BaseForm {
    private final By xpathParentIframe = By.xpath("//iframe[@id='frame1']");
    private final By xpathChildIframe = By.xpath("//iframe");
    private final By xpathTxtParentFrame = By.xpath("//body");
    private final By xpathTxtChildFrame = By.xpath("//body");

    public NestedFramesForm() {
        super(By.xpath("//div[@id='framesWrapper']"), "NestedFramesForm");
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
