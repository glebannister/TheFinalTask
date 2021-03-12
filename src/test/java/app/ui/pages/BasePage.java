package app.ui.pages;

import app.ui.constants.Hrefs;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class BasePage {
    private By locatorOfPageElement;
    private String elementName;
    private Button homeButton = new Button(
            By.xpath(String.format("//a[@href='%s']", Hrefs.WEB_PROJECTS)), "HomeButton");
    private Label versionLabel = new Label(
            By.xpath("//p[contains(@class,'text-muted text-center footer-text')]//span"),"VersionLabel");

    public BasePage(By locatorOfPageElement, String elementName){
        this.locatorOfPageElement = locatorOfPageElement;
        this.elementName = elementName;
    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public String getVersion(){
        return versionLabel.getText();
    }

    public boolean isPageLoaded(){
        return new Label(locatorOfPageElement, elementName).isElementExist();
    }
}
