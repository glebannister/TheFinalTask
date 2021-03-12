package app.ui.pages;

import app.ui.forms.TestsListForm;
import framework.elements.Label;
import framework.utils.DateUtil;
import framework.utils.PropertyReader;
import framework.waits.Waits;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NexageProjectPage extends BasePage{
    private Label projectNameLabel = new Label(By.xpath("//ol[@class='breadcrumb']/li[2]"), "Project name label");
    private TestsListForm testsListForm = new TestsListForm();

    public NexageProjectPage() {
        super(By.xpath("//ol[@class='breadcrumb']/li[2]"), "Project name label");
    }

    public String getProjectName(){
        Waits.waitForVisibility(projectNameLabel);
        return projectNameLabel.getText();
    }

    public boolean isTestOnPageAreInApiResponse(String responseString){
        boolean isTestInRequest = false;
        for (int i = 2; i <= testsListForm.getAmountOfTestsOnPage(); i++){
            if (responseString.contains(
                    testsListForm.getTestAttribute(
                            i, Integer.parseInt(PropertyReader.getDataValue("tdNumberForTestName")))))
            {
                isTestInRequest = true;
            }
        }
        return isTestInRequest;
    }

    public boolean isTestsSortedByDescendingDate(){
        List<Date> dateList = new ArrayList<>();
        for (int i = 2; i <= testsListForm.getAmountOfTestsOnPage(); i++){
            dateList.add(
                    DateUtil.parseStringToDate(
                            testsListForm.getTestAttribute(
                                    i,
                                    Integer.parseInt(PropertyReader.getDataValue("tdNumberForTestStartTime"))),
                            PropertyReader.getDataValue("datePattern")));
        }
        return DateUtil.isSortedByDescendingDate(dateList);
    }
}
