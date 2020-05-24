package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    protected static Properties properties;
    public static WebDriver webDriver;
    private static String propertyFilePath = null;
    private static String driverPath;
    private static String browser;
    private static String os;


    public static void initiateTest() {
        fetchDataFromPropertiesFile();

        browser = properties.getProperty("browser").trim().toLowerCase();
        os = System.getProperty("os.name");

        switch (browser.toLowerCase()) {
            case "firefox":

            case "ie":

            case "opera":
                break;

            case "safari":
                break;

            default:
                if (os.contains("Linux"))
                    driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
                else if (os.contains("Mac OS X"))
                    driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
                System.setProperty("webdriver.chrome.driver", driverPath);
                webDriver = new ChromeDriver();
                break;
        }

        webDriver.manage().window().maximize();

        String webUrl = properties.getProperty("amazon.url");
        webDriver.get(webUrl);

    }

    public static void fetchDataFromPropertiesFile() {
        propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/application.properties";
        fetchConfiguration(propertyFilePath);
    }

    public static void fetchConfiguration(String propertyFilePath) {
        properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propertyFilePath);
            properties.load(input);

        } catch (IOException ex) {
            System.out.println("Error while loading property file.\n");
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
