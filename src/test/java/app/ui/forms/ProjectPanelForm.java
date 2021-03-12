package app.ui.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class ProjectPanelForm {
    private Button addTestButton = new Button(
            By.xpath("//button[contains(@class,'btn btn-xs btn-primary pull-right')]"),"AddTestButton");

    public void clickAddTestButton(){
        addTestButton.click();
    }
}
