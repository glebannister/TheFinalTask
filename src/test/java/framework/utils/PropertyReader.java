package framework.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;
    private static final String PATH_TO_CONFIG = "src/test/resources/config.properties";
    private static final String PATH_TO_TEST_DATA = "src/test/resources/testData.properties";
    private static final String PATH_TO_WAITER_DATA = "src/test/resources/waiter.properties";
    private static final String PATH_TO_APP_API = "src/test/resources/appApi.properties";
    private static final String PATH_TO_TEST_RAIL = "src/test/resources/testRail.properties";

    private static void initPropertyReader(String path) {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(path);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException e) {
            LogUtil.error(e.toString());
        }
    }

    public static String getConfigValue(String key) {
        initPropertyReader(PATH_TO_CONFIG);
        return properties.getProperty(key);
    }

    public static String getDataValue(String key) {
        initPropertyReader(PATH_TO_TEST_DATA);
        return properties.getProperty(key);
    }
    public static String getWaiterValue(String key) {
        initPropertyReader(PATH_TO_WAITER_DATA);
        return properties.getProperty(key);
    }

    public static String getAppApiValue(String key) {
        initPropertyReader(PATH_TO_APP_API);
        return properties.getProperty(key);
    }
    public static String getTestRailValue(String key) {
        initPropertyReader(PATH_TO_TEST_RAIL);
        return properties.getProperty(key);
    }
}
