package framework.utils;

import framework.enums.UploadWindowHotKeys;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class WindowUploadUtil {
    public static void uploadAvatarImage(String path) {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(Integer.parseInt(PropertyReader.getWaiterValue("2secInMilliseconds")));
            StringSelection stringSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            robot.setAutoDelay(Integer.parseInt(PropertyReader.getWaiterValue("1secInMilliseconds")));
            robot.keyPress(UploadWindowHotKeys.VK_CONTROL.getKey());
            robot.keyPress(UploadWindowHotKeys.VK_V.getKey());
            robot.keyPress(UploadWindowHotKeys.VK_E.getKey());
            robot.keyRelease(UploadWindowHotKeys.VK_CONTROL.getKey());
            robot.keyRelease(UploadWindowHotKeys.VK_V.getKey());
            robot.setAutoDelay(Integer.parseInt(PropertyReader.getWaiterValue("1secInMilliseconds")));
        } catch (AWTException e) {
            LogUtil.error(String.format("Error when upload image %s", e));
        }
    }
}
