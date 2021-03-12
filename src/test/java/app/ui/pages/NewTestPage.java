package app.ui.pages;

import app.ui.forms.TestInfoForm;
import framework.elements.Image;
import framework.elements.Label;
import framework.utils.PropertyReader;
import org.openqa.selenium.By;

public class NewTestPage extends BasePage{
    private Label testNameLabel  = new Label(By.xpath("//ol[@class='breadcrumb']/li[4]"), "Test name label");
    private Image screenshotImage = new Image(By.xpath("//img[@class='thumbnail']"),"ScreenshotImage");
    private TestInfoForm testInfoForm = new TestInfoForm();

    public NewTestPage() {
        super(By.xpath("//ol[@class='breadcrumb']/li[4]"), "Test name label");
    }

    public String getTestName(){
        return testNameLabel.getText();
    }

    public String getScreenshotImageBase64(){
        return screenshotImage.getAttribute(PropertyReader.getDataValue("srcAttribute"));
    }

    public TestInfoForm getTestInfoForm(){
        return testInfoForm;
    }
}
