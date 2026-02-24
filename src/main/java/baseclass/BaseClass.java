package baseclass;

import Logs.Log;
import CommonCode.Commoncode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CruisePageActions;
import pages.HomePageActions;
import pages.HotelPageActions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Utils;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public CruisePageActions cruise;
    public WebDriverWait wait;
    public Commoncode cm=new Commoncode();
    public String url1;
    protected String url2;
    public HomePageActions home;
    public HotelPageActions hotelActions;

    @BeforeSuite
    public void setUp() throws  Exception{
       // url1 = Utils.fetchPropertyValue("URL1").toString();
        url2 = Utils.fetchPropertyValue("URL2").toString();
        if(Utils.fetchPropertyValue("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }else if(Utils.fetchPropertyValue("browser").equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(Utils.fetchPropertyValue("browser").equals("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        cm.implicitWait(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url2);
        home = new HomePageActions(driver);
        cruise=new CruisePageActions(driver);
       // Log.info("Launched URL1: " + url1 +"Driver started successfully");
        Log.info("Launched URL2: " + url2 +"Driver started successfully");
    }

    @AfterSuite
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            Log.info("Driver quit successfully.");
//        }
    }
}
