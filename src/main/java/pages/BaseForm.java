package pages;

import elements.WebTable;

abstract class BaseForm {
    private String uniqElement;
    private String formName;

    BaseForm(String uniqElement, String formName) {
        this.uniqElement = uniqElement;
        this.formName = formName;
    }

    public boolean isPageOpen() {
        WebTable list = new WebTable(uniqElement, "uniqElement" + formName);
        return list.isDisplayed();
    }
}
