package app.ui.pages;

import app.ui.forms.AddTestForm;
import app.ui.forms.ProjectPanelForm;
import app.ui.forms.TestsListForm;
import org.openqa.selenium.By;

public class NewProjectPage extends BasePage{
    private ProjectPanelForm projectPanelForm = new ProjectPanelForm();
    private AddTestForm addTestForm = new AddTestForm();
    private TestsListForm testsListForm = new TestsListForm();

    public NewProjectPage() {
        super(By.xpath("//div[contains(@class,'panel-body center')]"), "Project panel");
    }

    public ProjectPanelForm getProjectPanelForm(){
        return projectPanelForm;
    }

    public AddTestForm getAddTestForm(){
        return addTestForm;
    }

    public TestsListForm getTestsListForm(){
        return testsListForm;
    }
}
