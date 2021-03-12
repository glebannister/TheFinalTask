package app.ui.forms;

import framework.elements.Button;
import framework.elements.Label;
import framework.elements.PanelList;
import framework.waits.Waits;
import org.openqa.selenium.By;

public class TestsListForm {
    private final String locatorForGetTestAttribute = "//table[@class='table']/tbody/tr[%s]/td[%s]";
    private final String locatorForAmountOfTest = "//table[@class='table']//tr";
    private final String locatorForSelectTest = "//table[@class='table']//tr//td//a";

    public boolean isNewTestAppeared(String testName){
        Waits.waitUntilAmountOfElements(By.xpath(locatorForAmountOfTest), getAmountOfTestsOnPage());
        Waits.waitForVisibility(new Button(By.xpath(locatorForSelectTest),"Select test button"));
        return new PanelList(
                By.xpath(locatorForSelectTest),"TestsPanelList").checkNewTestSavedByName(testName);
    }

    public void selectTestByName(String testName){
        new PanelList(By.xpath(locatorForSelectTest),"TestsPanelList").selectTestByName(testName);
    }

    public int getAmountOfTestsOnPage(){
        return new PanelList(By.xpath(locatorForAmountOfTest),"TestsPanelList").findElements().size();
    }

    public String getTestAttribute(int numberOfTr, int numberOfTd){
        return new Label(
                By.xpath(String.format(locatorForGetTestAttribute, numberOfTr, numberOfTd)),
                "Test attribute label").getText();
    }
}
