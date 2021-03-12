package app.ui.forms;

import app.ui.constants.ActionConstants;
import app.ui.models.NewTest;
import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.Field;
import framework.elements.Label;
import framework.utils.*;
import framework.waits.Waits;
import org.openqa.selenium.By;

public class AddTestForm {
    private Field testNameField = new Field(By.id("testName"), "TestNameField");
    private DropDown testStatusDropDown = new DropDown(By.xpath("//select[@name='status']"),"TestStatusDropDown");
    private Field testMethodField = new Field(By.id("testMethod"),"TestMethodField");
    private Field startTimeField = new Field(By.id("startTime"),"StartTimeField");
    private Field endTimeField = new Field(By.id("endTime"),"EndTimeField");
    private Field environmentField = new Field(By.id("environment"),"EnvironmentField");
    private Field browserField = new Field(By.id("browser"),"BrowserField");
    private Button selectFileButton = new Button(By.xpath("//label[@for='attachment']"),"SelectFileButton");
    private Button saveTestButton = new Button(
            By.xpath("//button[contains(@class,'btn btn-primary')]"), "SaveTestButton");
    private Label newTestSavedLabel = new Label(By.id("success"),"NewTestSavedLabel");

    public void createNewTest(NewTest newTest){
        testNameField.sendKeys(newTest.getName());
        testStatusDropDown.selectTestStatusByText(newTest.getStatus());
        testMethodField.sendKeys(newTest.getMethod());
        startTimeField.sendKeys(newTest.getStartTime());
        endTimeField.sendKeys(newTest.getStartTime());
        environmentField.sendKeys(newTest.getEnvironment());
        browserField.sendKeys(newTest.getBrowser());
        Browser.makeScreenshot(newTest.getPathToScreenshot());
        selectFileButton.click();
        WindowUploadUtil.uploadAvatarImage(FileUtil.uploadPathToFile(newTest.getPathToScreenshot()));
        saveTestButton.click();
    }

    public boolean isNewTestSavedMessageAppeared(String newTestName){
        Waits.waitForVisibility(newTestSavedLabel);
        return newTestSavedLabel.getText().contains(newTestName);
    }

    public void closeAddNewTestForm(){
        Browser.moveMouseAndClick(ActionConstants.xOffSet, ActionConstants.yOffSet);
    }
}
