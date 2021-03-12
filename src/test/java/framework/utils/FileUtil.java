package framework.utils;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FileUtil {

    public static String uploadPathToFile(String pathToFile) {
        return String.format(
                "%s%s%s%s%s%s%s%s%s",
                System.getProperty("user.dir"),
                System.getProperty("file.separator"),
                pathToFile.substring(0, 3),
                System.getProperty("file.separator"),
                pathToFile.substring(4, 8),
                System.getProperty("file.separator"),
                pathToFile.substring(9, 18),
                System.getProperty("file.separator"),
                pathToFile.substring(19, 33));
    }

    public static String getBase64(String path) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(path));
        } catch (IOException e) {
            LogUtil.error(e.toString());
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
