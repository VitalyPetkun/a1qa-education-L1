package framework;

import framework.browser.WaiterUtils;
import elements.WebTable;
import framework.utils.MyLogger;
import org.openqa.selenium.By;

public abstract class BaseForm {
    private By uniqElement;
    private String formName;

    protected BaseForm(By uniqElement, String formName) {
        this.uniqElement = uniqElement;
        this.formName = formName;
    }

    public boolean isFormOpen() {
        WebTable list = new WebTable(uniqElement, "uniqElement " + formName);
        if(list.isPresentUniqElement())
            MyLogger.logInfo("open " + formName + ".");
        else
            MyLogger.logWarn("not open " + formName + ".");
        return list.isPresentUniqElement();
    }

    public boolean isFormClose() {
        if(WaiterUtils.invisibilityOfElementLocated(uniqElement))
            MyLogger.logInfo("close " + formName + ".");
        else
            MyLogger.logWarn("not close " + formName + ".");
        return WaiterUtils.invisibilityOfElementLocated(uniqElement);
    }
}
