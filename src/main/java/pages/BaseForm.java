package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

abstract class BaseForm {
    private List<WebElement> uniqElement;
    private String pageName;

    private boolean isPageOpen() {
        return uniqElement.size() > 0;
    }
}
