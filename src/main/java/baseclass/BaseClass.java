package baseclass;

<<<<<<< HEAD

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
=======
import Logs.Log;
import CommonCode.Commoncode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CurisePage.CruisePageActions;
import pages.Homepage.HomePageActions;
import pages.Hotelpage.HotelPageActions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
>>>>>>> caa7a549c9f5368c1a9d2e9ab213bb9d9830108a

import java.time.Duration;
import java.util.Arrays;

public class BaseClass {
<<<<<<< HEAD

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
=======
    public static WebDriver driver;
    public CruisePageActions cruise;
    public WebDriverWait wait;
    public Commoncode cm=new Commoncode();
    public String url1;
    protected String url2;
    public HomePageActions home;
    public HotelPageActions hotelActions;

    @BeforeSuite
    public void setUp() {
        url1 = "https://www.booking.com";
        url2 = "https://cruises.booking.com";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cm.implicitWait(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        home = new HomePageActions(driver);
        Log.info("Launched URL1: " + url1);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Log.info("Driver quit successfully.");
>>>>>>> caa7a549c9f5368c1a9d2e9ab213bb9d9830108a
        }
    }
}