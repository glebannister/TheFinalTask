package app.ui.forms;

import framework.elements.PanelList;
import org.openqa.selenium.By;

public class ProjectsListForm {
    private PanelList panelList = new PanelList(By.xpath("//div[@class='list-group']//a"), "ProjectPanelList");

    public void selectProjectByName(String projectName){
        panelList.selectProjectByName(projectName);
    }

    public boolean isNewProjectAppeared(String projectName){
        return panelList.checkNewProjectSavedByName(projectName);
    }
}
