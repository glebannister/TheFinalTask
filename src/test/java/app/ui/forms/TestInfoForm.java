package app.ui.forms;

import framework.elements.PanelList;
import org.openqa.selenium.By;

public class TestInfoForm {
    private PanelList testInfoList = new PanelList(By.xpath("//div[@class='list-group']//div//p"), "TestInfoList");

    public boolean isFieldFilledCorrect(String fieldText){
        return testInfoList.isElementExistByText(fieldText);
    }
}
