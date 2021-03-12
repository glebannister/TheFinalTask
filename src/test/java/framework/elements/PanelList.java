package framework.elements;

import framework.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PanelList extends BaseElement{
    public PanelList(By locator, String name) {
        super(locator, name);
    }

    private void selectByName(String itemName){
        for (WebElement element: findElements()) {
            if (element.getText().equals(itemName)) {
                element.click();
                break;
            }
        }
    }

    public void selectProjectByName(String projectName) {
        LogUtil.info(String.format("Selecting project by name %s", projectName));
        selectByName(projectName);
    }

    public void selectTestByName(String testName){
        LogUtil.info(String.format("Selecting test by name %s", testName));
        selectByName(testName);
    }

    public boolean isNewItemSavedByName(String itemName){
        boolean isSaved = false;
        for (WebElement element: findElements()) {
            if (element.getText().equals(itemName)) {
                isSaved = true;
                break;
            }
        }
        return isSaved;
    }
    public boolean checkNewProjectSavedByName(String projectName){
        LogUtil.info(String.format("Checking if new project saved %s", projectName));
        return isNewItemSavedByName(projectName);
    }

    public boolean checkNewTestSavedByName(String testName){
        LogUtil.info(String.format("Checking if new test saved %s", testName));
        return isNewItemSavedByName(testName);
    }

    public boolean isElementExistByText(String elementText){
        LogUtil.info(String.format("Checking if element exist by text %s", elementText));
        boolean isExist = false;
        for (WebElement element: findElements()) {
            if (element.getText().equals(elementText)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}
