package pages;

import elements.WebTable;
import utils.MyLogger;

abstract class BaseForm {
    private String uniqElement;
    private String formName;

    BaseForm(String uniqElement, String formName) {
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
}
