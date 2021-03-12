package app.ui.forms;

import framework.elements.Button;
import framework.elements.Field;
import org.openqa.selenium.By;

public class AddProjectForm {
    private Field enterProjectNameField = new Field(By.id("projectName"), "EnterProjectNameField");
    private Button saveProjectButton = new Button(
            By.xpath("//button[contains(@class,'btn btn-primary')]"), "SaveProjectButton");

    public void createNewProject(String newProjectName){
        enterProjectNameField.sendKeys(newProjectName);
        saveProjectButton.click();
    }
}
