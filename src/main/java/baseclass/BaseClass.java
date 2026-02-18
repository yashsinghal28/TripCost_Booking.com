package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    @BeforeTest
    public void setUp() throws Exception {
        if(Utils.fetchPropertyValue("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }else if(Utils.fetchPropertyValue("browser").equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(Utils.fetchPropertyValue("browser").equals("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(Utils.fetchPropertyValue("URL").toString());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
