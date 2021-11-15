package pages;

public class SamplePage extends BaseForm{
    public SamplePage() {
        super("//h1[@id='sampleHeading']", "SamplePage");
    }
}
