package framework.utils;

public class StringUtil {
    private static final String EMPTY_STRING = "";
    private static final String COLON = ":";
    private static final String SYMBOL_AT = "@";

    public static String replaceWithRegExpWithEmptyString(String string, String regExp) {
        return replaceWithRegExp(string, regExp, EMPTY_STRING);
    }

    public static String replaceWithRegExp(String string, String regExp, String replacement) {
        return string.replaceAll(regExp, replacement);
    }

    public static String substringBase64WithRegular(String base64, String regularFirst) {
      return base64.replace(regularFirst, EMPTY_STRING);
    }

    public static String baseAuthUrl(){
        return String.format(
                "%s%s%s%s%s%s",
                PropertyReader.getConfigValue("httpProtocol"),
                PropertyReader.getDataValue("userLogin"),
                COLON,
                PropertyReader.getDataValue("userPassword"),
                SYMBOL_AT,
                PropertyReader.getConfigValue("urlBody"));
    }

    public static String pathToScreenshot(String screenshotName){
        return String.format(
                "%s%s%s",
                PropertyReader.getConfigValue("pathToTestResources"),
                screenshotName,
                PropertyReader.getDataValue("imageFormat"));
    }

    public static String testStatusForChecking(String testStatus){
        return testStatus.charAt(0) + testStatus.substring(1).toLowerCase();
    }
}
