package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "config.properties";

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Error loading config.properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


    public static String getBrowser() {
        return getProperty("browser") != null ? getProperty("browser").toLowerCase() : "chrome";
    }


    public static int getImplicitWait() {
        String wait = getProperty("implicit.wait");
        return wait != null ? Integer.parseInt(wait) : 10;
    }

    public static int getExplicitWait() {
        String wait = getProperty("explicit.wait");
        return wait != null ? Integer.parseInt(wait) : 20;
    }

    public static int getPageLoadWait() {
        String wait = getProperty("page.load.wait");
        return wait != null ? Integer.parseInt(wait) : 30;
    }

    public static String getUrl() {
        return getProperty("url") != null ? getProperty("url") : "https://cruises.booking.com/";
    }
}
