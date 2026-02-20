package baseclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Arrays;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        System.out.println("Initializing browser: " + browser);

        try {
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);

            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");

//                edgeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);

            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }

            int implicitWait = ConfigReader.getImplicitWait();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

            int pageLoadWait = ConfigReader.getPageLoadWait();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));

            driver.manage().window().maximize();

            String url = ConfigReader.getUrl();
            driver.get(url);
            System.out.println("Browser initialized successfully and navigated to: " + url);

        } catch (Exception e) {
            System.err.println("Error initializing browser: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize browser", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser closed successfully");
                System.out.println("===============================");
            } catch (Exception e) {
                try {
                    driver.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}