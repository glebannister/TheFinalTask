package framework.elements;

import framework.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {
    public DropDown(By locator, String name) {
        super(locator, name);
    }

    public void selectTestStatusByText(String testStatus) {
        LogUtil.info(String.format("Selecting test status by name %s", testStatus));
        Select select = new Select(findElement());
        select.selectByVisibleText(testStatus);
    }
}
