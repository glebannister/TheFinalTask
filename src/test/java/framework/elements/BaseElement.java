package framework.elements;

import framework.browser.Browser;
import framework.utils.LogUtil;
import framework.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

abstract public class BaseElement {
    protected By locator;
    protected String name;

    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement findElement() {
        LogUtil.info(String.format("Finding element %s, %s", locator, name));
        WebElement webElement = null;
        if (isElementExist()){
            webElement = Browser.getDriver().findElement(locator);
        } else LogUtil.error(String.format("Element was not found %s, %s", locator, name));
        return webElement;
    }

    public void sendKeys(String text) {
        LogUtil.info(String.format("Sending keys to element %s, %s, %s", locator, name, text));
        findElement().sendKeys(text);
    }

    public List<WebElement> findElements() {
        LogUtil.info(String.format("Finding list of elements %s, %s", locator, name));
        List<WebElement> webElements = null;
        if (isElementExist()){
            webElements = Browser.getDriver().findElements(locator);
        } else LogUtil.error(String.format("List of elements was not found %s, %s", locator, name));
        return webElements;
    }

    public void click() {
        LogUtil.info(String.format("Checking if element clickable %s, %s", locator, name));
        Waits.waitToBeClickable(locator);
        LogUtil.info(String.format("Clicking on %s, %s", locator, name));
        Browser.getDriver().findElement(locator).click();
    }

    public String getAttribute(String attribute) {
        LogUtil.info(String.format("Getting attribute of %s, %s", locator, name));
        return findElement().getAttribute(attribute);
    }

    public String getText() {
        LogUtil.info(String.format("Getting text of %s, %s", locator, name));
        return findElement().getText();
    }

    public boolean isElementExist(){
        LogUtil.info(String.format("Check if element exist %s, %s", locator, name));
        return Browser.getDriver().findElements(locator).size() > 0;
    }

    public By getLocator(){
        return locator;
    }
}