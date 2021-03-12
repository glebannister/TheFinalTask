package app.ui.pages;

import app.ui.constants.Hrefs;
import app.ui.forms.ProjectsListForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ProjectsPage extends BasePage {
    private Button addProjectButton = new Button(
            By.xpath(String.format("//a[@href='%s']", Hrefs.ADD_PROJECT)), "AddProjectButton");
    private ProjectsListForm projectsListForm = new ProjectsListForm();

    public ProjectsPage() {
        super(By.xpath("//div[contains(@class,'panel panel-default')]"), "Projects panel");
    }

    public void clickAddProjectButton(){ addProjectButton.click(); }


    public ProjectsListForm getProjectsListForm(){
        return projectsListForm;
    }
}
