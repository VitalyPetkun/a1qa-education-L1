package pages;

import framework.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    public SamplePage() {
        super(By.xpath("//h1[@id='sampleHeading']"), "SamplePage");
    }
}
