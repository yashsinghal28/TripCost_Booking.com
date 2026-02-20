package baseclass;

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
    public void setUp() {
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
        }
    }
}
