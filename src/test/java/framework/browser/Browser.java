package framework.browser;

import framework.utils.LogUtil;
import framework.utils.PropertyReader;
import framework.waits.Waits;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

final public class Browser {

    private Browser() { }

    public static WebDriver getDriver() {
        return WebDriverSingleton.getInstance();
    }

    public static void moveTo(String url) {
        getDriver().get(url);
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void quitBrowser() {
        getDriver().quit();
        WebDriverSingleton.setDriverNull();
    }

    public static void refreshPage() {
        LogUtil.info("Refreshing page");
        getDriver().navigate().refresh();
    }

    public static void addCookie(String key, String value) {
        LogUtil.info((String.format("Adding cookie %s %s", key, value)));
        getDriver().manage().addCookie(new Cookie(key, value));
    }

    public static String getWindowHandler(){
        return getDriver().getWindowHandle();
    }

    public static void switchToAnotherWindow(String windowHandler){
        LogUtil.info("Switching to another window");
        Waits.waitNumberOfWindows(Integer.parseInt(PropertyReader.getDataValue("numberOfWindowsTwo")));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!windowHandler.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToProjectsWindow(String windowHandler){
        LogUtil.info("Switching to projects window");
        Waits.waitNumberOfWindows(Integer.parseInt(PropertyReader.getDataValue("numberOfWindowsOne")));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(windowHandler.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static boolean closeCurrentWindow(String windowHandler){
        LogUtil.info("Closing window");
        getDriver().close();
        boolean isWindowClosed = false;
        Waits.waitNumberOfWindows(Integer.parseInt(PropertyReader.getDataValue("numberOfWindowsOne")));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!windowHandler.contentEquals(windowHandle)) {
                isWindowClosed = true;
                break;
            }
        }
        return isWindowClosed;
    }

    public static void makeScreenshot(String pathToScreenshot){
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToScreenshot));
        } catch (IOException e) {
            LogUtil.info(e.toString());
        }
    }

    public static void moveMouseAndClick(int xOffSet, int yOffSet){
        Actions actions = new Actions(getDriver());
        actions.moveByOffset(xOffSet,yOffSet).doubleClick().perform();
    }
}
