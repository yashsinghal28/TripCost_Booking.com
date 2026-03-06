package baseclass;

import Logs.Log;
import CommonCode.Commoncode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CruisePageActions;
import pages.HomePageActions;
import pages.HotelPageActions;
import utils.Utils;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public CruisePageActions cruise;
    public WebDriverWait wait;
    public Commoncode cm=new Commoncode();
    public String url1;
    public String url2;
    public HomePageActions home;
    public HotelPageActions hotelActions;

    @BeforeClass
    public void setUp() throws  Exception{
        url1 = Utils.fetchPropertyValue("URL1").toString();
        url2 = Utils.fetchPropertyValue("URL2").toString();
        if(Utils.fetchPropertyValue("browser").equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        else if(Utils.fetchPropertyValue("browser").equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(Utils.fetchPropertyValue("browser").equals("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        cm.implicitWait(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Log.info("Launched URL1 or URL2: " + url1 +"|" + url2 + " Driver started successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Log.info("Driver quit successfully.");
        }
    }
}
