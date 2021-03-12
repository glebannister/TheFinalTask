package framework.waits;

import framework.browser.Browser;
import framework.elements.BaseElement;
import framework.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Waits {
    private final static int IMPLICIT_WAIT_2_SEC = Integer.
            parseInt(PropertyReader.getWaiterValue("implicitWaitTime"));
    private final static int WAIT_12_SEC = Integer.parseInt(PropertyReader.getWaiterValue("12sec"));
    private final static int WAIT_2_SEC = Integer.parseInt(PropertyReader.getWaiterValue("2secInMilliseconds"));
    private final static int WAIT_10_SEC = Integer.parseInt(PropertyReader.getWaiterValue("10secInMilliseconds"));

    public static void implicitWait(){
        Browser.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_2_SEC, TimeUnit.SECONDS);
    }

    public static void waitForVisibility(BaseElement element) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), WAIT_12_SEC, WAIT_2_SEC);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
    }

    public static void waitToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), WAIT_12_SEC, WAIT_2_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitNumberOfWindows(int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), WAIT_12_SEC, WAIT_2_SEC);
        wait.until(numberOfWindowsToBe(numberOfWindows));
    }

    public static void waitUntilAmountOfElements(By locator, int NumberOfElements){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), WAIT_10_SEC, WAIT_2_SEC);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, NumberOfElements));
    }
}
