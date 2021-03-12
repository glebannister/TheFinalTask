package app.ui.pages;

import app.ui.forms.AddProjectForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class AddProjectPage extends BasePage{
    private Label alertSuccessLabel = new Label(
            By.xpath("//div[contains(@class,'alert alert-success')]"), "AlertSuccessLabel");
    private AddProjectForm addProjectForm = new AddProjectForm();

    public AddProjectPage() {
        super(By.id("addProjectForm"), "Add project form");
    }

    public boolean isProjectSavedAlertAppeared(String newProjectName){
        return alertSuccessLabel.getText().contains(newProjectName);
    }

    public AddProjectForm getAddProjectForm(){
        return addProjectForm;
    }
}
